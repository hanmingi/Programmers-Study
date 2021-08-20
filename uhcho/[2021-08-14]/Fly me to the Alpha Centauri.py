from math import sqrt, floor
T = int(input())
for _ in range(T):
    x, y = map(int, input().split())
    length = y - x
    num = floor(sqrt(length))
    if length < 4:
        print(length)
    else:
        if length == num**2:
            print(2 * num - 1)
        elif length <= num**2 + num:
            print(2 * num)
        elif length > num**2 + num:
            print(2 * num + 1)