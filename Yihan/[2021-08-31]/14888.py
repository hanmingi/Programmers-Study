N = int(input())

nums = list(map(int, input().split()))

pl, mi, mul, div = map(int, input().split())

max_val = -1000000000
min_val = 1000000000

def dfs(num, index, plus, minus, multi, divi):
    global max_val, min_val
    if index == N:
        max_val = max(max_val, num)
        min_val = min(min_val, num)
        return

    if plus > 0:
        dfs(num + nums[index], index + 1, plus - 1, minus, multi, divi)
    if minus > 0:
        dfs(num - nums[index], index + 1, plus, minus - 1, multi, divi)
    if multi > 0:
        dfs(num * nums[index], index + 1, plus, minus, multi - 1, divi)
    if divi > 0:
        dfs(int(num / nums[index]), index + 1, plus, minus, multi, divi - 1)

dfs(nums[0], 1, pl, mi, mul, div)
print(max_val)
print(min_val)