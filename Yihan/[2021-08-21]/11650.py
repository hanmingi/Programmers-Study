N = int(input())
point = []
for _ in range(N):
    x, y = map(int, input().split())
    point.append([x, y])
point.sort()    
for i in point:
    print(i[0], i[1])