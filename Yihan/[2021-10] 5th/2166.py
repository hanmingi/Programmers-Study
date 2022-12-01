from math import fabs
n = int(input())
x = []
y = []
x_result = 0
y_result = 0
for i in range(n):
    a, b = map(int, input().split())
    x.append(a)
    y.append(b)
x.append(x[0])
y.append(y[0])
for i in range(len(x)-1):
    x_result += x[i]*y[i+1]
    y_result += y[i]*x[i+1]
result = fabs(0.5*(x_result-y_result))
print("%.1f" % result)