dial = {("A", "B", "C") : 2, ("D", "E", "F") : 3, ("G", "H", "I") : 4, ("J", "K", "L") : 5, ("M", "N", "O") : 6, ("P", "Q", "R", "S") : 7, ("T", "U", "V") : 8, ("W", "X", "Y", "Z") : 9}
num = input()
time = 0
for i in num:
    for key in dial.keys():
        if i in key:
            time += dial[key] + 1
print(time)