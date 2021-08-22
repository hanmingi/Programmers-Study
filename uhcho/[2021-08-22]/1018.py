N, M = map(int, input().split())
map = []
repaint = []
for _ in range(N):
    map.append(input())
for n in range(N-7):
    for m in range(M-7):
        w_start = 0
        b_start = 0
        for a in range(n, n+8):
            for b in range(m, m+8):
                if (a + b) % 2 == 0:
                    if map[a][b] != "W": w_start += 1
                    if map[a][b] != "B": b_start += 1
                else:
                    if map[a][b] != "B": w_start += 1
                    if map[a][b] != "W": b_start += 1
        repaint.append(min(w_start, b_start))
print(min(repaint))