m, n = map(int, input().split())

def Eucl(m, n):
    if n > m:
        n, m = m, n
    if n == 0:
        return m
    if m % n == 0:
        return n
    else:
        return Eucl(n, m%n)

print(Eucl(m, n))
print(m * n // Eucl(m,n))