point = [[] for i in range(2)]
for i in range(3):
    a, b = map(int, input().split())
    point[0].append(a)
    point[1].append(b)
if point[0].count(max(point[0])) == 1:
    print(max(point[0]), end = ' ')
else:
    print(min(point[0]), end = ' ')
if point[1].count(max(point[1])) == 1:
    print(max(point[1]))
else:
    print(min(point[1]))