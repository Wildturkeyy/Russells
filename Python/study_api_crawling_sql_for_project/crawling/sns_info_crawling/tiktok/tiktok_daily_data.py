from __init import *
from _common.log_util import *
from crawling.common.requests_util import *
from crawling.sns_info_crawling._sns_util import get_int, fill_none, convert_tiktok_data

import pandas as pd
import datetime
import pymysql

start = datetime.datetime.now()
file_path = "./crawling/src/"
log_path = "./crawling/sns_info_crawling/tiktok/"
############################################################################################################################################################
conn = pymysql.connect(host='host',user='user', password='0000',charset='utf8mb4',db='testdb')
cur = conn.cursor()

sql = "select channelurl from testdb.tbl_name where condition;"
df = pd.read_sql(sql,conn)

conn.close()
tiktok_url_list =  df['channelurl'].tolist()
############################################################################################################################################################

total_data, del_channelid, error_url_list = [], [], []
try:
    for tiktok_url in tiktok_url_list:
        view_list, likes_list, comments_list, post_url_list, cnt = [], [], [], [], 0
        try:
            # channelid가 나오면 정상적으로 request함 / channelid가 정상적으로 나오지 않으면 다시 requests 시도
            channelid, mc_check = None, False
            for _ in range(10):
                tiktok_text, soup = get_soup(tiktok_url, head=True)
                checking = soup.find('p', {'class':'emuynwa1'})
                if checking != None:
                    if ("Couldn't find this account" in checking.text) or ("이 계정을 찾을 수 없음" in checking.text):
                        channelid = tiktok_url.split('@')[1]
                        mc_check = True
                        del_channelid.append(channelid)
                        break
                try:
                    channelid = soup.find('h1', {'data-e2e':'user-title'}).get_text().strip()
                    break
                except: pass
                
            if mc_check: continue
            if channelid == None: continue

            views = soup.find_all('strong', {'data-e2e':'video-views'})
            following = soup.find('strong', {'data-e2e':'following-count'}).get_text()
            follower = soup.find('strong', {'data-e2e':'followers-count'}).get_text()
            url_code_list = tiktok_text.split('"user-post"')[-1].split('"browserList"')[0].split(':')[-1][1:-2].split(',')
            for i, url_code in enumerate(url_code_list):
                post_url = tiktok_url +'/video/' + url_code[1:-1]
                
                # post_url 제대
                for _ in range(10):
                    post_soup = get_soup(post_url)
                    try:
                        if cnt == 0:
                            uploaded_date = post_soup.find('span', {'data-e2e':'browser-nickname'}).find_all('span')[-1].get_text()
                        likes = post_soup.find('strong', {'data-e2e':'like-count'}).get_text().strip()
                        comments_cnt =post_soup.find('p', {'class':'e1a7v7ak1'}).get_text().split()[0]
                        likes_list.append(likes)
                        comments_list.append(comments_cnt)
                        view_list.append(views[i].get_text())
                        post_url_list.append(post_url)
                        cnt += 1
                        break
                    except:
                        continue
                if cnt == 6:
                    break
                
            views_int = list(pd.DataFrame(view_list)[0].apply(get_int))
            likes_int = list(pd.DataFrame(likes_list)[0].apply(get_int))
            comments_int = list(pd.DataFrame(comments_list)[0].apply(get_int))
            
            if len(views_int) == 6:
                views_int = views_int[1:]
                likes_int = likes_int[1:]
                comments_int = comments_int[1:]
                post_url_list = post_url_list[1:]
            elif len(views_int) < 5:
                views_int = fill_none(views_int, 5)
                likes_int = fill_none(likes_int, 5)
                comments_int = fill_none(comments_int, 5)
                post_url_list = fill_none(post_url_list, 5)
            total_data.append([channelid, uploaded_date, following, follower] + views_int + likes_int + comments_int + post_url_list + ['N'])
        except:
            error_url_list.append(tiktok_url)

    # 수집한 전체 데이터
    df = convert_tiktok_data(pd.DataFrame(total_data))
    # 삭제된 데이터
    if del_channelid:
        del_df = pd.DataFrame(del_channelid, columns=['channelid'])
        del_df.insert(1, 'delCheck', 'Y')
        df = pd.concat([df, del_df])
    ##
    df.to_excel(file_path+'file/tiktok_daily_data.xlsx')
    df_tup = list(df.itertuples(index=False, name=None))



except Exception:
    err = traceback.format_exc()
    ErrorLog(str(err), log_path+'Log_tiktok_daily_data_error.txt')

if len(error_url_list):
    print(f'정상적으로 정보를 가져오지 못한 계정 :\n{", ".join(error_url_list)}')

end = datetime.datetime.now()
automessage = 'tiktok_daily_auto.py start: '+str(start)+' end: '+str(end)
AutoLog(str(automessage), log_path+'Log_tiktok_daily_data.txt')
