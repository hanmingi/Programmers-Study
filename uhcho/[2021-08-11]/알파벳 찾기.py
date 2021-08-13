alpabet = []
for _ in range(26):
    alpabet.append(-1)
S = input()
for i in S:
    if alpabet[ord(i)-97] == -1:
        alpabet[ord(i)-97] = S.index(i)
for i in alpabet:
    print(i, end=" ")