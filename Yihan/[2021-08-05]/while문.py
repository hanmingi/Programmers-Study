# A+B - 5
while True:
    a, b = map(int, input().split())
    if a == 0 and b == 0:
        break
    print(a+b)

# A+B - 4
try:
    while True:
        a, b = map(int, input().split())
        print(a+b)
except:
    print("")

# 더하기 사이클
n = int(input())
num = n
index = 0

while True:
    if n < 10:
        n = n * 11
    else:
        a = n%10
        b = n//10 + n%10
        n = a*10 + b%10
    index += 1
    if n == num:
        break
print(index)

"""
try except문을 배우지 않아서, 계속 오류가 났습니다. 답안을 찾아본 결과 try except문을 알게되었고, 이후 활용할 상황이 나오면 쓰도록 하겠습니다.
"""