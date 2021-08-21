N = int(input())
scores = []
for _ in range(N):
    x, y = map(int, input().split())
    scores.append([x, y])
for i in scores:
    score = 1
    for j in scores:
        if i[0] < j[0] and i[1] < j[1]:
            score += 1
    print(score, end = " ")