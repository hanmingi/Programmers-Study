n = int(input())
count = [0,0,1,1]
for i in range(4,n+1):
    count.append(count[i-1]+1)
    if i%2 == 0:
        count[i] = min(count[i], count[i//2]+1)
    if i%3 == 0:
        count[i] = min(count[i], count[i//3]+1)
print(count[n])