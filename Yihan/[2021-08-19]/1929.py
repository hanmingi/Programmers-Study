import math
M, N = map(int, input().split())
for i in range(M,N+1):
    count = 0
    if i == 1:
        continue
    for j in range(2, math.floor(math.sqrt(i))+1):
        if i % j == 0:
            count += 1
            break
    if count == 0:
        print(i)