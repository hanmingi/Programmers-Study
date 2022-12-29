n = int(input())
score = 0
result = 0
Q = []
for i in range(n):
    quiz = input()
    Q.append(quiz)
for i in Q:
    for j in range(len(i)):
        if i[j] == "O":
            score += 1
            if i[j] == i[j-1]:
                result += score
            else:
                result += score
        else:
            score = 0
            continue
    print(result)
    result = 0
    score = 0