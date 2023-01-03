def hansu(num):
    numbers = []
    while num != 0:
        numbers.append(num%10)
        num = num//10
    if (numbers[0] - numbers[1]) == (numbers[1] - numbers[2]):
        return 1

N = int(input())
count = 99
if N < 100:
    print(N)
elif N == 1000:
    print(144)
else:
    for i in range(111, N+1):
        if hansu(i) == 1:
            count += 1
    print(count)
