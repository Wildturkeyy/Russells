import sys
import os
sys.path.append(os.path.dirname(os.path.abspath(os.path.dirname(__file__))))
from module import file_util
from module import dict_util

class Document() :
    # Field & Member Variable

    # Constructor

    # Methods

    def __init__(self):
        encoding = 'UTF-8'
        self.df_dict = {}
        self.doc_id = {}
        
    def open_file(self, input_dir):
        filenames = file_util.get_files_list(input_dir)
        
        for filename in filenames:
            file_id = filename.split('.')[0]
            file = open(input_dir + filename, 'r')
            self.make_dict(file, file_id)
                        
    def make_dict(self, file, file_id):
        word_list = []
        if file_id not in self.doc_id:
            self.doc_id[file_id] = {}
        while True:
            line = file.readline()
            if not line :
                break
            elif line == '\n':
                continue
            else:
                for word in line.split():
                    if word not in word_list:
                        self.df_dict[word] = self.df_dict.get(word,0) +1
                        word_list.append(word)
                    self.doc_id[file_id][word] = self.doc_id[file_id].get(word, 0)+1
                        
    def save_dict(self, output_dir):
        file_util.make_folder(output_dir)
        file_util.make_file(output_dir, 'df_dict')
        sorted_df_dict = dict_util.sorted_dict(self.df_dict, False)
        dict_util.save_dict(sorted_df_dict, output_dir, 'df_dict')
        
        output_dir = output_dir + 'id_doc/'
        file_util.make_folder(output_dir)
        sorted_doc_id = dict_util.sorted_dict(self.doc_id, False)
        for doc_id in sorted_doc_id:
            file_util.make_file(output_dir, doc_id)
            sorted_dict = dict_util.sorted_dict(sorted_doc_id[doc_id], False)
            dict_util.save_dict(sorted_dict, output_dir, int(doc_id))
            
        
    def print_dict(self, output_dir):
        roots_list, filenames_list = file_util.get_files_list(output_dir)
        for root, filenames in zip(roots_list, filenames_list):
            for filename in filenames:
                file = open(os.path.join(root,filename), 'r')
                file_util.read_file(file)
        
                    
        
# main
if __name__ == "__main__" :
    input_dir = 'input_file/'
    output_dir = 'output_file/'
    
    make_dict = Document()
    make_dict.open_file(input_dir)
    make_dict.save_dict(output_dir)
    make_dict.print_dict(output_dir)