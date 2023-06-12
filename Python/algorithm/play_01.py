# 사과패드 144
# n개의 사과패드 각각 고유의 시리얼 번호
# 첫번째 1번 패드
# 1번패드부터 주어지는 정수s번
# 정수 sRkwl 번호 합을 k로 나누었을 때 나머지가 144인 경우가 업다면 사과패드 구매
# 있다면 사과패드 구매 안함

n, k = map(int, input().split())
nums = list(map(int, input().split()))
print('NO' if sum(nums)%k == 144 else 'YES')

n, k = map(int, input().split())
nums = list(map(int, input().split()))
nums_sum = 0
answer = False
for n in nums:
    nums_sum += n
    if nums_sum//k == 144:
        answer = True
print('NO' if answer else 'YES')