from jamo import CHO, JUNG, JONG, ggub_jong, ggub_jung, ssang_jaeum, reversed_ggub_jong, reversed_ggub_jung

emjeol_list = ['ㅅ','ㄱㄱㅏ', 'ㅅㅏㄻ', 'ㅣㅏㅆㅗㅐㅇ', 'ㅁㅁㅏ', 'ㅇ', 'ㅇㅗㅇ', 'ㄴㄹ', 'ㅣ', 'ㄱㅅ']
# emjeol_list = ['ㅇㅗ','ㅇ', 'ㅏ', 'ㅅㄱ']

emjeol_jamo = ''.join(emjeol_list)

converted_list = []

while emjeol_jamo:
    print('='*100)
    print('first emjeol_jamo :', emjeol_jamo)
    
    emjeol_len = len(emjeol_jamo)
    print('emjeol_len :', emjeol_len)
    remain_emjeol = ''
    moeum = False
    
    for i in reversed(range(emjeol_len)):
        print('='*50)

        if emjeol_jamo[i] not in JUNG:
            continue
        
        print('뒤에서 처음 모음인 인덱스 :', i, emjeol_jamo[i])
        moeum = True
        # if (i == 0) or (emjeol_jamo[i-1] in JUNG): # i가 첫 번째 음절일 경우 OR i-1이 중성인 경우
        #     first_idx, last_idx = i, i
        #     remain_emjeol = emjeol_jamo[i+1:]
        #     print('i가 첫 번째 음절인 경우')

        if i == 0: # i가 첫 번째 음절일 경우
            first_idx, last_idx = i, i
            remain_emjeol = emjeol_jamo[i+1:]
            print('i가 첫 번째 음절일 경우')
            
        
        
        elif (emjeol_jamo[i-1] in JUNG) and ((emjeol_jamo[i-1], emjeol_jamo[i]) not in reversed_ggub_jung):
            first_idx, last_idx = i, i
            remain_emjeol = emjeol_jamo[i+1:]
            print('i앞이 ㅙ 가 아닌 모음인 경우')
            
        
        elif (emjeol_jamo[i-1] in JUNG) and ((emjeol_jamo[i-1], emjeol_jamo[i]) in reversed_ggub_jung):
            emjeol_jamo = emjeol_jamo[:i-1] + reversed_ggub_jung[(emjeol_jamo[i-1], emjeol_jamo[i])] + emjeol_jamo[i+1:]
            continue

        #########################################################################################3333

        else: # i가 첫 번째 음절이 아닐 경우

            '''
                i 앞의 자모를 확인
                i 는 중성 (ㅏ), i-1은 자음(ㄱ, ㄲ, ㄺ)
            '''
            
            if emjeol_jamo[i-1] in CHO: # i-1이 초성인 경우 (ㄱ, ㄲ)
                first_idx = i-1
                print('i-1이 초성인 경우')

            else: # i-1이 겹받침인 경우(ㄺ)
                print('i-1이 겹받침인 경우')
                cho1, cho2 = ggub_jong[emjeol_jamo[i-1]]
                emjeol_jamo = emjeol_jamo[:i-1] + cho1 + cho2 + emjeol_jamo[i:]
                print('수정된 음절 자모 :', emjeol_jamo)
                i += 1
                emjeol_len += 1
                print('수정된 i', i, emjeol_jamo[i])
                first_idx = i-1


            '''
                i 뒤의 자모를 확인
                i 는 중성, i+1은 자음(ㄱ, ㄲ, ㄺ)
            '''
            if emjeol_len-1 == i: # i 가 마지막 음절일 경우
                print('i가 마지막 자모인 경우')
                last_idx = i

            else: # i가 마지막 음절이 아닌 경우
                print('i가 마지막 자모가 아닌 경우')
                if (emjeol_jamo[i+1] in ssang_jaeum) or (emjeol_jamo[i+1] in ggub_jong):
                    print('i+1이 쌍자음이거나 겹받침인 경우')
                    last_idx = i+1
                    remain_emjeol = emjeol_jamo[last_idx+1:]
                
                else: # i+1이 쌍자음, 겹받침이 아닌 자음인 경우
                    print('i+1이 그냥 자음인 경우')
                    if i+2 <= emjeol_len-1: # i 뒤의 자음이 두 개 이상인 경우
                        print('i+2 이상이 존재하는 경우')
                        jong1, jong2 = emjeol_jamo[i+1:i+3]
                        if (jong1, jong2) in reversed_ggub_jong:
                            print('i+1, i+2가 겹받침이 되는 경우')
                            emjeol_jamo = emjeol_jamo[:i+1] + reversed_ggub_jong[(jong1, jong2)] + emjeol_jamo[i+3:]
                            print('수정된 음절 자모', emjeol_jamo)
                            print('i :', i, emjeol_jamo[i])
                    last_idx = i+1
                    remain_emjeol = emjeol_jamo[i+2:]
        

        '''
            first_idx, last_idx, remain_emjeol
        '''
        print('first_idx, last_idx :', first_idx, last_idx)
        print('remain_emjeol', remain_emjeol)

        emjeol = emjeol_jamo[first_idx: last_idx+1]
        print('emjeol :', emjeol)
        print('converted_list :', converted_list)
        jaeum_list = []
        jaeum_list.append(emjeol)
        
        if remain_emjeol:
            # 전체 자음인 경우
            x = 0
            for i in range(len(remain_emjeol)):
                jaeum = remain_emjeol[i]
                if (jaeum in ssang_jaeum) or (jaeum in ggub_jong):
                    jaeum_list.append(jaeum)
                else : # 쌍자음이나 겹받침이 아닌 자음인 경우
                    if x == 0:
                        if i == len(remain_emjeol)-1:
                            jaeum_list.append(jaeum)
                        else:
                            x = jaeum; continue
                    else:
                        y = jaeum
                        if (x, y) in ggub_jong:
                            jaeum_list.append(ggub_jong[(x, y)])
                        else:
                            jaeum_list.append(x); jaeum_list.append(y)
                        # x = 0
        print('-'*30)
        emjeol_jamo = emjeol_jamo[:first_idx]
        converted_list = jaeum_list + converted_list
        print(converted_list)
        print()
        break
        

    if moeum == False:
        # 전체 자음인 경우
        jaeum_list = []

        if len(emjeol_jamo) == 1:
            converted_list.insert(0, emjeol_jamo)
        else:
            x = 0
            for i in range(len(emjeol_jamo)):
                jaeum = emjeol_jamo[i]
                if (emjeol_jamo[i] in ssang_jaeum) or (emjeol_jamo[i] in ggub_jong):
                    jaeum_list.append(jaeum)
                elif x:
                    y = jaeum
                    if (x, y) in reversed_ggub_jong:
                        jaeum_list.append(ggub_jong[(x, y)])
                    else:
                        jaeum_list.append(x); jaeum_list.append(y)
                elif i == len(emjeol_jamo)-1:
                    jaeum_list.append(jaeum)
                else:
                    x = jaeum
        emjeol_jamo = ''
  
        converted_list = jaeum_list + converted_list


        

print(converted_list)

