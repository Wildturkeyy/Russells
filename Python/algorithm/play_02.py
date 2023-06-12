# 후보 4234
# 귀족 상인 시민
# n m k 하나씩 무효표 없음
# 2배 3배
# 동점이면 번호가 더 앞인후보 승리

# 첫번째 방법
n, m, k = map(int, input().split())
mul = {0:2, 1:2, 2:3}
dic = {}
vote_list = []
for _ in range(3):
    vote_list.append(list(map(int, input().split())))

for i, v in enumerate(vote_list):
    multi = mul[i]
    try :
        if dic[v] :
            dic[v] += multi
        else :
            dic[v] = multi
    except :
        pass
max_value = max(dic.values())
for key in dic:
    if dic(key) == max_value:
        print(key)
        break


# 두번째 방법
n, m, k = map(int, input().split())
score = [0] * 4235
multi = [2, 3, 1]
vote = []
for _ in range(3):
	vote.append(list(map(int, input().split())))
	
for i, v in enumerate(vote):
	for x in v:
		score[x] += multi[i]

print(score.index(max(score)))