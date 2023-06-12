# file_util
import os

# 뭐야
# 해당 경로에 있는 파일의 루트와 파일 명을 가지고 오는 함수
def get_files_list(file_dir):
    root_list = []
    filenames_list = []
    for root, _, filenames in os.walk(file_dir):
        root_list.append(root)
        filenames_list.append(filenames)
    if len(root_list) == 1 :
        return filenames_list[0]
    else :
        return root_list, filenames_list

def make_folder(output_dir):
    os.makedirs(output_dir, exist_ok=True)
    
def make_file(output_dir, filename):
    open(output_dir+filename+'.dict', 'w+')
    
def read_file(file):
    while True:
        line = file.readline()
        if not line:
            break
        else:
            print(line.rstrip())
    print()
    
