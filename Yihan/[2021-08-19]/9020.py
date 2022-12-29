from math import sqrt, floor
primenum = []
for i in range(2, 10000):
    count = 0
    for j in range(2, floor(sqrt(i))+1):
        if i % j == 0:
            count += 1
            break
    if count == 0:
        primenum.append(i)

T = int(input())
for _ in range(T):
    n = int(input())
    if n == 4:
        print("2 2")
    else:
        for i in primenum:
            if i >= n//2:
                if n - i in primenum:
                    print(n-i, i)
                    break