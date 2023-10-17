from _api_sql_util import *
from _GetAPI import GetAPI

import warnings
warnings.filterwarnings("ignore")

# 공공데이터 api를 통해 받은 데이터 중 원하는 값만 컬럼명으로 넣어서 db로 넣는 코드
# 0. ----------------------------------------------------------------------------------------

ServiceKey = "공공데이터에서 발급받은 key"

# 1.---------Get gtob API--------------------------------------------------------------------

EndPoint = "http://apis.data.go.kr/1230000/BidPublicInfoService04"
InfoVersion = "getBidPblancListInfoServcPPSSrch01"
db_table, db_unique_key = "db_table", "bidNtceNo"
dfCols = ["bidNtceDt","rgstDt","chgDt","rbidOpengDt","bidClseDt","opengDt","pqApplDocRcptDt","tpEvalApplClseDt","bidBeginDt","dcmtgOprtnDt","bidQlfctRgstDt","cmmnSpldmdAgrmntClseDt","bidNtceNo","bidNtceOrd","reNtceYn","rgstTyNm","ntceKindNm","intrbidYn","refNo","bidNtceNm","ntceInsttCd","infoBizYn","sucsfbidMthdCd","sucsfbidMthdNm","linkInsttNm","indstrytyLmtYn","d2bMngRgnLmtYn","chgNtceRsn","ntceSpecDocUrl1","ntceSpecDocUrl2","ntceSpecDocUrl3","ntceSpecDocUrl4","ntceSpecDocUrl5","ntceSpecDocUrl6","ntceSpecDocUrl7","ntceSpecDocUrl8","ntceSpecDocUrl9","ntceSpecDocUrl10","ntceSpecFileNm1","ntceSpecFileNm2","ntceSpecFileNm3","ntceSpecFileNm4","ntceSpecFileNm5","ntceSpecFileNm6","ntceSpecFileNm7","ntceSpecFileNm8","ntceSpecFileNm9","ntceSpecFileNm10","rbidPermsnYn","pqApplDocRcptMthdNm","tpEvalApplMthdNm","jntcontrctDutyRgnNm1","jntcontrctDutyRgnNm2","jntcontrctDutyRgnNm3","rgnDutyJntcontrctRt","dtlsBidYn","bidPrtcptLmtYn","prearngPrceDcsnMthdNm","totPrdprcNum","drwtPrdprcNum","asignBdgtAmt","presmptPrce","opengPlce","dcmtgOprtnPlce","ntceInsttNm","dminsttCd","dminsttNm","bidMethdNm","cntrctCnclsMthdNm","ntceInsttOfclNm","ntceInsttOfclTelNo","ntceInsttOfclEmailAdrs","exctvNm","cmmnSpldmdAgrmntRcptdocMethd","cmmnSpldmdCorpRgnLmtYn","bidNtceDtlUrl","bidNtceUrl","ppswGnrlSrvceYn","srvceDivNm","prdctClsfcLmtYn","mnfctYn","purchsObjPrdctList","untyNtceNo","cmmnSpldmdMethdCd","cmmnSpldmdMethdNm","brffcBidprcPermsnYn","dsgntCmptYn","arsltCmptYn","pqEvalYn","tpEvalYn","bfSpecRgstNo"]

get_api = GetAPI(dfCols)
get_api.get_api(EndPoint, InfoVersion, ServiceKey, drop_dupl=True, drop_index=db_unique_key, time_period=30)

get_api.insert_col(0, "regDate", date_now)
get_api.fill_na(["bidBeginDt", "bidClseDt", "rgstDt"], "1900-01-01 00:00:00")
df = get_api.get_df()

insert_data(df, table_name=db_table, unique_col=db_unique_key)
