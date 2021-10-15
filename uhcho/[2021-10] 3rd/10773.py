K = int(input())
num = []
for _ in range(K):
    a = int(input())
    if a == 0:
        num.pop()
    else:
        num.append(a)
print(sum(num))