N = int(input())
num = []
for _ in range(N):
    n = int(input())
    num.append(n)
num.sort()
for i in num:
    print(i)

# 2751번도 동일한 코드이나, 반복작업이 많이 필요한 코드의 특성상 python3으로는 시간초과가 나서 pypy3으로 진행하였음