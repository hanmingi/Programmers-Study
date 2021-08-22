# Python Study(Summer Vacation)
## 1주차(2021-08-02 ~ 2021-08-07)
### 탈출문자란 ?
백준 프로그래밍 개와 고양이 부분에서 활용했던 부분입니다.
\와 결합되어 탈출문자(\\, \', \", \n, \t)를 사용하게 되기 때문에 \라는 문자를 출력하고 싶다면
```{.python}
cat = '''
\    /\\
)  ( ')
(  /  )
\(__)|\n'''
print(cat)
```
와같은 형식으로 \\을 이용하여 표현해야 합니다.

### 키보드로 입력받기 & map함수
python에서 입력은 input()이라는 함수를 쓰게 됩니다. 그것을 여러개 입력받고, 구분하기 위해서는 뒤에 split()을 추가해주면 됩니다.
이 때, 그들을 전부 어떠한 형식으로 변환시키고 싶다면, map()을 이용하면 되는데, 간단한 덧셈 코드를 예시로 들겠습니다.
```
a,b = input(). split()
print(int(a)+int(b))
```
```
a,b= map(int, input().split())
print(a+b)
```
위 두개의 코드는 동일한 코드이며, 조금 더 깔끔하게 코드를 표현할 수 있다는 장점이 있습니다.

### 슬라이싱
8월 6일에 진행하였던 모의 코딩테스트 2번문제와 이전 백준 프로그래밍에서도 활용했던 부분입니다.
파이썬은 문자열과 정수 사이의 변환이 자유롭기 때문에, 다른 프로그래밍 언어와 달리 자릿수를 일일히 구분지어 표현하지 않아도 수들을 표현할 수 있습니다.

![image](https://user-images.githubusercontent.com/28240029/128631896-9014f605-5c74-4ff6-9dfc-fedba87a2728.png)

위의 수식에서 (3), (4), (5), (6)을 표현하기 위해 만들어진 코드입니다.
```{.python}
a = int(input())
b = input()
print(a*int(b[2]))
print(a*int(b[1]))
print(a*int(b[0]))
print(a*int(b))
```
위처럼 python에서는 입력받은 수를 문자열처럼 표현할 수 있고, 그것을 정수형으로 바꾸는 것 또한 자연스럽게 이루어집니다.

### 반복문
반복문에는 for문, while문이 있습니다. 한줄 for문도 존재합니다.
```{.python}
for _ in range(5):
  inner code
N = [1,2,3,4,5]
 for _ in N:
  inner code
 while True:
  innercode
  break
 arr = [i for i in range(1)]
 ```
 와 같은 식으로 반복문을 표현할 수 있고, 배열의 값들을 바로 받아와서 for문에서 활용할 수 있다는 것이 가장 유용했다고 생각합니다.
 
 ### List
 다른 언어의 배열과 같은 역할을 하는 List입니다.
 ```{.python}
 name = ["A", "B", "C", "D"]
 name.append("E")
 name.insert("Z",1)
 name.pop()
 name.index("A")
 name.find("A")
 name.replace("C", "F")
 name.sort()
 name.reverse()
 name.count("A")
 name.clear()
 ```
 등과 같이 맨 뒤에 괄호 안의 값을 삽입하는 append, 자신이 정한 위치에 값을 삽입하는 insert, 맨 뒤의 값을 가져오고 list에서 삭제하는 pop, "A"라는 값의 위치를 반환해주는 index, find등을 학습했는데, index와 find의 차이점은 index의 경우 값을 list내에서 찾을 수 없으면 error가 발생하지만, find의 경우는 error가 발생하지 않고 다음 코드를 시행할 수 있다는 점이었습니다. replace함수는 앞의 인자를 뒤에 있는 인자로 대체해주는 함수입니다.
sort는 안의 값들을 오름차순으로 정리해주는 함수, reverse는 값들의 순서를 뒤집어주는 함수, count는 list 내에서 대상이 몇번 존재하는지 count해주는 함수, clear는 값들을 모두 지워주는 함수입니다.
 
```{.python}
T = int(input())
for _ in range(T):
    k = int(input())
    n = int(input())
    N = [[0]*n for i in range(k+1)]
    for i in range(1,k+1):
        N[i][0] = 1
    for i in range(n):
        N[0][i] = i+1
    for i in range(1,k+1):
        for j in range(1,n):
            N[i][j] = N[i-1][j] + N[i][j-1]
    print(N[i][j])
```
2차원 list를 이용한 프로그래밍입니다. N=[0]*n for i in range(k+1) 로 n*(k+1)의 2차원 list를 생성하여 프로그래밍에 응용한 코드입니다.
## 2주차(2021-08-09 ~ 2021-08-14)
#### ord 함수
C에서는 아스키 코드표를 참고해야 알 수 있었던 문자, 특수문자들의 아스키값을 python에서는 ord()라는 함수로 지원하고있습니다.
### set
```{.python}
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
```
python에서는 중복된 값을 제거하는 집합 자료형이 존재합니다. 백준 1157번 문제에서 이것을 처음 활용하였는데, 단어를 입력받고, 최빈값이 무엇인지 출력하는 문제에서 list로만 출력함에 어려움을 느껴, word라는 단어를 set에 저장한 후, 그것을 alpabet에 다시 리스트로 저장해 프로그램을 작성하는데 사용하였습니다. list를 중복되지 않는 list로 만드는 방법은
```{.python}
list = []
myset = set(list)
mylist = list(myset)
```
이라는 단계를 거쳐 만들 수 있습니다.
### 백준 프로그래밍 1011번
![image](https://user-images.githubusercontent.com/28240029/130354396-e6e27dee-2edc-4da7-89ba-e9d95b7c7502.png)
푸는데 실패한 문제입니다. 위 사진은 이후 참고로 사용한 자료입니다. 거리에 따른 이동내용과 최소 이동 횟수를 정리한 표인데, 비슷하게 추론했으나, 제곱수 주변의 구간을 설정하는데 어려움을 겪었습니다. 2,3,4구간을 나누는 기준이 제곱수, 제곱수 + 제곱근 이하, 제곱수 + 제곱근 이상으로 나누어 알고리즘을 구성했는데, 추후 코드를 지우고 다시 코딩해 볼 생각입니다.
```{.python}
from math import sqrt, floor
T = int(input())
for _ in range(T):
    x, y = map(int, input().split())
    length = y - x
    num = floor(sqrt(length))
    if length < 4:
        print(length)
    else:
        if length == num**2:
            print(2 * num - 1)
        elif length <= num**2 + num:
            print(2 * num)
        elif length > num**2 + num:
            print(2 * num + 1)
```
위는 실제 제출한 코드입니다. ifelse문에서 length를 2,3,4구간에 맞게 나누어 값을 출력하도록합니다.
## 3주차(2021-08-16 ~ 2021-08-21)
### 딕셔너리
딕셔너리는 key값과 value값을 동시에 가지는 특성을 가지고 있습니다. 또한 key의 내용으로 tuple은 가질 수 있으나, list는 가질 수 없다는 특징도 있습니다. 1주차에서 풀었던 다이얼이란 문제를 다시 풀어보며 딕셔너리에 대해 학습했습니다.
```{.python}
dial = {("A", "B", "C") : 2, ("D", "E", "F") : 3, ("G", "H", "I") : 4, ("J", "K", "L") : 5, ("M", "N", "O") : 6, ("P", "Q", "R", "S") : 7, ("T", "U", "V") : 8, ("W", "X", "Y", "Z") : 9}
num = input()
time = 0
for i in num:
    for key in dial.keys():
        if i in key:
            time += dial[key] + 1
print(time)
```
원래는 dial을 리스트로 만들어 "ABC", "DEF" ... 등으로 표현, for문 내에서 리스트에 값이 있는지 찾은 후 그것의 index에 3을 더해 출력했는데, 코드를 바꾸어 dial.keys() 내에서 num의 값이 있는지 확인하고 dial[key]의 value값을 출력하도록 바꾸었습니다.
### lambda
이름없는 함수를 간단히 표현할 수 있는 식입니다.
```{.python}
def plus(a, b):
  return a + b
lambda a, b : a + b
```
위 두 식은 작동하는 방식이 같습니다.
```{.python}
N = int(input())
client = []
for _ in range(N):
    age, name = input().split()
    age = int(age)
    client.append([age, name])
client.sort(key = lambda cl: cl[0])
for i in client:
    print(i[0], i[1])
```
10814번 문제에서, client.sort(key = lambda cl: cl[0]) 를 이용함으로서, cl이라는 client 내부의 리스트를 받아오면 cl[0]인 클라이언트들의 나이를 return애서 그것을 기준으로 client를 정렬하는 함수를 만들어 문제를 해결했습니다.
