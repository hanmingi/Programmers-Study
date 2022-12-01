import sys

N = list(sys.stdin.readline().rstrip())
N.sort()
N.reverse()

for i in N:
    print(i, end = "")