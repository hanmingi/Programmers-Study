''' 시간초과 코드
import math
while True:
    n = int(input())
    if n == 0:
        break
    pnum_count = 0
    for i in range(n+1,2*n+1):
        count = 0
        if i == 1:
            continue
        for j in range(2, math.floor(math.sqrt(i))+1):
            if i % j == 0:
                count += 1
                break
        if count == 0:
            pnum_count += 1
    print(pnum_count)
'''
import math
primenum = []
for i in range(2, 246913):
    count = 0
    for j in range(2, math.floor(math.sqrt(i))+1):
        if i % j == 0:
            count += 1
            break
    if count == 0:
        primenum.append(i)
while True:
    n = int(input())
    if n == 0:
        break
    count = 0
    for i in primenum:
        if n < i <= 2*n:
            count += 1
    print(count)