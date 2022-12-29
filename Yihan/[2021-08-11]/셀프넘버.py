def selfnum(num):
    n = num
    while n != 0:
        num += n%10
        n = n//10
    return num

arr = []
for i in range(11000):
    arr.append(i)
for i in arr[1:10000]:
        arr[selfnum(i)-1] = 0
print(1)
for i in arr[1:10001]:
    if i != 0:
        print(i+1)