# [1,2,3]
# i번째 수는 i가 짝수일 때 수열 바로 앞의 수와 i를 더한다
# 수열의 i번째 수는 i가 홀수인 경우 3번째 이전 수열과 동일하다.

n = int(input())
num_list = [1, 2, 3]
for i in range(3, n+1):
    if i%2:
        num = num_list[i-3]
    else :
        num = num_list[i-1]+i
    num_list.append(num)
print(num_list[-1])
