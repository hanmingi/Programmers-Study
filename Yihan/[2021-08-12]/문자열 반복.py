T = int(input())
for _ in range(T):
    a = list(input().split())
    for i in range(len(a[1])):
        for j in range(int(a[0])):
            print((a[1])[i], end= '')
    print()