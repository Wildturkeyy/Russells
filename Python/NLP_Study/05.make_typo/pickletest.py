import pickle
from module import file_util, string_util

class Test() :

    def __init__(self):
        self.eojeol_set = set()

    def load_file(self, input_dir, output_dir, save_dir, encoding):
        try:
            self.load_set(save_dir)
        except FileNotFoundError:
            pass

        filepaths = file_util.get_file_paths(input_dir, False)
        for file_path in filepaths:
            file = file_util.open_file(file_path, encoding, 'r')

            while True:
                line = file.readline()
                
                if not line:
                    break

                line = file_util.preprocess(line)
                if string_util.is_empty(line, False):
                    continue

                for eojeol in line.split():
                    self.eojeol_set.add(eojeol)

        self.save_set(save_dir)
        print(self.eojeol_set)
    
    def make_dataset(self):
        pass

    def load_set(self, save_dir):
        with open(save_dir, 'rb') as f:
            self.eojeol_set = pickle.load(f)

    def save_set(self, save_dir):
        with open(save_dir, 'wb') as f:
            pickle.dump(self.eojeol_set, f, pickle.HIGHEST_PROTOCOL)





# main
if __name__ == "__main__" :
    encoding = 'UTF-8'
    input_dir = 'input_file'
    output_dir = 'output_file'
    save_dir = 'testset/eojeol_set.pickle'

    test = Test()
    test.load_file(input_dir, output_dir, save_dir, encoding)