import os

from module import file_util, container_util
from document import Document

'''
    문서의 TF, IDF를 계산해주는 클래스
'''

class TFIDFModel() :
    # Field & Member Variable

    # Constructor

    def __init__(self):
        self.encoding = 'UTF-8'
        
        self.documents = []
        self.df_dict = {}
        # encoding 유니코드 언어 설정
        # documents = 파일 리스트로 저장
        # 읽은 파일에 음절이 있는 지 없는 지 빈도 수 확인
        
    '''
        Method
        1. 파일 불러오기
    '''

    '''
        1. 파일 불러오기
    '''
    def file_load(self, input_path, output_path, encoding):
        file_paths = file_util.get_file_paths(input_path, False)
        
        for file_path in file_paths:
            # Document class를 불러와서 document별 tf_dict 생성
            document = Document()
            document.load(file_path, encoding, self.df_dict, output_path)
            
            # for 문을 벗어나면 document 파일이 지워지기 때문에 list에 append해줌
            self.documents.append(document)
        
        self.save_dict(output_path)   
        self.print_dict()
        
    def save_dict(self, output_path):
        output_path = os.path.join(output_path, 'df_dict.dict')
        self.df_dict = container_util.sorted_dict(self.df_dict)
        file_util.open_file(output_path, encoding, 'w')
        file_util.write_dict(output_path, encoding, self.df_dict, ' : ')
        
            
    def print_dict(self):
        print('df_dict len :', len(self.df_dict))
        for term in self.df_dict:
            print(f'\t{term} : {self.df_dict[term]}')
        print()
    
    
    
# main
if __name__ == "__main__" :
    input_path = 'input_file'
    output_path = 'output_file'
    encoding = 'UTF-8'
    
    tfidf_model = TFIDFModel()
    tfidf_model.file_load(input_path, output_path, encoding)