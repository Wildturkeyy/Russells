from webdriver_manager.chrome import ChromeDriverManager
from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By

import subprocess
import time

'''
    selenium을 사용해서 동적 크롤링할 때 사용하는 함수
'''

'''
    Chrome Webdriver 실행 함수
    1. start_driver
     : chrome driver를 처음 실행시키는 함수

    2. open_web
     : 실행된 driver에 url을 받아 새 탭으로 페이지를 여는 함수

    3. close_web
     : 현재 실행중인 페이지를 닫고 마지막 페이지로 driver를 이동하는 함수
     : open_web으로 새 창을 열고, 필요 데이터 수집 후 닫을 때 사용.
'''

'''
    1. start_driver
'''
def start_driver(url : str, debugging = False, headless = True):
    '''
    - url : str
          : 실행시킬 webpage url
    - debugging : bool (default = False)
                : 디버깅 여부
    - headless : bool (default = False)
               : headless 실행 여부 / debugging = True 에선 실행 불가능

    ## return driver
    '''
    ####  밑 두개 파일 위치 변경 필요...
    # service는 chromedriver.exe 위치
    # popen은 --remote-debugging 전만 chrome.exe 파일 위치 넣으면 됨...
    service = Service(ChromeDriverManager().install())

    if debugging:
        if headless:
            print('디버깅 모드에서 headless 실행 불가')
        option = Options()
        option.add_experimental_option('debuggerAddress', '127.0.0.1:9222')
        option.add_argument('--start-maximized')
        option.add_argument('--log-level=3')
        ##-------------!!!!!!!!!!!!!!!!!!!!-------------##
        subprocess.Popen(r'C:\Program Files\Google\Chrome\Application\chrome.exe --remote-debugging-port=9222 --user-data-dir="C:\chrometemp"')
    else:
        if headless:
            option = Options()
            option.add_argument('headless')
            option.add_argument('--start-maximized')
            option.add_experimental_option('excludeSwitches', ['enable-logging'])
        else:
            option = Options()
            option.add_argument('--start-maximized')
            option.add_experimental_option('excludeSwitches', ['enable-logging'])
    driver = webdriver.Chrome(service=service, options=option)
    driver.get(url)

    driver.implicitly_wait(2)
    driver.maximize_window()
    return driver

'''
    2. open_web
'''
def open_web(driver, url : str):
    '''
    - driver : 현재 driver
    - url : str
          : 새 탭에 오픈할 url

    ## return driver
    '''
    driver.execute_script('window.open("'+url+'");')
    time.sleep(2)
    driver.switch_to.window(driver.window_handles[-1])
    return driver

'''
    3. close_web
'''
def close_web(driver):
    '''
    - driver : 현재 driver

    ## return driver
    '''
    driver.close()
    driver.switch_to.window(driver.window_handles[-1])
    time.sleep(1)
    return driver