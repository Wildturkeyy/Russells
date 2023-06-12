import os

from module import file_util, container_util

'''
    파일을 받아서 파일 별 tf_dict를 만들어 주는 클래스
    
'''
class Document() :
    # Field & Member Variable

    # Constructor

    # Methods

    def __init__(self):
        self.id = ''
        self.tf_dict = {}
        # self.id : 파일 명 (파일 id)
        # tf_dict : 어절 or 음절 별 빈도 계산
        
    '''
        Method
        1. 받아온 문서 읽기
        2. 문서 별 dict 파일 저장하기
        3. 저장된 tf dict 프린트 하기
    '''
    
    '''
        1. 받아온 문서 읽기
    
    '''
    def load(self, file_path:str, encoding:str, df_dict:dict, output_path:str):
        self.id = os.path.basename(file_path).split('.')[0]
        file = file_util.open_file(file_path, encoding, 'r')
        
        while True :
            line = file.readline()
            if not line:
                break
            
            line = file_util.preprocess(line)
            if line == None :
                continue
            
            for eojeol in line.split():
                container_util.add_str_int(self.tf_dict, eojeol, 1)
            
        for term in self.tf_dict:    
            container_util.add_str_int(df_dict, term, 1)
            
        self.save_dict(self.tf_dict, output_path, self.id, encoding)
        self.print_dict(self.id, self.tf_dict)

    '''
        2. 문서 별 dict 파일 저장하기
    '''
    def save_dict(self, out_dict:dict, output_path:str, file_name:str, encoding:str):
        # 파일을 저장할 경로 생성
        output_path = os.path.join(output_path, 'tf_dict_freq', (file_name + '.dict'))
        # dict 파일 빈도수별 정렬
        out_dict = container_util.sorted_dict(out_dict)
        # 파일 경로에 파일 생성
        file_util.open_file(output_path, encoding, 'w')
        # dict 파일 저장
        file_util.write_dict(output_path, encoding, out_dict, ' : ')
        
    '''
        3. 저장된 tf dict 프린트 하기
    '''
    def print_dict(self, file_id, out_dict):
        print('doc_id :', file_id)
        for term in out_dict:
            print(f'\t{term} : {out_dict[term]}')
        print()
        
            
        
        
        
                
        
        
# main
if __name__ == "__main__" :
    pass