n = int(input())
atm = list(map(int,input().split()))
atm.sort()
t = 0
tt = 0
for i in atm:
    t += i
    tt += t
print(tt)