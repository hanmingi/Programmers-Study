a = input().split('-')
sum = 0
for i in a[0].split('+'):
    sum += int(i)
for i in a[1:]:
    for j in i.split('+'):
        sum -= int(j)
print(sum)

'''
str로 받고나서, 그 str이 연산 가능할 것이라고 짐작하고 sum에 바로 리스트의 원소를 str 그대로 계산함
처음 -로 자르고, 그 후 +로 자른 후, 그것들을 모두 연산해서 풀었어야 함
'''