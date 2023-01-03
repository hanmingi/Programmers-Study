def Eucl(m, n):
    if n > m:
        n, m = m, n
    if n == 0:
        return m
    if m % n == 0:
        return n
    else:
        return Eucl(n, m%n)

n = int(input())
num = list(map(int, input().split()))

for i in range(1, len(num)):
    k = Eucl(num[0], num[i])
    print(str(num[0]//k) + '/' + str(num[i]//k))