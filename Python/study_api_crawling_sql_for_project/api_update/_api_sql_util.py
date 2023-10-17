from __init import *
from _common.sql_util import *
import datetime

'''
    수집된 API 데이터를 db에 넣기 위한 함수
'''


################################################################################################################
# api_update를 위한 변수 및 코드

now = datetime.datetime.now()
date_now = datetime.datetime.now().strftime("%Y-%m-%d %H:%M:%S")

'''
    1. get_bef
     : 현재 시간에서 원하는 시간(분 단위)을 뺀 시간을 반환하는 함수
    2. get_bef_str
     : 현재 시간에서 원하는 시간(분 단위)을 뺀 시간의 str type 반환하는 함수 : "%Y%m%d%H%M"
    
    3. get_colname
     : df의 컬럼명을 ','로 구분된 str type으로 반환
    4. get_values
     : df의 value값들을 list화하고 그 값을 str type로 변경하여 반환
    5. get_dupli_value
     : df에서 unique column을 제외한 column들만 "{col} = VALUES({col})"값으로 반환하는 함수
    6. make_query
     : 새로 수집한 데이터를 기존 데이터에 추가할 때 변경된 unique값을 제외하고 변경될 수 있는 쿼리를 작성하는 함수
    7. insert_data
     : make_query() 함수로 만든 쿼리를 특정 db에 실행하여 데이터를 insert하는 함수
'''

'''
    1. get_bef
'''
def get_bef(minutes: int):
    '''
    - minutes : int
              : 현재 시간에서 뺄 시간 (분)
              
    ## return now-minutes (datetime type)
    '''
    return now - datetime.timedelta(minutes=minutes)

'''
    2. get_bef_str
'''
def get_bef_str(minutes: int):
    '''
    - minutes : int
              : 현재 시간에서 뺄 시간 (분)
              
    ## return now-minutes (str type)
    '''
    return get_bef(minutes).strftime("%Y%m%d%H%M")

# --------------------------------------------------------------------------------------------------------------------------------------------------------------
'''
    3. get_colname
'''
def get_colname(df : pd.DataFrame):
    '''
    - df : pd.DataFrame
         : column명을 반환 받을 df
    
    ## return "colname1, colname2, colname3, ..."
    '''
    cols = ', '.join(map(str, df))
    return cols

'''
    4. get_values
'''
def get_values(df : pd.DataFrame):
    '''
    - df : pd.DataFrame
         : value 값들을 반환받을 df
    
    ## return 
    '''
    # df.fillna("Null", inplace=True)
    values = str(df.values.tolist()).replace("[","(").replace("]",")")[1:-1]
    # values = values.replace("'Null'", "Null")
    values = values.replace("'np.NaN'", "Null")
    return values

'''
    5. get_dupli_value
'''
def get_dupli_value(df : pd.DataFrame, unique_col : str):
    '''
    - df : pd.DataFrame
         : 
    - unique_col : str
                 : unique key column name
    '''
    col_list = [f"{col} = VALUES({col})" for col in df.columns if col!= unique_col]
    return ', '.join(col_list)

'''
    6. make_query
'''
def make_query(df : pd.DataFrame, table_name : str, unique_col : str):
    '''
    - df : pd.DataFrame
         : DB에 넣을 데이터를 가지고 있는 df
    - table_name : 데이터를 넣을 DB의 table이름
    - unique_col : str
                 : table에 index나 unique key로 설정되어 있는 컬럼명
                 
    ## return sql_query
              unique col로 설정한 값을 제외하고 나머지 값은 update되는 query
    '''
    cols = get_colname(df)
    values = get_values(df)
    dupli_values = get_dupli_value(df, unique_col)

    sql_query = f"""INSERT INTO {table_name}({cols})
        VALUES{values}
        ON DUPLICATE KEY UPDATE
        {dupli_values};"""
    return sql_query

'''
    7. insert_data
'''
def insert_data(df : pd.DataFrame, table_name : str, unique_col : str, close = True,
                host=host, user=user, password=password, charset=charset, db_name=db_name):
    '''
    - df : pd.DataFrame
         : 추가할 데이터
    - table_name : str
                 : 데이터를 넣을 DB의 table 이름
    - unique_col : str
                 : table에 index나 unique key로 설정되어 있는 컬럼명
    - close : bool (default=True)
            : 전달된 query 실행 후 mysql.Connection 객체를 close 할지 여부 결정
    - host : str (default = "127.0.0.1")
           : 연결할 db host
    - user : str (default = "root")
           : db에 연결할 username
    - password : str (default = "0000")
               : db에 연결할 username의 password
    - charset : str (default = "utf8mb4")
              : 연결할 db의 charset
    - db_name : str (default = "testdb")
              : 연결할 db 이름
    '''
    sql_query = make_query(df, table_name, unique_col)
    sql_execute(sql_query, close=close, host=host, user=user, password=password, charset=charset, db_name=db_name)
