N = int(input())
path = 1
index = 1
while index < N:
    index += path * 6
    path += 1
print(path)