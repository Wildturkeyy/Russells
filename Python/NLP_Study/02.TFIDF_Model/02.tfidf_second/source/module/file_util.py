import os

###########################################################################################
'''
    get_file_paths : 파일 경로 및, inner_flag 여부를 넘겨주면, 폴더내의 파일 리스트를 가져오는 함수
'''
def get_file_paths(in_dir: str, inner_flag: bool) :
    # file 경로를 담을 리스트
    file_paths = []

    # inner_flag : True  = 폴더 내에 또 다른 폴더가 있는 경우
    #            : False = 입력한 폴더 내에 하위 폴더가 없는 경우
    # 불러온 parent_path와 file_name 으로, 파일 유무 확인 후 file_paths에 append
    # return 파일경로 리스트
    if inner_flag :
        for (parent_path, dirs, file_names) in os.walk(in_dir) :
                for file_name in file_names :
                    file_path = os.path.join(parent_path, file_name)

                    if os.path.isfile(file_path) :
                        file_paths.append(file_path)
    else :
        file_names = os.listdir(in_dir)
        for file_name in file_names :
            file_path = os.path.join(in_dir, file_name)

            if os.path.isfile(file_path) :
                file_paths.append(file_path)

    return file_paths

###########################################################################################

'''
    폴더를 생성하는 함수
    # os.path.dirname : 입력받은 file_path (path + filename)에서 해당 폴더 경로까지만 받아내기
    # os.makedirs : 입력받은 경로에 맞게 폴더 생성 ,  exist_ok = True / 폴더가 존재하면 pass, 존재하지 않으면 생성
'''
def make_parent(file_path: str) :
    os.makedirs(os.path.dirname(file_path), exist_ok=True)

'''
    file을 open하는 함수
'''
def open_file(file_path: str, encoding: str, mode: str) :
    # mode를 'w'로 받으면 해당 경로 폴더 생성
    if mode == 'w' :
        make_parent(file_path)

    if len(encoding) == 0 :
        return open(file_path, mode)
    else :
        return open(file_path, mode, encoding=encoding)

###########################################################################################

'''
    입력 받은 문자의 앞 뒤 공백 제거하는 함수
'''
def preprocess(input: str) :
    return input.strip()

###########################################################################################

'''

    # output_file_path에 있는 파일 경로를 읽어서 파일 읽기
'''
def write_set(out_file_path: str, encoding: str, out_set: set, is_reverse: bool) :
    file = open_file(out_file_path, encoding, 'w')

    out_list = list(out_set)
    out_list.sort(reverse = is_reverse)

    for i in range(len(out_list)) :
        file.write(f"{out_list[i]}\n")
    
    file.close()


'''
    dict 파일을 읽어서 순차적으로 적어주는 함수
'''
def write_dict(out_file_path: str, encoding: str, out_dict: dict, delim: str) :
    file = open_file(out_file_path, encoding, 'w')

    items = out_dict.items()
    for item in items :
        file.write(f"{item[0]}{delim}{item[1]}\n")
    
    file.close()

###########################################################################################

def exists(file_path: str) :
    if file_path == None or len(file_path) == 0 :
        return False

    if os.path.exists(file_path) and os.path.isfile(file_path) :
        return True

    return False
