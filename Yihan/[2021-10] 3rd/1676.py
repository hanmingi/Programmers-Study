from math import factorial

N = int(input())
fac_n = factorial(N)
fac_n = str(fac_n)
count = 0
for i in reversed(fac_n):
    if i == '0':
        count += 1
    else:
        break
print(count)