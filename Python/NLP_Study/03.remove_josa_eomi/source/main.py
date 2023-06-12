import os

from module import file_util

class LoadHangeul() :
    # Field & Member Variable

    # Constructor

    # Methods

    '''
        어절을 받아서 우최장일치를 해보고 조사 확인 후 제거한 단어 반환
    '''
    def __init__(self):
        pass

    def load_file(self, file_dir, encoding):
        file_paths = file_util.get_file_paths(file_dir, False)
        for filepath in file_paths:
            file_util.open_file(filepath, encoding)


# main
if __name__ == "__main__" :
    encoding = 'UTF-8'

    input_path = 'input_file/input.txt'
    
    hangeul = LoadHangeul()
    hangeul.load_file(input_path)
    pass