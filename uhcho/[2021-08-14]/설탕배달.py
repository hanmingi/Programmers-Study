N = int(input())
fiv = N//5
lef = N - fiv * 5
for _ in range(10):
    if lef % 3 == 0:
        print(fiv + lef // 3)
        break
    elif fiv != 0:
        fiv -= 1
        lef += 5
    else:
        print(-1)
        break