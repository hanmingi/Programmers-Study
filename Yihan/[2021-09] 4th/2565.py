n = int(input())
lin = []
for _ in range(n):
    lin.append(list(map(int, input().split())))
lin.sort()
dp = [1 for _ in range(n)]
for i in range(n):
    for j in range(i):
        if lin[i][1] > lin[j][1]:
            dp[i] = max(dp[i], dp[j]+1)
print(n - max(dp))