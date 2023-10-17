import requests
from bs4 import BeautifulSoup

'''
    - 입찰 공고 크롤링 함수
    1. get_soup
    
     : Request 및 BeautifulSoup을 사용하여 url의 html 코드를 가져오는 함수
'''

def get_soup(url, head=False):
    '''
    - url : str
          : html 값을 가져올 webpage url
    - head : bool (default = False)
    
    ## return html text, html code (head=True)
    ## return html code (head=False)
    '''
    res = requests.get(url)
    soup = BeautifulSoup(res.text, 'html.parser')
    if head:
        return res.text, soup
    else:
        return soup