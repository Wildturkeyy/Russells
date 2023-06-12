
# dict 정렬
def sorted_dict(in_dict:dict, reverse:bool):
    return dict(sorted(in_dict.items(), reverse=reverse))

def save_dict(out_dict:dict, out_dir:str, file_name):
    filename = str(file_name) + '.dict'
    with open(out_dir+filename, 'w') as file:
        if type(file_name) ==  int:
            file.write(f'doc_id : {file_name}\n')
        else:
            file.write(f'df_dict len :{len(out_dict)}\n')
        for item in out_dict.items():
            file.write(f'\t{item[0]} : {item[1]}\n')
        