from collections import Counter

n = int(input())
for _ in range(n):
    a = int(input())
    cloth = []
    for _ in range(a):
        b, c = input().split()
        cloth.append(c)
    di = Counter(cloth)
    result = 1
    for i in di:
        result *= di[i]+1
    print(result-1)