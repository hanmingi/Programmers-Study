import math
M = int(input())
N = int(input())
pnum = []
for i in range(M,N+1):
    count = 0
    if i == 1:
        continue
    for j in range(2, math.floor(math.sqrt(i))+1):
        if i % j == 0:
            count += 1
            break # 원래는 break문이 없었으나, 1929번에서 시간초과의 원인이 이것이라 생각해 추가함. 어차피 count가 0이 아니면 소수가 아니므로.
    if count == 0:
        pnum.append(i)
if len(pnum) == 0:
    print(-1)
else:
    print(sum(pnum))
    print(pnum[0])