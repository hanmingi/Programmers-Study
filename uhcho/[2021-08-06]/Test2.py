N, K = input().split()
K = int(K)
K_num = list(map(int, input().split()))
K_num.sort()
K_num.reverse()
N_num = []
result = []
islower = 0
resultnum = 0

for i in range(len(N)):
    N_num.append(int(N[i]))

for i in N_num:
    if islower == 0:
        for j in K_num:
            if i == j:
                result.append(j)
                break
            elif i > j:
                result.append(j)
                islower = 1
                break
    else:
        result.append(K_num[0])

for i in range(K):
    resultnum += 10**(K-i-1) * result[i]

print(resultnum)

"""
1. N을 list로 만들고, K를 내림차순으로 정렬한다
2. for문 내 if문에서 큰 자리의 수가 더 작은지 판별한 후, 더 작다면 K에서 가장 큰 수를 result에 넣고
같다면 그 수를 result에 넣어서 result list를 채운다
3. result에 있는 수들을 resultnum에 더한 후 print
"""