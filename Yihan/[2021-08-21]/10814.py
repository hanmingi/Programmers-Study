N = int(input())
client = []
for _ in range(N):
    age, name = input().split()
    age = int(age)
    client.append([age, name])
client.sort(key = lambda cl: cl[0])
for i in client:
    print(i[0], i[1])

'''
lambda를 처음 써본 문제이다.
lambda x : y는 
def func(x):
    y
와 같다. 위의 경우는 cl이라는 client 내부의 리스트를 받아왔을 때
cl[0] 즉 나이를 출력하는 것을 key로 삼아 나이순으로 정렬해주는 알고리즘이다
'''