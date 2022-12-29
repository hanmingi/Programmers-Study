n = int(input())
graph = [list(map(int, input().split())) for _ in range(n)]

one_count = 0
zero_count = 0
m_count = 0


def dnc(x, y, n):
    global one_count, zero_count, m_count

    check = graph[x][y]
    for i in range(x, x + n):
        for j in range(y, y + n):
            if check != graph[i][j]:
                check = -2
                break

    if check == -2:
        n = n // 3
        dnc(x, y, n)
        dnc(x, y + n, n)
        dnc(x, y + 2 * n, n)
        dnc(x + n, y, n)
        dnc(x + n, y + n, n)
        dnc(x + n, y + 2 * n, n)
        dnc(x + 2 * n, y, n)
        dnc(x + 2 * n, y + n, n)
        dnc(x + 2 * n, y + 2 * n, n)
    elif check == 1:
        one_count += 1
    elif check == 0:
        zero_count += 1
    else:
        m_count += 1


dnc(0, 0, n)
print(m_count)
print(zero_count)
print(one_count)