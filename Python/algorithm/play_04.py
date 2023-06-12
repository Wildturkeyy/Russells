# 예시 2
# f2(dd)e if(fab)e
# f는 반복문이므로 2번 반복한다고 하면 dd가 두번 출력이므로
# dddd
# e는 반복문과 조건문의 종료를 나타내므로 문자로 실행되는게 아니므로 갯수에서 제외
# i는 조건문인데 i뒤에 있는 f가 뒤에 나오는 문자열에 포함되는지 확인해야되는데
# if(fab)e이니깐 f가 포함되므로 해당 문자열을 출력하고 e로 조건문 종료
# 따라서 출력되는 문자열은 ddddfab이므로 코드 갯수는 7개

n = int(input())
code = input()
cnt = 0
while code :
	if code[0] == 'f':
		idx = code.index('e')
		cnt += (idx - 2) * min(9, int(code[1]))
		code = code[idx+1:]
	elif code[0] == 'i':
		idx = code.index('e')
		if code[1] in code[2:idx] :
			cnt += idx - 2
			code = code[idx+1:]
	else :
		cnt += 1
		code = code[1:]
print(cnt)