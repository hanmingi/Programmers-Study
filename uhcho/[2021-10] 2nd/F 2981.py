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
arr = []
for _ in range(n):
    arr.append(int(input()))
arr.sort()
arr2 = []
for i in range(len(arr)-1):
    arr2.append(abs(arr[i]-arr[i+1]))

idx = Eucl(arr2[0],arr2[1])
for i in range(1, len(arr2)-1):
    idx = Eucl(idx, Eucl(arr2[i], arr2[i+1]))
result = []
for i in range(2, int((idx**0.5))+1):
    if idx % i == 0:
        result.append(i)
result.append(idx)
for i in result:
    print(i, end = ' ')