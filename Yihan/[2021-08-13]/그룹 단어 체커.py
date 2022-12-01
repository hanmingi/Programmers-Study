N = int(input())
word = []
for _ in range(N):
    word.append(input())
for i in word:
    for j in range(len(i)-1):
        if i[j] != i[j+1]:
            if i[j] in i[j+1:]:
                N -= 1
                break
print(N)