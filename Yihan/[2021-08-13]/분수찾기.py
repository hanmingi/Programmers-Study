import math

X = int(input())
n = round(math.sqrt(2*X))
if n % 2 == 0:
    print(str(X-(n*(n-1)//2)) + "/" + str(n+1-(X-(n*(n-1)//2))))
else:
    print(str(n+1-(X-(n*(n-1)//2))) + "/" + str(X-(n*(n-1)//2)))