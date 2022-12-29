# 두 수 비교하기
a, b = map(int,input().split())

if a < b :
    print("<")
elif a > b :
    print(">")
else :
    print("==")

# 시험 성적
a = int(input())

if a >= 90 :
    print("A")
elif a >= 80 :
    print("B")
elif a >= 70 :
    print("C")
elif a >= 60 :
    print("D")
else :
    print("F")


# 윤년
a = int(input())

if a % 400 == 0 :
    print(1)
elif a % 100 == 0 :
    print(0)
elif a % 4 == 0 :
    print(1)
else :
    print(0)

# 사분면 고르기
a = int(input())
b = int(input())

if a > 0 and b > 0 :
    print(1)
elif a < 0 and b > 0 :
    print(2)
elif a < 0 and b < 0 :
    print(3)
else :
    print(4)

# 알람 시계
a, b = map(int, input().split())

if b < 45 :
    b += 15
    if a == 0 :
        a = 23
    else :
        a -= 1
else :
    b -= 45
print("%d %d" %(a,b))