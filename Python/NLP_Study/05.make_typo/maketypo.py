import re, os

from module import file_util, container_util
from module.jamolist import CHO, JUNG, JONG, FIRST_HANGUL_UNICODE, LAST_HANGUL_UNICODE, DEFAULT_COMPOSE_CODE

class MakeTypo() :
    '''
        정타인 문서 파일을 랜덤하게 오타로 만들어주는 클래스
    '''
    # Field & Member Variable

    # Constructor

    def __init__(self):
        self.encoding = 'UTF-8'
        
        self.typo_file_list = []
        

    '''
        Method
        1. load_file : 문서를 불러오는 함수
        2. 자모를 분리하는 함수
        3. 한글의 unicode 및 CHO, JUNG, JONG 리스트에서 자모의 index를 가져오는 함수
        4. 랜덤으로 typo로 만들어 주는 함수
    '''
    
    '''
        1. load_file : 문서를 불러오는 함수
    '''
    def load_file(self, infile_dir, encoding):
        filepaths = file_util.get_file_paths(infile_dir, False)
        for filepath in filepaths:
            file = file_util.open_file(filepath, encoding, 'r')

            while True:
                line = file.readline()

                if not line:
                    break

                line = line.strip()
                if line == None:
                    continue

                for eojeol in line.split():
                    emjeol_jamo = []
                    for emjeol in eojeol:
                        jamo = self.divide_jamo(emjeol)
                        emjeol_jamo.append(jamo)
            
                    eojeol_jamo = DEFAULT_COMPOSE_CODE.join(emjeol_jamo)
                    print(eojeol_jamo)


    '''
        2. 자모를 분리하는 함수
    '''
    def divide_jamo(self, emjeol):
        if re.match(r'[ㄱ_ㅎ|가-힣]', emjeol):
            chosung_idx, junsung_idx, jongsung_idx = self.get_unicode_number(emjeol)
            return CHO[chosung_idx] + JUNG[junsung_idx] + JONG[jongsung_idx]

        else : 
            return emjeol
        

    '''
        3. 한글의 unicode 및 CHO, JUNG, JONG 리스트에서 자모의 index를 가져오는 함수
    '''
    def get_unicode_number(self, emjeol):
        emjeol_code = ord(emjeol)
        chosung_index = int((emjeol_code - 44032) / 588)
        jungsung_index = int((emjeol_code - 44032 - (chosung_index * 588)) / 28)
        jongsung_index = int((emjeol_code - 44032 - (chosung_index * 588) - (jungsung_index * 28)))
        return chosung_index, jungsung_index, jongsung_index


    '''
        4. 랜덤으로 typo로 만들어 주는 함수
    '''
    def make_typo(self):
        pass


    '''
        print
    '''
    # def print_(self):
    #     print(CHO[1])
    #     print(CHO.index('ㄱ'))



# main
if __name__ == "__main__" :
    encoding = 'UTF-8'
    input_file_path = '02.NLP/input_file'

    maketypo = MakeTypo()
    maketypo.load_file(input_file_path, encoding)
    # maketypo.print_()