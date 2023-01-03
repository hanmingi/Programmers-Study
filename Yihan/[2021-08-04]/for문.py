# 구구단
a = int(input())

for gugu in range(1,10):
    print(a, "*", gugu, "=", a*gugu)

# A+B - 3
f = int(input())

for num in range(f):
    a,b = map(int, input().split())
    print(a+b)

# A+B - 8
T = int(input())

for i in range(T):
    a,b = map(int, input().split())
    print("Case #{0}: {1} + {2} = {3}".format(i+1,a,b,a+b))

# 합
a = int(input())
s = 0

for num in range(a):
    s += num+1
print(s)

# N찍기
N = int(input())

for num in range(N):
    print(num+1)

# 기찍N
N = int(input())
for num in range(N):
    print(N-num)

# 별 찍기 - 1
N = int(input())

for i in range(N):
    print("*"*(i+1))

# 별 찍기 - 2
N = int(input())

for i in range(N):
    print(" "*(N-i-1) + "*"*(i+1))