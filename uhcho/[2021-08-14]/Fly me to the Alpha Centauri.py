import math
T = int(input())
for _ in range(T):
    x, y = map(int, input().split())
    length = y - x
    print(round(math.sqrt(length)) * 2 - 1)