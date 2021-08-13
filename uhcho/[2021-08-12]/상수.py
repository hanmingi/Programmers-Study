S = list(input().split())
C = []
for i in S:
    j = list(i)
    j.reverse()
    a = 0
    for k in range(len(j)):
        a += int(j[k]) * (10 ** (len(j) - k - 1))
    C.append(a)
print(max(C))