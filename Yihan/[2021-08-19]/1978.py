import math
N = int(input())
num = list(map(int, input().split()))
count = len(num)
for i in num:
    if i == 1:
        count -= 1
    if i == 2:
        continue
    for j in range(2, int(math.floor(math.sqrt(i))+1)):
        if i % j == 0:
            count -= 1
            break
print(count)