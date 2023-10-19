from __init import *
from crawling.common.webdriver_util import *
import pandas as pd
import datetime
'''
    SNS를 크롤링할 때 자주 사용되는 변수 설정 및 코드 함수화
'''

'''
    - 기본 변수
    1. key_df
     : keyword의 소그룹, 대그룹 파일을 import한 DataFrame
    2. keyword_list
     : key_df중 'kd_keyword' 컬럼의 값을 리스트화
    3. location
     : 지역을 카테고리화한 파일을 import한 DataFrame
    4. loc_list
     : loc_df중 '도시명' 컬럼의 값을 리스트화
'''
################################################################################################################
# 변수
key_df = pd.read_excel('./crawling/src/디지털홍보매체키워드.xlsx', usecols=['kd_keyword', 'category'])
keyword_list = key_df['kd_keyword'].to_list()
loc_df = pd.read_excel('./crawling/src/지역필터_230829.xlsx')
loc_list = loc_df['도시명'].to_list()

# tiktok_url 파일
tiktok_url_list = pd.read_excel('./crawling/src/tiktok_url_list.xlsx', usecols=['tiktok_url'])['tiktok_url'].to_list()

today = datetime.datetime.today().strftime('%Y%m%d')

# key_df = pd.read_excel('../src/디지털홍보매체키워드.xlsx', usecols=['kd_keyword', 'category'])
# keyword_list = key_df['kd_keyword'].to_list()
# loc_df = pd.read_excel('../src/지역필터_230829.xlsx')
# loc_list = loc_df['도시명'].to_list()

# # tiktok_url 파일
# tiktok_url_list = pd.read_excel('../src/tiktok_url_list.xlsx', usecols=['tiktok_url'])['tiktok_url'].to_list()

################################################################################################################

'''
    - SNS 데이터 크롤링 및 전처리 함수
    1. get_only_mail
     : 문장에서 양 옆의 띄어쓰기나 기호를 제외한 후 반환하는 함수

    2. get_youtube_info
     : 유튜브 채널에서 sns_id, follower, videos, bio, extra 데이터를 가져오는 함수

    3. get_tiktok_info
     : 틱톡 채널에서 sns_id, follower, likes, bio, extra 데이터를 가져오는 함수

    4. get_insta_info
     : 인스타그램 채널에서 sns_id, follower, posts, bio, extra 데이터를 가져오는 함수

    5. get_sns_info
     : SNS에서 필요 데이터를 가져오는 함수

    6. fill_none
     : 리스트에 원하는 숫자만큼 Value 값을 채우는 함수

    7. get_cate
     : 수집한 bio를 기준으로 카테고리를 뽑아내는 함수

    8. get_extra
     : 각 SNS 채널에서 extra sns 정보를 가져오는 함수
     
    9. get_int
     : posts, video, likes 등 수치를 int로 변환해주는 함수

    10. convert_date
     : 날짜를 며칠 전 ex. 1일전, 3일전 표시를 나타낼 수 있도록 int값으로 변환해주는 함수

    11. convert_agency_data
     : 수집한 agency data를 원하는 데이터 형식으로 변환해주는 함수
     
    11. convert_tiktok_data
     : 수집한 tiktok 데이터를 원하는 데이터 형식으로 변환해주는 함수
     
'''

'''
    1. get_only_mail
'''
def get_only_mail(mail):
    '''
    - mail : str
           : mail이 들어있다고 판단되는 str문장
           : 양 끝의 빈 칸, 기호를 제거후 반환

    ## return mail
    '''
    head, tail = False, False
    while True:
        mail = mail.strip()

        if head == False:
            if re.match(r'[a-z|_]', mail[0]):
                head = True
            else: mail = mail[1:]
        
        if len(mail) < 3:
            return None
        
        if tail == False:
            if re.match(r'[a-z]', mail[-1]):
                tail = True
            else: mail = mail[:-1]
            
        if len(mail) < 3:
            return None

        if head and tail:
            return mail

'''
    2. get_youtube_info : 유튜브 info 가져오기
'''
def get_youtube_info(driver, get_all_sns = False):
    '''
    - driver : 현재 driver
    - get_all_sns : bool (default = False)
                  : True = 모든 extra link를 반환
                  : False = 인스타, 틱톡, 유튜브를 제외한 extra link를 반환
                  
    ## return driver, sns_id, follower, video, description, extra list
    '''
    try:
        sns_id = driver.find_element(By.XPATH, '//*[@id="text"]').text
        follower = driver.find_element(By.XPATH, '//*[@id="subscriber-count"]').text.split()[1]
        video = driver.find_element(By.ID, 'videos-count').text.split()[1]
        # 세부정보
        tab_table = driver.find_element(By.ID, 'tabsContent')
        tabs = tab_table.find_elements(By.TAG_NAME, 'tp-yt-paper-tab')
        tabs[-2].click()
        time.sleep(1)
        bio = driver.find_element(By.CSS_SELECTOR, 'yt-formatted-string[id="description"]').text

        extra_link = driver.find_element(By.ID, 'link-list-container').find_elements(By.TAG_NAME, 'span')
        extra_list = []
        for i in range(1, len(extra_link), 2):
            extra = extra_link[i].text
            if get_all_sns:
                extra_list.append(extra)
            else:
                if pd.DataFrame([extra.lower()])[0].str.contains('insta|tiktok|youtube')[0]:
                    continue
                extra_list.append(extra)
    except :
        print('youtube error')
        return driver, None, None, None, '', []
    return driver, sns_id, follower, video, bio, extra_list

'''
    3. get_tiktok_info : tiktok 정보 가져오기
'''
def get_tiktok_info(driver):
    '''
    - driver : 현재 driver
    
    ## return driver, sns_id, follower, likes, description, extra list
    '''
    try:
        sns_id = driver.find_element(By.TAG_NAME, 'h1').text
        follower = driver.find_element(By.CSS_SELECTOR, 'strong[data-e2e="followers-count"]').text
        likes = driver.find_element(By.CSS_SELECTOR, 'strong[data-e2e="likes-count"]').text
        bio = driver.find_element(By.CSS_SELECTOR, 'h2[data-e2e="user-bio"]').text

        extra_list = []
        try:
            link = driver.find_elements(By.CSS_SELECTOR, 'a[target="_blank"]')[-1].text
            if (link != '저작권') and (pd.DataFrame([link.lower()])[0].str.contains('insta|youtube')[0] == False):
                extra_list.append(link)
        except: pass
    except:
        print('tiotok error')
        return driver, None, None, None, '', []

    return driver, sns_id, follower, likes, bio, extra_list

'''
    4. get_insta_info : instagram 정보 가져오기
'''
def get_insta_info(driver, url):
    '''
    - driver : 현재 driver
    - url : str
          : 정보를 가져오기 위한 instagram 계정의 url
          
    ## return driver, sns_id, follower, posts cnt, description, extra list
    '''
    try:
        if url[-1] == '/':
            url = url[:-1]
        sns_id = url.split('/')[-1]
        spans = driver.find_elements(By.CSS_SELECTOR, 'span[class="_ac2a"]')
        follower = spans[1].text
        posts = spans[0].text
        bio = driver.find_element(By.CLASS_NAME, 'x7a106z').text

        extra_list = []
        try:
            # link 클릭
            driver.find_element(By.CLASS_NAME, 'xyqdw3p').click()

            extra_links = driver.find_elements(By.CLASS_NAME, '_a9--')
            for extra in extra_links:
                extra_url = extra.find_elements(By.CSS_SELECTOR, 'div[dir="auto"]')[1].text
                if extra_url.__contains__('youtube'):continue
                if extra_url.__contains__('tiktok'):continue
                extra_list.append(extra_url)
        except: pass

    except:
        print('insta error')
        return driver, None, None, None, '', []
    return driver, sns_id, follower, posts, bio, extra_list

'''
    5. get_sns_info
'''
def get_sns_info(driver, url : str, sns : str, get_all_sns = False):
    '''
    - driver : current driver
    - url : str
          : sns webpage url
    - sns : str
          : instagram(insta) | youtube(you) | tiktok
          : url's sns name
    - get_all_sns : bool (default = False)
                  : for youtube info
                  
    ## return driver, sns_id, follower, posts(likes), description, extra list
    '''
    driver = open_web(driver, url)
    time.sleep(3)
    sns = sns.lower()
    if (sns == 'instagram') or (sns == 'insta'):
        driver, sns_id, follower, posts, bio, extra_list = get_insta_info(driver, url)
    elif (sns == 'youtube') or (sns == 'you'):
        driver, sns_id, follower, posts, bio, extra_list = get_youtube_info(driver, get_all_sns)
    elif sns == 'tiktok':
        driver, sns_id, follower, posts, bio, extra_list = get_tiktok_info(driver)

    driver = close_web(driver)
    
    return driver, sns_id, follower, posts, bio, extra_list

'''
    6. fill_none
'''
def fill_none(data_list : list, num : int, value = None):
    '''
    - data_list : list
                : 전달받은 list
    - num : int
          : 전달받은 list가 채워지길 원하는 최소 길이
    - value : (default = None)
            : 최소 길이를 만족하기 위해 채워 넣을 값
            
    ## return 수정된 data_list
    '''
    data_list = [data_list[0]] + data_list
    if len(data_list) < num:
        data_list += [value] * (num - len(data_list))
    return data_list

################################################################################################################
'''
    7. get_cate
'''
def get_cate(bios_list : list, condition = [], bio = None):
    '''
    * 사용 목적
     특정 계정의 페이지에 있는 설명글을 이용하여 계정의 카테고리와 지역 카테고리를 반환하기 위한 함수
     --
     특정 sns 계정 페이지에서 계정 설명글을 bio로 명명
     계정 페이지의 각 post에 있는 설명글과 bio를 합쳐서 넣은 list를 bios_list로 명명
     --
     bio와 bios_list에 있는 모든 글에서 특정 단어들이 포함되어 있다면 그 단어의 대분류 카테고리들을 반환
     지역 카테고리는 bio (계정 설명글)에서만 지역 정보가 포함되어 있다면 반환
     
     만약 게시글의 설명글 없이 계정 설명글만 bios_list에 있다면 bio 값은 따로 설정하지 않아도 됨.
    - bios_list : list
    - condition : list (default = [])
    - bio : (default = None)
    
    ## return category, area category
    '''
    bios = '\n'.join(bios_list)
    keyword = list(set(key for key in keyword_list if str(key) in str(bios)))
    category = key_df['category'][key_df['kd_keyword'].str.contains('|'.join(keyword))].drop_duplicates().to_list() if len(keyword) else []

    con = category + condition
    if len(con) and (con.__contains__('여행') or con.__contains__('관광') or con.__contains__('홍보마케팅')):
        if bio != None:
            bios = bio
        loc_key = [loc for loc in loc_list if str(loc) in str(bios)]
        loc_cate = loc_df['구분'][loc_df['도시명'].str.contains('|'.join(loc_key))].drop_duplicates().to_list() if len(loc_key) else []
    else:
        return category, []
    return category, loc_cate

'''
    8. get_extra
'''
def get_extra(bios_list : list):
    '''
    - bios_list : list
                : description을 모은 리스트
                
    ## return extra list, business contact
    '''
    extra_list = []
    busi_contact = []
    bios = '\n'.join(bios_list)
    bios = bios.replace('#', '\n')

    for b in bios.split('\n'):
        busi = False
        if pd.DataFrame([b.lower()])[0].str.contains('인스타|인스타그램|insta|instagram|ig|i.g|youtube|유튜브|유투브|유튭')[0]:
            if b.lower().__contains__(':'):
                extra_list.append(b)
                continue
        if pd.DataFrame([b.lower()])[0].str.contains('문의|비즈니스|mail|business|contact')[0]:
            busi = True
        for x in b.split():
            if pd.DataFrame([x])[0].str.contains('www.|http|.com|.co.kr|.net|@')[0]:
                mail = get_only_mail(x)
                if mail:
                    extra_list.append(mail)
                    if busi:
                        busi_contact.append(mail)
    return extra_list, busi_contact

################################################################################################################

'''
    9. get_int
'''
def get_int(data : str):
    '''
    - data : str
           : 크롤링하여 얻은 숫자 데이터
    
    ## return int data
    '''
    if (data == None) or (data == '없음') or (data == ''):
        return None
    if (data[-1] == 'K') or (data[-1] == '천'):
        return int(float(data[:-1]) * 1000)
    if data[-1] == '만':
        return int(float(data[:-1]) * 10000)
    if data[-1] == 'M':
        return int(float(data[:-1]) * 1000000)
    if (data[-1] == 'B'):
        return int(float(data[:-1]) * 1000000000)
    return int(data)

'''
    10. convert_date
'''
def convert_date(data : str):
    '''
    - data : str
           : 크롤링하여 얻은 날짜 데이터
    
    ## return int data (오늘 날짜부터 data가 며칠 전인지 반환)
    '''
    today = datetime.datetime.today()
    day_compare = datetime.datetime.today()
    if data.__contains__('분') or data.__contains__('m'):
        return 0
    elif data.__contains__('일'):
        return int(data.split('일')[0])
    elif data.__contains__('d'):
        return int(data.split('d')[0])
    elif data.__contains__('주'):
        return int(data.split('주')[0].strip()) * 7
    elif data.__contains__('w'):
        return int(data.split('w')[0].strip()) * 7
    elif data.__contains__('시간'):
        hour = int(data.split('시간')[0].strip())
        day_compare = today - datetime.timedelta(hours=hour)
    elif data.__contains__('h'):
        hour = int(data.split('h')[0].strip())
        day_compare = today - datetime.timedelta(hours=hour)
    elif data.count('-') == 1:
        data = today.strftime('%Y-') + data
        day_compare = datetime.datetime.strptime(data, '%Y-%m-%d')
    days = today - day_compare
    return days.days

'''
    11. convert_agency_data
'''
def convert_agency_data(df : pd.DataFrame):
    '''
    - df : pd.DataFrame
         : 크롤링하여 수집한 agency의 creator들 정보
         
    ## return 변경된 df
    '''
    df.columns = ['agency', 'category', 'location', 'username', 'channel', 'channel_id', 'followers', 'posts', 'channel_url', 'extra', 'img_url', 'contact']
    df['followers'] = df['followers'].str.replace('명', '')
    df['posts'] = df['posts'].str.replace('개', '')
    df['followers'] = df['followers'].apply(get_int)
    df['posts'] = df['posts'].apply(get_int)

    df['channel'] = df['channel'].str.lower()
    df['channel'].replace('insta', 'instagram', inplace=True)
    df['channel'].replace('you', 'youtube', inplace=True)
    return df

'''
    12. convert_tiktok_all_data
'''
def convert_tiktok_all_data(df : pd.DataFrame):
    '''
    - df : pd.DataFrame
         : 필요한 모든 데이터를 수집한 tiktok data
         
    ## return 변경된 df
    '''
    mc_view = [f'mc_view{i}' for i in range(1, 6)]
    mc_like = [f'mc_like{i}' for i in range(1, 6)]
    mc_comments = [f'mc_comments{i}' for i in range(1, 6)]
    mc_contents = [f'mc_contents{i}' for i in range(1, 6)]
    df.columns = ['mc_channeltype', 'mc_category', 'mc_area', 'mc_channelid', 'mc_channelname', 'mc_channelurl', 'mc_following', 'mc_follower', 'mc_like', 'mc_description', "mc_view", "mc_postdate"] + mc_view + mc_like + mc_comments + mc_contents + ["mc_extra", "mc_imageurl", "mc_contact"]
    df['mc_postdate'] = df['mc_postdate'].apply(convert_date)
    df['mc_check'] = df['mc_postdate'].apply(lambda x: 'N' if x > 60 else 'Y')
    df['mc_follower'] = df['mc_follower'].apply(get_int)
    df['mc_like'] = df['mc_like'].apply(get_int)
    return df

'''
    13. convert_tiktok_data
'''
def convert_tiktok_data(df : pd.DataFrame):
    '''
    - df : pd.DataFrame
         : 매일 변경된 정보를 수집한 tiktok data
         
    ## return 변경된 df
    '''
    mc_view = [f'mc_view{i}' for i in range(1, 6)]
    mc_like = [f'mc_like{i}' for i in range(1, 6)]
    mc_comments = [f'mc_comments{i}' for i in range(1, 6)]
    mc_contents = [f'mc_contents{i}' for i in range(1, 6)]
    df.columns = ['mc_channelid', 'mc_postdate', 'mc_following', 'mc_follower'] + mc_view + mc_like + mc_comments + mc_contents + ['mc_delCheck']
    df['mc_postdate'] = df['mc_postdate'].apply(convert_date)
    df['mc_postdate'] = df['mc_postdate'].apply(lambda x: 'N' if x > 60 else 'Y')
    return df