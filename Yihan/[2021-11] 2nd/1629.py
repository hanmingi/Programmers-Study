import sys
A, B, C = map(int, sys.stdin.readline().split())

def DaC(a,b):
    if b==1:
        return a%C
    temp = DaC(a,b//2)
    if b%2 == 0:
        return temp * temp % C
    else:
        return temp * temp * a % C

print(DaC(A,B))