from __init import *
from sns_info_crawling.youtube_business_contact._youtube_util import *
import pandas as pd

you_url_list = ["https://www.youtube.com/@mwomga/", "https://www.youtube.com/@osaka544", "https://www.youtube.com/@BOISOTV/about", "https://www.youtube.com/@user-ok2vx7fe3r/about", "https://www.youtube.com/@cook82/about", "https://www.youtube.com/@user-et6pk3bo9s/about", "https://www.youtube.com/@wndrb1123/about", "https://www.youtube.com/@hxxax/about", "https://www.youtube.com/@RYUCAMP/about", "https://www.youtube.com/@Rilaccoco/about", "https://www.youtube.com/@DDUADDUJI/about", "https://www.youtube.com/@yeon_s_/about", "https://www.youtube.com/@studioudada_dee/about", "https://www.youtube.com/@cobig99/about", "https://www.youtube.com/@foodtravelkorea/about", "https://www.youtube.com/@herehotple/about", "https://www.youtube.com/@mukkong/about", "https://www.youtube.com/@dogodog/about", "https://www.youtube.com/@tastytastykr/about", "https://www.youtube.com/@hakong-/about", "https://www.youtube.com/@goneunjin/about", "https://www.youtube.com/@trip_playlist/about", "https://www.youtube.com/@annyeong_ajeossi/about", "https://www.youtube.com/@_jejelog/about", "https://www.youtube.com/@all.about.20s/about"]

total_data, id_use, id_index = [], 0, 0
driver = start_driver('https://www.google.com/', debugging=True, headless=False)

for i, you_url in enumerate(you_url_list):
    if you_url[-1] == '/': you_url = you_url[:-1]
    if you_url[-6:] != '/about': you_url += '/about'
    if id_use%6 == 5 or i == 0:
        try:
            driver = log_out(driver)
        except:
            driver = close_web(driver)
        driver = open_login_web(driver)
        driver = check_login_page(driver)
        driver = input_id_pswd(driver, id_index)
    driver.get(you_url)
    time.sleep(2)

    try:
        driver, business_info, mail, id_use = get_business_info(driver, id_use)
        # print(business_info, mail, id_use)
        # 결과 값이 나온 경우에만 total_data로 append
        if business_info and mail:
            total_data.append([you_url.split('/')[-2][1:], business_info, mail])
    except:
        pass

    if id_use ==5:
        if id_index == 9:
            break
        id_index += 1
        id_use == 0
    if id_index == 11: break

df = pd.DataFrame(total_data, columns=['channelid', 'detail_info', 'mail'])
print(df)
