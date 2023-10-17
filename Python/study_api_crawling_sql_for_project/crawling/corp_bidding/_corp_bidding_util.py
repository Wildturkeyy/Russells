from __init import *

from crawling.common.requests_util import *
from crawling.common.webdriver_util import *

import pandas as pd
import datetime


'''
    기업 입찰 사이트를 크롤링 할 때 자주 사용되는 변수 설정 및 코드 함수화
'''

'''
    - 기본 변수
    1. df_list
     : 수집한 각 입찰 사이트의 데이터를 모으는 리스트
    2. today
     : 오늘 날짜 년-월-일
    3. now
     : 오늘 날짜 및 시간 년-월-일 시-분-초
    4. days, days_mini
     : 30일 뺀 날짜
'''

########################################################################################################################################
# 변수
df_list = []

today = datetime.datetime.today().strftime('%Y-%m-%d')
now = datetime.datetime.now().strftime("%Y-%m-%d %H:%M:%S")
days = (datetime.datetime.now() - datetime.timedelta(days=30)).strftime('%Y-%m-%d')
days_mini = (datetime.datetime.now() - datetime.timedelta(days=30)).strftime('%y-%m-%d')

########################################################################################################################################

'''
    - 입찰 공고 크롤링 함수
    1. get_post
     : Chrome Webdriver를 통해 open한 페이지에서 특정 테이블을 한 줄씩 element로 잡아 반환하는 함수
     : 공고 페이지에서 테이블 형식으로 된 데이터를 수집할 때 사용

    2. post_info
     : post element를 받아 td element 리스트, a element의 href 및 text 반환
     : soup, driver 모두 사용 가능

    3. get_text_driver
     : Chrome webdriver를 이용하여 받은 element의 text값 추출 및 strip() 후 반환
    
    4. get_text_soup
     : Request를 이용하여 받은 element의 text값 추출 및 strip() 후 반환

    5. get_str:
     : 한 개 또는 다수의 element (list 형태)를 받아 text값 추출 및 strip() 후 반환
     : soup, driver 모두 사용 가능

    6. insert_data
     : 수집한 기업 입찰 공고의 데이터를 DataFrame 형식으로 변환 후, 특정 일자(days) 이후의 데이터만 df_list에 append하는 함수
'''
########################################################################################################################################

'''
    1. get_post
'''
def get_post(driver, xpath :str, tr = 'tr'):
    '''
    - driver : 현재 driver
    - xpath : str
            : 얻고 싶은 데이터의 테이블 xpath
    - tr : str (default = 'tr')
         : 테이블의 각 열
    '''
    table = driver.find_element(By.XPATH, xpath)
    posts = table.find_elements(By.TAG_NAME, tr)
    return posts

'''
    2. post_info
'''
def post_info(post, td = 'td', text = 'a', href = 'href', lib = 'soup'):
    '''
    - post : element
           : 수집하고자 하는 테이블 열의 element
    - td : str (default = 'td')
         : 얻고자 하는 데이터가 여러개 들어있는 TAG_NAME
    - text : str (default = 'a')
           : title 등 추출할 text가 있는 TAG_NAME
    - href : str (default = 'href')
           : text를 추출하기 위해 얻은 element의 url 혹은 href 값
    - lib : str (default = 'soup')
          : driver | soup
          : 넘겨준 element가 driver형식인지 soup형식인지 알려주는 값

    ## return tds, title, url (td element list, text of tag a, href value of tag a)
    '''
    if lib == 'driver':
        tds = post.find_elements(By.TAG_NAME, td)
        a = post.find_element(By.TAG_NAME, text)
        url = a.get_attribute(href)
        title = get_text_driver(a)

    elif lib == 'soup':
        tds = post.find_all(td)
        a = post.find(text)
        url = a.attrs[href]
        title = get_text_soup(a)

    else:
        raise ValueError('lib 값으로 "driver" 혹은 "soup" 값 입력')
    
    return tds, title, url

########################################################################################################################################

'''
    3. get_text_driver
'''
def get_text_driver(element):
    '''
    - element : element
              : Chrome driver를 통해 받은 element의 text 추출 및 strip()
    
    ## return text
    '''
    return element.text.strip()

'''
    4. get_text_soup
'''
def get_text_soup(element):
    '''
    - element : element
              : Chrome driver를 통해 받은 element의 text 추출 및 strip()
    
    ## return text
    '''
    return element.get_text().strip()

'''
    5. get_str
'''
def get_str(element, lib = 'soup'):
    '''
    - element : element
              : text 추출할 element
    - lib : str (default = 'soup')
          : driver | soup
          : 넘겨준 element가 driver형식인지 soup형식인지 알려주는 값

    ## return text (list type)
    '''
    if type(element) != list:
        element = [element]

    text_list = []
    if lib == 'driver':
        get_string = get_text_driver
    elif lib == 'soup':
        get_string = get_text_soup
    else:
        raise ValueError('lib 값으로 "driver" 혹은 "soup" 값 입력')
    
    for ele in element:
        text_list.append(get_string(ele))

    if len(text_list) == 1:
        return text_list[0]
    return text_list

########################################################################################################################################

'''
    6. insert_data
'''
def insert_data(data_list : list, company : str):
    '''
    - data_list : list
                : 입찰 공고에서 수집한 데이터 (공고의 idx, 공고이름, 공고 올라온 날짜, 공고 url)
    - company : str
              : 입찰 공고를 올린 회사 이름

    ## df_list에 생성된 DataFrame append
    ## return 없음
    '''
    df = pd.DataFrame(data_list, columns=['b2b_idx', 'b2b_name', 'b2b_date', 'b2b_url'])
    df = df[df["b2b_date"] >= days]
    df['b2b_regDate'] = now
    df['b2b_company'] = company
    df_list.append(df)
