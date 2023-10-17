from __init import *
from common.webdriver_util import *
from selenium.webdriver.support.ui import Select
from selenium.webdriver import ActionChains
import pandas as pd

'''
 1. 함수 정의

  - 1) Dropdown할 위치 Select 후 특정 텍스트 선택하여 바꾸기
  - 2) XPATH를 이용하여 특정 위치에서 TEXT값 추출하기. 없다면 'NONE'값 반환
'''
# 1) Dropdown할 위치 Select 후 특정 텍스트 선택하여 바꾸기
def select_dropdown(driver, xpath_str : str, select_txt : str):
    dropdown = Select(driver.find_element(By.XPATH, xpath_str))
    dropdown.select_by_visible_text(select_txt)
    time.sleep(2)

# 2) XPATH를 이용하여 특정 위치에서 TEXT값 추출하기. 없다면 'NONE'값 반환
def get_text(driver, xpath_str : str):
    try:
        return driver.find_element(By.XPATH, xpath_str).text
    except:
        return None


'''
 2. 기본 설정
'''
url = f"https://www.culture.go.kr/space/facility.do?sido=%EC%84%9C%EC%9A%B8&gugun=%EC%A2%85%EB%A1%9C%EA%B5%AC&facilityCode=&searchKeyword="

'''
 3. 문화포털 공간 정보 크롤링
'''
driver = start_driver(url, headless=False)
action = ActionChains(driver)

# 첫 번째 시도 드롭다운의 TEXT 가져와서 LIST로 저장
# 1번은 전체이므로 제외
sido_list = driver.find_element(By.XPATH, '//*[@id="sido_cultureFac"]').text.split()[1:]
# sido_list = ['충북']
place_list = ["공연장", "기타문화공간"]

# 빈 Adf 데이터프레임 생성, Adf에 데이터를 추가하기 용이하게 cnt 변수 설정
Adf = pd.DataFrame(columns=['시도', '군구', '문화시설', '공간이름', '주소', '상세주소', '전화번호1', '전화번호2', '휴관일', '홈페이지', '상세정보'])
cnt = 0

# sido_list를 순차적으로 선택
for sido in sido_list:
    select_dropdown(driver, '//*[@id="sido_cultureFac"]', sido)
    
    # 선택한 sido 안에 있는 구군의 리스트 불러오기
    gugun_pos = driver.find_element(By.XPATH, '//*[@id="gugun_cultureFac"]')
    # 첫번째는 전체이므로 제외
    gugun_list = gugun_pos.text.split("\n")[1:]

    # 생성한 구군 list를 순차적으로 선택
    for gugun in gugun_list:
        gugun = gugun.strip()
        if gugun == '': continue
        select_dropdown(driver, '//*[@id="gugun_cultureFac"]', gugun.strip())
        
        # 초기 설정한 place를 순차적으로 선택
        for place in place_list:
            select_dropdown(driver, '//*[@id="facilityCode_cultureFac"]', place)

            # 검색 드롭다운 클릭 후, 검색 로고 클릭
            # scroll_up = driver.find_element(By.XPATH, '//*[@id="search_cultureFac"]/div[1]/p[1]')
            scroll_up = driver.find_elements(By.CSS_SELECTOR, 'button[class="btn-search"]')[1]
            action.move_to_element(scroll_up).perform()
            driver.find_element(By.XPATH, '//*[@id="search_cultureFac"]/div[2]/div[4]').click()
            driver.find_element(By.XPATH, '//*[@id="search_cultureFac"]/div[2]/div[4]/button').click()
            time.sleep(1)

            # 하단의 페이지 숫자 리스트 생성
            pages = driver.find_element(By.XPATH, '//*[@id="area_table_type02"]/div/div')
            page_list = pages.text.split()

            # 페이지를 순차적으로 클릭
            for page in page_list:
                if page != '1':
                    pages = driver.find_element(By.XPATH, '//*[@id="area_table_type02"]/div/div')
                    pages.find_element(By.PARTIAL_LINK_TEXT, page).click()
                time.sleep(3)

                # 각 페이지의 자세히 보기 element list 생성
                info_click_list = driver.find_elements(By.LINK_TEXT, "자세히 보기")
                # 순차적으로 '자세히 보기'클릭
                for click in info_click_list:
                    click.click()
                    time.sleep(2)

                    title = get_text(driver, '//*[@id="contents"]/div[2]/div/div[1]/p')
                    address1 = get_text(driver, '//*[@id="location"]/div[1]/div[2]/div[2]/div/span')
                    address2 = get_text(driver, '//*[@id="location"]/div[1]/div[2]/div[4]/div/span')
                    tel = get_text(driver, '//*[@id="location"]/div[1]/div[3]/div[2]/div/span').split(',')
                    holiday = get_text(driver, '//*[@id="contents"]/div[2]/div/div[2]/div[2]/dl/dd[4]')
                    webpage = get_text(driver, '//*[@id="location"]/div[1]/div[3]/div[4]/div/span/a')
                    info = ' '.join(get_text(driver, '//*[@id="contents"]/div[2]/div/div[2]/div[2]/dl/dd[5]').split())
                    
                    Adf.loc[cnt] =[sido, gugun, place, title, address1, address2, tel[0].strip(), tel[1].strip() if len(tel) > 1 else None, holiday, webpage, info]
                    cnt += 1
                    driver.back()
                    time.sleep(3)

driver.quit()

Adf.reset_index(drop=True, inplace=True)
Adf.replace(['-'], None, inplace=True)
Adf.to_excel('./문화공간.xlsx')