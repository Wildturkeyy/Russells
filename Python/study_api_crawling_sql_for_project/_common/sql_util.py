from sqlalchemy import create_engine
import pymysql
import pandas as pd

'''
    수집된 데이터를 db에 넣기 위한 변수 및 함수
'''
'''
    - db 변수 설정
'''
################################################################################################################
# 변수
host = "127.0.0.1"
user = "root"
password = "0000"
charset="utf8mb4"
db_name="testdb"
port = "3306"
# ---------------------------------------------------------------------------------------------------------------

'''
    - db connect 및 sql query 적용 함수
    1. connect_db
     : 특정 db에 연결 후 Connection 객체 및 Cursor 객체 반환
     
    2. close_db
     : 연결된 db 작업을 모두 commit하고 close하는 함수
     
    3. sql_execute
     : 연결된 db에 sql query를 실행하는 함수
     
    4. sql_fetchall
     : 연결된 db에서 sql query를 실행하여 원하는 결과 값을 가져오는 함수
     
    5. append_data
     : pd.DataFrame으로 가지고 있는 데이터를 그대로 append하는 함수
'''

'''
    1. connect_db
'''
def connect_db(host=host, user=user, password=password, charset=charset, db_name=db_name):
    '''
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
    
    ## return conn, cursor
    '''
    conn = pymysql.connect(host=host, user=user, password=password, charset=charset, db=db_name)
    cursor = conn.cursor()
    return conn, cursor

'''
    2. close_db
'''
def close_db(conn):
    '''
    - conn : pymysql.connection
           : db와 연결된 Connection 객체
    '''
    conn.commit()
    conn.close()

'''
    3. sql_execute
'''
def sql_execute(querys : str | list, close = True, host=host, user=user, password=password, charset=charset, db_name=db_name):
    '''
    - querys : str | list
             : 연결된 db에서 실행할 query
             : 1개면 str, 여러 개면 list로 전달
    - close : bool (default = True)
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
              
    ## return conn, cursor (close=False)
    '''
    conn, cursor = connect_db(host=host, user=user, password=password, charset=charset, db_name=db_name)
    
    if type(querys) == str:
        querys = [querys]

    for query in querys:
        cursor.execute(query)
    
    if close:
        close_db(conn)
    else :
        return conn, cursor

'''
    4. sql_fetchall
'''
def sql_fetchall(query : str, close = True, host=host, user=user, password=password, charset=charset, db_name=db_name):
    '''
    - query : str
            : 연결된 db에서 실행할 query
    - close : bool (default = True)
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

    ## return result (close=True)
    ## return result, conn, cursor (close=False)
    '''
    conn, cursor = connect_db(host=host, user=user, password=password, charset=charset, db_name=db_name)
    
    cursor.execute(query)
    result = cursor.fetchall()
    
    if close:
        close_db(conn)
        return result
    
    return result, conn, cursor
# --------------------------------------------------------------------------------------------------------------------------------------------------------------
'''
    5. append_data
'''
def append_data(df : pd.DataFrame, table_name : str, if_exists = "append", host=host, user=user, port=port, password=password, charset=charset, db_name=db_name):
    '''
    - df : pd.DataFrame
         : db에 넣을 데이터
    - table_name : str
                 : 데이터를 넣을 table 이름
    - if_exists : str (default = append)
                : append = table_name이 존재할 경우 기존 테이블에 df 데이터를 추가로 적재
                : replace = table_name이 존재할 경우 기존 테이블의 데이터를 drop하고 df 데이터만 적재
                : fail = table_name이 이미 존재할 경우 ValueError
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
    engine = create_engine(f"mysql+pymysql://{user}:{password}@{host}:{port}/{db_name}?charset={charset}")
    conn = engine.connect()
    df.to_sql(name=table_name, con=engine, if_exists=if_exists, index=False)
    conn.close()

# sql_query = f"""INSERT IGNORE INTO {table_name}({cols})
#         VALUES{values}
#         ON DUPLICATE KEY UPDATE {unique_col} = VALUES({unique_col});
#         """