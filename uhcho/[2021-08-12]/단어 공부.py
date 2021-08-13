word = input()
word = word.upper()
alpa = set(word)
alpabet = list(alpa)
count = []
for i in alpabet:
    count.append(word.count(i))
index = count.index(max(count))
if count.count(max(count)) > 1:
    print("?")
else:
    print(alpabet[index])