n = int(input())
arr = list(map(int, input().split()))
result = [arr[0]]

for i in range(len(arr)-1):
    result.append(max(arr[i+1], result[i]+arr[i+1]))
print(max(result))