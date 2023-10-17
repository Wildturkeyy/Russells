import pandas as pd
import numpy as np

import requests
import datetime

import warnings
warnings.filterwarnings("ignore")

"""
    GetAPI  : 특정 API를 통해 데이터를 수집하고 전처리하는 클래스

    1. get_api

"""
class GetAPI:
    def __init__(self, dfCols : list):
        self.dfCols = dfCols
        self.Adf = pd.DataFrame(columns=self.dfCols)

        self.now = datetime.datetime.now()
        # self.now = datetime.datetime(2023, 8, 3, 18, 0)
        self.strnow = self.now.strftime("%Y%m%d%H%M")

        self.PageNo = 1
        self.NumOfRows = 999
        self.DataType = "json"

    def get_api(self, EndPoint : str, InfoVersion : str, ServiceKey : str, drop_dupl = False, drop_index = "", time_period = 30):
        
        bef = self.now - datetime.timedelta(minutes=time_period)
        strbef = bef.strftime("%Y%m%d%H%M")

        while True:
            url = f"{EndPoint}/{InfoVersion}?serviceKey={ServiceKey}&numOfRows={self.NumOfRows}&pageNo={self.PageNo}&inqryDiv=1&inqryBgnDt={strbef}&inqryEndDt={self.strnow}&type={self.DataType}"

            response = requests.get(url, verify=False)
            totalCnt = response.json()["response"]["body"]["totalCount"]

            if totalCnt == 0:
                break
            else:
                df = pd.DataFrame(response.json()["response"]["body"]["items"])

            if len(df) == 0:
                break

            df = df[self.dfCols]
            self.Adf = pd.concat([self.Adf, df], axis=0, sort=False)

            self.PageNo += 1

        self.Adf.replace("", np.NAN, inplace=True)
        self.Adf.reset_index(drop=True, inplace=True)

        if drop_dupl:
            self._drop_duplicates(columns=[drop_index])

        return self.Adf
    
    def _drop_duplicates(self, columns : list, keep = "last"):
        self.Adf.drop_duplicates(columns, keep=keep, inplace=True)
    
    def insert_col(self, index: int | list, colName : str | list, value):
        if type(index) != list:
            index, colName, value = [index], [colName], [value]
        
        for i in range(len(index)):
            self.Adf.insert(index[i], colName[i], value[i])
    
    def fill_na(self, columns : list, value):
        self.Adf[columns] = self.Adf[columns].fillna(value)
    
    def get_df(self):
        return self.Adf


if __name__ == "__main__":

    ServiceKey = "공공데이터에서 발급받은 key"
