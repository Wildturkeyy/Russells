import os

###########################################################################################
'''
    입력받은 dict로 count를 계산해주는 함수
        - in_dict (dict명), key값, value값을 입력받아
        - in_dict 안에 key 값이 있다면, value 만큼 더해주고
                               없다면, value 값으로 선언해줌.
'''
def add_str_int(in_dict: dict, key: str, value: int) :
    if in_dict != None :
        if key in in_dict :
            value_prev = int(in_dict[key])
            in_dict[key] = value_prev + value
        else :
            in_dict[key] = value

###########################################################################################

'''
    key를 기준으로 정렬
        - is_reverse = False : 오름 차순
        - is_reverse = True : 내림 차순
'''
def sorted_dict_key(in_dict: dict, is_reverse: bool) :
    return dict(sorted(in_dict.items(), key=lambda item:item[0], reverse=is_reverse))

'''
    value를 기준으로 정렬
        - is_reverse = False : 오름 차순
        - is_reverse = True : 내림 차순
'''
def sorted_dict_value(in_dict: dict, is_reverse: bool) :
    return dict(sorted(in_dict.items(), key=lambda item:item[1], reverse=is_reverse))

'''
    key를 기준으로 오름 차순 정렬, value를 기준으로 내림 차순 정렬
'''
def sorted_dict(in_dict: dict) :
    return sorted_dict_value(sorted_dict_key(in_dict, False), True)
