'''시간초과코드
from math import factorial

n,m = map(int, input().split())
k = factorial(n)//factorial(m)//factorial(n-m)
k = str(k)
count = 0
for i in reversed(k):
    if i == '0':
        count += 1
    else: break
print(count)
'''
n, m = map(int, input().split())

def twocount(n):
    count = 0
    while n != 0:
        n = n//2
        count += n
    return count

def fivecount(n):
    count = 0
    while n!= 0:
        n = n//5
        count += n
    return count

print(min(twocount(n)-twocount(m)-twocount(n-m), fivecount(n)-fivecount(m)-fivecount(n-m)))