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
            elif K_num[K-1] > i:
                result.append(0)
                islower = 1
                break
    else:
        result.append(K_num[0])

for i in range(len(N)):
    resultnum += 10**(len(N)-i-1) * result[i]

print(resultnum)

"""
1. N을 list로 만들고, K를 내림차순으로 정렬한다
2. for문 내 if문에서 큰 자리의 수가 더 작은지 판별한 후, 더 작다면 K에서 가장 큰 수를 result에 넣고
같다면 그 수를 result에 넣어서 result list를 채운다
3. result에 있는 수들을 resultnum에 더한 후 print
수정한 부분
1. 함수를 출력할 때, N의 자릿수가 아닌 K의 자릿수로 계산함. 그것을 len(N)으로 바꿈
2. elif문으로 K의 가장 작은 수가 N의 첫 원소보다 작을 경우 첫 수를 0으로 채우고 나머지를 K중 가장 큰 수로 출력하게끔 바꿈
"""