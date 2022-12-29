N = int(input())
point = []
for _ in range(N):
    x, y = map(int, input().split())
    point.append([y, x])
point.sort()    
for i in point:
    print(i[1], i[0])