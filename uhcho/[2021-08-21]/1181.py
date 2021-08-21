N = int(input())
words = []
for _ in range(N):
    a = input()
    words.append(a)
myset = set(words)
mylist = list(myset)
mylist.sort()
mylist.sort(key = len)
for i in mylist:
    print(i)