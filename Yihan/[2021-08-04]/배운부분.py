# 빠른 A+B
import sys

T = int(sys.stdin.readline())

for num in range(T):
    a,b = map(int,sys.stdin.readline().split())
    print(a+b)

# A+B - 7
T = int(input())

for i in range(T):
    a,b = map(int, input().split())
    print("Case #{0}: {1}".format(i+1, a+b))

# x보다 작은 수
N,X = map(int, input().split())
A = list(map(int, input().split()))

for i in A:
    if i<X:
        print(i)

"""
1. sys.stdin.readline()이 해결되지 않았는데 inport sys로 모듈을 다운받아야 동작한다는것
2. print문에서 {}를 이용하는 것을 강의에서 봤는데 활용하지 못하고 까먹었던 것
3. list를 list(map(int, input().split()))으로 바로 입력받아 사용하게끔 할 수 있고, for문에서 list를 활용하는 것
"""