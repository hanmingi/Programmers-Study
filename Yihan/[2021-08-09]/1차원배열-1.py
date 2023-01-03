# 최소,최대
N = int(input())
arr = list(map(int, input().split()))
arr.sort()
print(arr[0], arr[N-1])

# 최댓값
result = 0
result_num = 0
N = []
for i in range(9):
    num = int(input())
    N.append(num)
for i in range(9):
    if result < N[i]:
        result = N[i]
        result_num = i
print(result)
print(result_num+1)

# 숫자의 개수
a = 1
for i in range(3):
    num = int(input())
    a *= num
b = str(a)
N = []
for i in range(10):
    N.append(0)
for i in range(len(b)):
    N[int(b[i])] += 1
for i in range(10):
    print(N[i])

# 나머지
N = []
for i in range(10):
    num = int(input())
    N.append(num%42)
N.sort()
a = 10
for i in range(9):
    if N[i] == N[i+1]:
        a -= 1
print(a)

# 평균
a = 0
n = int(input())
score = list(map(int,input().split()))
score.sort()
for i in range(n):
    a += score[i]
a /= n
a = a/score[n-1]*100
print(a)