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
