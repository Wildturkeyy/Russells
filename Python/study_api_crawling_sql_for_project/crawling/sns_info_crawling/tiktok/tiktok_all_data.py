from __init import *
from _common.log_util import *
from crawling.common.requests_util import *
from crawling.sns_info_crawling._sns_util import *

start = datetime.datetime.now()
file_path = "./crawling/src/"
log_path = "./crawling/sns_info_crawling/tiktok/"

"""
required_key = 채널에 꼭 추가되는 키워드!!

ex .) 틱톡커 > '문화예술'
      홍보 채널 > '홍보마케팅'
      없으면 None

"""
##########!!!!!!!!!!!!!!!!!! 꼭 변경해야함 !!!!!!!!!!!!!!!!!!##########
required_key = '문화예술'

tiktok_url_list = pd.read_excel( file_path + 'tiktok_url_list.xlsx')['tiktok_url'].to_list()
############################################################################################################################################################

total_data, del_channelid, error_url_list = [], [], []
try:
    '''
    # tiktok 계정에 post count를 세기 위한 driver
    # driver = start_driver('https://www.google.com', debugging=True, headless=False)
    '''
    cnt = 0
    for tk_idx, tiktok_url in enumerate(tiktok_url_list):
        if cnt > 3: break
        cnt += 1
        # tiktok_url로 받은 형식이 channelid 인지 url 형식인지 판단하고 channelid일 경우 url로 변경
        if "www.tiktok.com" not in tiktok_url:
            tiktok_url = "https://www.tiktok.com/@" + tiktok_url
            
        view_list, likes_list, post_url_list, cnt = [], [], [], 0
        try:
            # channelid가 나오면 정상적으로 request함 / channelid가 정상적으로 나오지 않으면 다시 requests 시도
            channelid, mc_check = None, False
            
            # range를 10번 반복한 이유 : requests로 tiktok url을 받을 때 error가 날 때도 있고 나지 않을 때도 있음.
            # error가 날 경우 다시 두 세번 반복해서 requests를 시도하면 정상적으로 받아짐
            for _ in range(10):
                tiktok_text, soup = get_soup(tiktok_url, head=True)
                checking = soup.find('p', {'class':'emuynwa1'})
                
                # 사라진 계정인지 확인
                if checking != None:
                    if ("Couldn't find this account" in checking.text) or ("이 계정을 찾을 수 없음" in checking.text):
                        channelid = tiktok_url.split('@')[1]
                        mc_check = True
                        del_channelid.append(channelid)
                        break
                    
                # 계정을 정상적으로 받았는지 확인
                try:
                    # 정상적으로 계정을 받았다면 break하여 반복해서 requests하는 것을 벗어남
                    channelid = soup.find('h1', {'data-e2e':'user-title'}).get_text().strip()
                    break
                except: pass
                
            if mc_check: continue
            if channelid == None:
                continue
            
            '''
            # tiktok 계정에서 post count를 세기 위한 코드
            # 화면 끝까지 스크롤 하기
            driver.get(tiktok_url)
            time.sleep(1)
            prev_height = driver.execute_script("return document. body.scrollHeight")
            while True:
                driver.execute_script("window.scrollTo(0,document.body.scrollHeight)")
                time.sleep(2)
                current_height = driver.execute_script("return document. body.scrollHeight")

                if current_height == prev_height:
                    break

                prev_height = current_height
            post 가져오기
            tbl = driver.find_element(By.CSS_SELECTOR, 'div[data-e2e="user-post-item-list"]')
            post_cnt = len(tbl.find_elements(By.CLASS_NAME, "e19c29qe8"))
            '''
            
            bio_list = []
            username = soup.find('h2').get_text()
            img_url = soup.select_one('span > img', {'shape':'circle'}).attrs['src']
            follower = soup.find('strong', {'data-e2e':'followers-count'}).get_text()
            sns_likes = soup.find('strong', {'data-e2e':'likes-count'}).get_text()
            bio = soup.find('h2', {'data-e2e':'user-bio'}).get_text()
            bio_list.append(bio)
            
            # url_추가
            extra_list = []
            try:
                link = soup.find_all('a', {'target':'_blank'})[-1].get_text()
                if link != '저작권':
                    extra_list.append(link)
            except: pass
            
            views = soup.find_all('strong', {'data-e2e':'video-views'})
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
                        likes_list.append(likes)
                        # view = views[i].get_text()
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
            if len(views_int) < 6:
                views_int = fill_none(views_int, 6)
                likes_int = fill_none(likes_int, 6)
                post_url_list = fill_none(post_url_list, 6)
                
            # bio에 적힌 정보를 토대로 추가 url or mail 수집
            category, loc_cate = get_cate(bio_list, bio=bio)
            if required_key == None:
                category = list(set(category))
            else:
                category = list(set(category + [required_key]))
            extras, contact = get_extra(bio_list)
            extra_list.extend(extras)

            extra_list = list(set(extra_list))
            contact = list(set(contact))
            f_cate = ', '.join(category) if len(category) else None
            f_loc_cate = ', '.join(loc_cate) if len(loc_cate) else None
            f_con = '\n'.join(contact) if len(contact) else None
            
            total_data.append(['틱톡', f_cate, f_loc_cate, channelid, username, tiktok_url, follower, sns_likes, bio, views_int[0], uploaded_date] + views_int[1:] + likes_int[1:] + post_url_list[1:] + ['\n'.join(extra_list), img_url, f_con])
        except:
            error_url_list.append(tiktok_url)
        # 수집한 데이터
        df = pd.DataFrame(total_data)
        df = convert_tiktok_all_data(df)
        # 삭제된 계정
        del_df = pd.DataFrame(del_channelid, columns=['channelid'])
        del_df.insert(1, 'delCheck', 'Y')
        df = pd.concat([df, del_df])
        df.insert(len(df.columns), 'modDate', start)
        df.to_excel(file_path + 'file/tiktok_final_all_test.xlsx')
except Exception:
    err = traceback.format_exc()
    ErrorLog(str(err), log_path+'Log_tiktok_total_data_error.txt')
    
end = datetime.datetime.now()
automessage = 'tiktok_total_auto.py start: '+str(start)+' end: '+str(end)
AutoLog(str(automessage), log_path+'Log_tiktok_total_data.txt')

print('걸린시간', end-start)