from __init import *
from _common.log_util import *
from crawling.common.requests_util import *
import pandas as pd
import pymysql
import datetime
# 특수문자들이 엑셀파일로 저장될 때 에러를 내는데 아래 라이브러리를 import하면 저장되어서.. import 함
import xlsxwriter

start = datetime.datetime.now()
print(start)

############################################################################################################################################################
conn = pymysql.connect(host='host',user='user', password='0000',charset='utf8mb4',db='testdb')
cur = conn.cursor()

sql = "select idx, channelurl from testdb.tbl_name where condition;"
df = pd.read_sql(sql,conn)

conn.close()
############################################################################################################################################################

del_channelid, error_url_list = [], []
total_data = []
try:
    for tk_idx, tiktok_url in df.values:
        view_list = []
        likes_list = []
        cnt = 0
        try:
            # channelid가 나오면 정상적으로 request함 / channelid가 정상적으로 나오지 않으면 다시 requests 시도
            channelid, mc_check = None, False
            for _ in range(20):
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
            if channelid == None:
                continue

            url_code_list = tiktok_text.split('"user-post"')[-1].split('"browserList"')[0].split(':')[-1][1:-2].split(',')
            cnt = 0
            post_text, post_tag = [], []
            for url_code in url_code_list:
                post_url = tiktok_url +'/video/' + url_code[1:-1]
                
                # post_url
                for _ in range(20):
                    post_soup = get_soup(post_url)
                    try:
                        post_txt_list = post_soup.find('h1', {'data-e2e':'browse-video-desc'}).find_all('span', {'class':'tiktok-j2a19r-SpanText'})
                        if post_txt_list: break
                        else: continue
                    except: continue
                    
                if post_txt_list:
                    post_text_set, post_tag_set = set(), set()
                    for txt in post_txt_list:
                        t = txt.get_text().strip()
                        if len(t) <= 1 or t == '\xa0': continue
                        post_text_set.add(t)
                    for tag in post_soup.find_all('a', {'data-e2e':'search-common-link'}):
                        tg = tag.attrs['href']
                        if len(tg) <= 1: continue
                        tg = tg.split('/tag/')[-1]
                        post_tag_set.add(tg)
                    cnt +=1
                    if cnt == 30:
                        break
                    post_text += list(post_text_set)
                    post_tag += list(post_tag_set)
            total_data.append([tk_idx, channelid, '\n'.join(post_text) if post_text else None, '\n'.join(post_tag) if post_tag else None])
        except:
            error_url_list.append(tiktok_url)
except:
    print('error---------------------')
end = datetime.datetime.now()

print(end-start)
df = pd.DataFrame(total_data, columns=['idx', 'channelid', 'post_text', 'post_tags'])
if error_url_list:
    print('error', error_url_list)

df.to_excel(f'./crawling/src/file/post_tiktok_for_cate_{start.strftime("%Y%m%d")}.xlsx')