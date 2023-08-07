T = int(input())
for _ in range(T):
    conc = input()
    tf = 0
    for i in conc:
        if i == '(':
            tf += 1
        elif i == ')':
            tf -= 1
        if tf < 0:
            print("NO")
            break
    if tf > 0:
        print("NO")
    elif tf == 0:
        print("YES")