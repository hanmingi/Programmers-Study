def stars(n):
    sky = []
    for i in range(3 * len(n)):
        if i // len(n) == 1: #2번쨰줄
            sky.append(n[i % len(n)] + " " * len(n) + n[i % len(n)])
        else:
            sky.append(n[i % len(n)] * 3)
    return sky

star = ["***", "* *", "***"]
n = int(input())
rep = 0
while n != 3:
    n /= 3
    rep += 1
for i in range(rep):
    star = stars(star)
for i in star:
    print(i)