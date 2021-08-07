N, K = map(int,input().split())
num = N
li_N = []
numbers = []
result = []

for i in range(K):
    numbers.append(int(input()))
numbers.sort()
numbers.reverse()

while True:
    li_N.append(num%10)
    num = num//10
    if num == 0:
        break
li_N.reverse()

for i in range(li_N):
    for j in range(numbers):
        if i >= j:
            result.append(j)