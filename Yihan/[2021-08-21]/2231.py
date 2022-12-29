N = int(input())
j = 0
for i in range(1, N+1):
    digit = list(map(int, str(i)))
    j = i + sum(digit)
    if j == N:
        print(i)
        break
    if i == N:
        print(0)