n, k = map(int, input().split())
money = []
result = 0
for _ in range(n):
    m = int(input())
    if m <= k:
        money.append(m)
for i in reversed(money):
    # if k == 0:
    #     break
    result += k//i
    k %= i
print(result)