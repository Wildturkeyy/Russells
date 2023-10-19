from __init import *
from common.webdriver_util import *
from common.requests_util import get_soup

'''
    유튜브 채널에서 비즈니스 정보를 얻기 위해 필요한 함수
    1. open_login_web
     : 새 탭에 google 로그인 페이지 열기
    2. check_login_page
     : google 로그인 페이지가 잘 열렸는지 확인
    3. input_id_pswd
    4. log_out
    5. get_business_info
'''
# def ip_port():
#     result = []
#     soup = get_soup("https://www.us-proxy.org/")
#     rows = soup.find('tbody').find_all('tr')
#     for row in rows:
#         https = row.find('td', {'class':'hx'}).text
#         if https == 'yes':
#             tds = row.find_all('td')
#             result.append([tds[0].text, tds[1].text])
#     return result
            
# def start_driver(url):
#     ip_port_list = ip_port()
#     for ip, port in ip_port_list:
#         proxy_options = {
#             "proxyType": "MANUAL",
#             "httpProxy": f"{ip}:{port}",
#             "ftpProxy": f"{ip}:{port}",
#             "sslProxy": f"{ip}:{port}",
#             }
#         try:
#             options = Options()
#             options.add_experimental_option('prefs', proxy_options)
#             options.add_argument('--start-maximized')
#             service = Service(r'C:\Users\two_p\OneDrive\바탕 화면\digitalNMD\chrome\chromedriver-win64\chromedriver.exe')
#             driver = webdriver.Chrome(service=service, options=options)
#             break
#         except:pass
#     driver.get(url)
#     return driver
    
# 로그인 페이지 열기
def open_login_web(driver):
    login_url = "https://accounts.google.com/InteractiveLogin/identifier?continue=https%3A%2F%2Fwww.google.com%2F%3Fhl%3Dko&ec=GAZAmgQ&flowEntry=ServiceLogin&flowName=GlifWebSignIn&hl=ko&ifkv=AXo7B7VpszszQdoY-H7NGngsNh8fD63lTfSfQ5SnErB-YWXCR2B9OQn_4X1nyyxHavRZ83i-u9U7AQ&passive=true&theme=glif"
    driver.execute_script('window.open("'+ login_url +'");')
    driver.switch_to.window(driver.window_handles[-1])
    time.sleep(1)
    return driver

def check_login_page(driver):
    try:
        acc_ele = driver.find_element(By.CLASS_NAME, 'BHzsHc')
        account = acc_ele.text
    except:
        account = ''
    if account == '다른 계정 사용':
        acc_ele.click()
        time.sleep(1)
    return driver

def input_id_pswd(driver, id_idx : int):
    # 아이디 입력
    id = "wwwowpartnercenter"
    if id_idx:
        id += str(id_idx)
    # id = "dinomadeu"
    login_id = driver.find_element(By.CLASS_NAME, 'Xb9hP').find_element(By.TAG_NAME, 'input')
    login_id.send_keys(id + '\n')
    time.sleep(2)
    # 비밀번호 입력
    pswd_input = driver.find_element(By.CLASS_NAME, 'Xb9hP').find_element(By.TAG_NAME, 'input')
    pswd_input.send_keys('cosmos737!' + '\n')
    driver.switch_to.window(driver.window_handles[-1])
    time.sleep(2)

    driver = close_web(driver)
    return driver

# 로그아웃
def log_out(driver):
    google = "https://www.google.com/"
    driver.execute_script('window.open("'+ google +'");')
    time.sleep(2)
    driver.switch_to.window(driver.window_handles[-1])
    time.sleep(2)
    driver.find_elements(By.CLASS_NAME, 'gb_d')[-1].click()
    time.sleep(2)
    iframe = driver.find_elements(By.TAG_NAME, 'iframe')[1]
    time.sleep(1)
    driver.switch_to.frame(iframe)
    time.sleep(1)
    driver.find_element(By.LINK_TEXT, '로그아웃').click()
    time.sleep(1)
    try:
        driver.find_elements(By.CSS_SELECTOR, 'span[jsname="V67aGc"]')[-1].click()
    except: pass
    driver = close_web(driver)
    return driver

def get_business_info(driver, id_use : int):
    business_info = []
    try:
        # 세부정보 확인하기
        # 비즈니스 클릭
        detail = driver.find_element(By.ID, 'details-container')
        detail.find_element(By.CLASS_NAME, 'yt-spec-touch-feedback-shape__fill').click()
        time.sleep(1)

        # recaptcha iframe
        iframe = driver.find_element(By.TAG_NAME, 'iframe')
        driver.switch_to.frame(iframe)
        driver.find_element(By.CLASS_NAME, 'recaptcha-checkbox-border').click()
        time.sleep(1)

        # recapcha 우회
        driver.switch_to.default_content()
        iframes = driver.find_elements(By.TAG_NAME, 'iframe')
        driver.switch_to.frame(iframes[-1])
        tab = driver.find_element(By.CLASS_NAME, 'rc-buttons').find_elements(By.TAG_NAME, 'div')
        tab[3].click()
        time.sleep(4)

        # 제출 클릭
        driver.switch_to.default_content()
        driver.find_element(By.ID, 'submit-btn').click()
        time.sleep(1)

        # 정보 얻기
        mail = None
        details = driver.find_element(By.CLASS_NAME, "style-scope ytd-channel-about-metadata-renderer").find_elements(By.TAG_NAME, 'tr')
        for detail in details:
            tds = detail.find_elements(By.TAG_NAME, 'td')
            detail = tds[0].text
            info = tds[-1].text
            business_info.append(' '.join([detail, info]))
            if detail.__contains__('비즈니스'):
                mail = info
        
        id_use += 1
    except:
        return driver, None, None, id_use
    
    return driver, '\n'.join(business_info), mail, id_use