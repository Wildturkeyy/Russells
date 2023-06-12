import os

import file_util

class JosaUtil :
    def __init__(self):
        self.josa_set = set()
        self.eomi_set = set()
    
    def load_josa(self, eomi_file_path, encoding):
        josa_file = file_util.open_file(eomi_file_path, encoding, 'r')

        while 1:
            line = josa_file.readline()
            if not line:
                break

            line = line.strip()
            self.josa_set.add(line)
        
        print(f"JosaUtil.load_josa() josa set size : {len(self.josa_set)}")

    def load_eomi(self, eomi_file_path, encoding):
        eomi_file = file_util.open_file(eomi_file_path, encoding, 'r')

        while 1:
            line = eomi_file.readline()
            if not line:
                break

            line = line.strip()
            self.eomi_set.add(line)
        
        print(f"EomiUtil.load_eomi() josa set size : {len(self.eomi_set)}")
    
    def remove_josa(self, input_str):
        result = input_str

        # ......
        index = len(result)
        for idx in range(len(result)-1, -1,-1):
            if result[idx:] in self.josa_set or result[idx:] in self.eomi_set:
                index = idx
                print('idx :', idx, 'result[:idx] :', result[:idx])
            
        result = result[:index]
        # 1음절인 건 키워드로 의미ㅏㄱ 없다....
        if len(result) == 1:
            return input_str
        
        return result





if __name__ == "__main__":
    res_dir = "C:/Users/user/Desktop/final_project/03. project/resources/"
    encoding = "UTF-8"

    eomi_file_path = res_dir + "JOSA.TXT"
    eomi_file_path = res_dir + "EOMI.TXT"
    josa_util = JosaUtil()
    josa_util.load_josa(eomi_file_path, encoding)

    print(josa_util.remove_josa('학교에서'))
    print(josa_util.remove_josa('루피는'))
    print(josa_util.remove_josa('오늘은'))
    print(josa_util.remove_josa('가을'))
    print(josa_util.remove_josa('나를'))
    print(josa_util.remove_josa('에서'))
    print(josa_util.remove_josa('곳에서'))
    print(josa_util.remove_josa('논문을'))