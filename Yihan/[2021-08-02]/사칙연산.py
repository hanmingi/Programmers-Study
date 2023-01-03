# A+B
a,b = input(). split()
print(int(a)+int(b))

# A-B
a,b = input().split()
print(int(a)-int(b))

# A*B
a,b = input().split()
print(int(a)*int(b))

# A/B
a,b = input().split()
print(int(a)/int(b))

# 사칙연산
a,b = input().split()
print(int(a)+int(b))
print(int(a)-int(b))
print(int(a)*int(b))
print(int(a)//int(b))
print(int(a)%int(b))

# 나머지
a,b,c = input().split()
print((int(a)+int(b))%int(c))
print(((int(a)%int(c))+(int(b)%int(c)))%int(c))
print((int(a)*int(b))%int(c))
print(((int(a)%int(c))*(int(b)%int(c)))%int(c))

# 곱셈
a = int(input())
b = input()
print(a*int(b[2]))
print(a*int(b[1]))
print(a*int(b[0]))
print(a*int(b))