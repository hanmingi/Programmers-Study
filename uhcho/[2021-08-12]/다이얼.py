dial = ["ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"]
num = input()
time = 0
for i in num:
    for j in dial:
        for k in j:
            if i == k:
                time += dial.index(j) + 3
print(time)