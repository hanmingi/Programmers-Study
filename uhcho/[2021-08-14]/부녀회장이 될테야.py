T = int(input())
for _ in range(T):
    k = int(input())
    n = int(input())
    N = [[0]*n for i in range(k+1)]
    for i in range(1,k+1):
        N[i][0] = 1
    for i in range(n):
        N[0][i] = i+1
    for i in range(1,k+1):
        for j in range(1,n):
            N[i][j] = N[i-1][j] + N[i][j-1]
    print(N[i][j])