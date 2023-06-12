import os

from module import string_util
from module import file_util
from module import container_util

class SejongFreqMaker :
    '''
        문장, 어절, 형태소 단위 빈도 계산하는 모듈

        Constructor
        Class 내부에서 사용할 멤버 변수를 초기화 하여 선언
        초기 class 선언 시 input 받을 파일 경로, 유니코드 encoding 종류, 어절을 나누는 구분자를 입력 받음
    '''

    def __init__(self) :
        self.encoding = "UTF-8"

        self.delim_morph = " + "
        self.delim_morph_lex_tag = "/"

        self.sentence_dict = {}
        self.eojeol_dict = {}
        self.emjeol_dict = {}
        self.morph_tag_lex_dict = {}

        # sentence_dict = 문장 빈도 계산
        # - output : {sentence : count}
        # eojeol_dict = 어절 빈도 계산
        # - output : {eojeol : count}
        # emjeol_dict = 음절 빈도 계산
        # - output : {emjeol_dict : count}
        # morph_tag_lex_dict = 형태소 tag별 어휘 빈도 계산
        # - output : {morph_lex : {morph_tag : count}}

    '''
        Methods
        해당 클래스의 동작 부분으로 각각의 함수들은 아래의 기능을 수행한다.
        1. 빈도 계산 폴더 생성
    '''

    '''
        1. 빈도 계산 폴더 생성

    '''
    def make_freq_folder(self, in_dir: str, encoding: str, delim_key: str) :
        # 빈도를 계산하는 폴더를 만드는 함수
        # in_dir : 빈도를 계산한 문서가 들어있는 경로
        # encoding : 유니코드 인코딩 종류
        # delim_key : 어절을 나누는 구분 문자

        self.encoding = encoding

        # 파일 경로 리스트
        in_file_paths = file_util.get_file_paths(in_dir, True)

        for in_file_path in in_file_paths :
            self.make_freq_file(in_file_path, encoding, delim_key)
            print(f"in_file_path : {os.path.basename(in_file_path)} make freq complet")
    

    '''
        2. 빈도 계산 파일 생성
    '''
    def make_freq_file(self, in_file_path: str, encoding: str, delim_key: str) :
        # file을 open하려 in_file로 받음
        in_file = file_util.open_file(in_file_path, encoding, 'r')
        
        # in_file로 받은 파일을 한 줄씩 line으로 받음
        while 1 :
            line = in_file.readline()
            # 더이상 입력받은 line이 없다면 while문 멈추기
            if not line :
                break

            # 입력 받은 line 앞 뒤 공백 제거
            line = file_util.preprocess(line)

            # 입력 받은 line이 공백이라면 다음 line을 받음
            if string_util.is_empty(line, True) :
                continue

            # 문장 빈도 계산
            if line[:3] == "#%#" :
                sentence = line[4:]
                container_util.add_str_int(self.sentence_dict, sentence, 1)

            # 문장이 아니라면, '어절 단위 형태소 분석 결과'
            else :
                eojeol, ma_result_str = line.split(delim_key)
                # 어절 빈도 계산
                container_util.add_str_int(self.eojeol_dict, eojeol, 1)

                # 음절 빈도 계산
                for emjeol in eojeol:
                    container_util.add_str_int(self.emjeol_dict, emjeol, 1)

                # 형태소 분석 결과를 형태소 단위로 1차 분리
                # 형태소 단위를 어휘와 품사로 2차 분리하여, 어휘 리스트와 품사 리스트 반환
                morph_lex_list, morph_tag_list = self.parsing_ma_result(ma_result_str)
                for morph_lex, morph_tag in zip(morph_lex_list, morph_tag_list):
                    # morph_tag_lex_dict에 형태소 별 음절 빈도 계산
                    self.add_morph_tag_lex_dict(morph_tag, morph_lex)

    '''
        형태소 분석 결과를 형태소 단위로 1차 분리
        형태소 단위를 어휘와 품사로 2차 분리하여, 어휘 리스트와 품사 리스트 반환

            input   :   [웅가로는	웅가로/NNP + 는/JX]

            return  :   [웅가로, 는], [NNP, JX]
    '''
    def parsing_ma_result(self, ma_result_str: str) :
        morph_lex_list = []
        morph_morph_tag_list = []

        morph_units = ma_result_str.split(self.delim_morph)
        for morph_unit in morph_units :
            if '//' in morph_unit:
                morph_lex, morph_tag = '/' , morph_unit.split(self.delim_morph_lex_tag)[-1]
            else :
                morph_lex, morph_tag = morph_unit.split(self.delim_morph_lex_tag)
            morph_lex_list.append(morph_lex)
            morph_morph_tag_list.append(morph_tag)
        
        return morph_lex_list, morph_morph_tag_list

    # 품사 별로 어휘의 빈도를 계산
    # 예를 들어, '웅가로'가 'NNP'일 때, 빈도를 계산한다면, 'NNP' 중에서 '웅가로'의 빈도를 계산
    def add_morph_tag_lex_dict(self, morph_tag: str, morph_lex: str) :
        if morph_tag not in self.morph_tag_lex_dict:
            self.morph_tag_lex_dict[morph_tag] = {}
        container_util.add_str_int(self.morph_tag_lex_dict[morph_tag], morph_lex, 1)
    
    # 빈도 계산이 완료된 dict들을 out_dir의 파일로 생성
    # 빈도 순으로, 동일한 빈도라면 문자 순으로 정렬하여 파일을 생성합니다.
    def write_freq_dict(self, out_dir: str, delim_key: str) :

        # dict 저장
        dict_list = [self.sentence_dict, self.eojeol_dict, self.emjeol_dict, self.morph_tag_lex_dict]
        filenames = ['sentence_dict.dict', 'eojeol_dict.dict', 'emjeol_dict.dict', 'morph_tag_lex_freq']

        for idx in range(len(dict_list)):
            if dict_list[idx] != self.morph_tag_lex_dict:

                # value값 내림차순으로 정렬
                dict_list[idx] = container_util.sorted_dict(dict_list[idx])
                file_path = os.path.join(out_dir, filenames[idx])

                if file_util.exists(file_path) == False:
                    file_util.open_file(file_path, encoding, 'w')

                file_util.write_dict(file_path, encoding, dict_list[idx], delim_key)

            else:
                #   - emjeol dict : tag 기준으로 오름 차순
                #   - tag dict : lex 빈도 별로 내림 차순
                self.morph_tag_lex_dict = container_util.sorted_dict_key(self.morph_tag_lex_dict, False)
                for tag in self.morph_tag_lex_dict:
                    self.morph_tag_lex_dict[tag] = container_util.sorted_dict(self.morph_tag_lex_dict[tag])

                    # morph_tag_lex_dict 저장
                    file_path = os.path.join(out_dir, filenames[idx], (str(tag) + '.dict'))

                    if file_util.exists(file_path) == False:
                        file_util.open_file(file_path, encoding, 'w')

                    file_util.write_dict(file_path, encoding, self.morph_tag_lex_dict[tag], delim_key)
        


        print(f"\twrite_freq_dict() start")
        
        pass
        
        print(f"\twrite_freq_dict() end")

###########################################################################################

if __name__ == "__main__" :
    work_dir = "../"

    in_dir = "input_sejong/"
    out_dir = "output_freq_my/"
    encoding = "UTF-8"
    delim_key = "\t"

    sejong_freq_maker = SejongFreqMaker()
    sejong_freq_maker.make_freq_folder(in_dir, encoding, delim_key)
    sejong_freq_maker.write_freq_dict(out_dir, delim_key)
