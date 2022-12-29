N = int(input())
for _ in range(N):
    arr = [0] * 101
    arr[1] = 1
    arr[2] = 1
    arr[3] = 1
    t = int(input())
    for i in range(4, t+1):
        arr[i] = arr[i-3] + arr[i-2]
    print(arr[t])