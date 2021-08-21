import sys

N = int(sys.stdin.readline())
point = list(map(int, sys.stdin.readline().split()))
myset = set(point)
mylist = list(myset)
mylist.sort()
mydic = {mylist[i] : i for i in range(len(mylist))}
for i in point:
    print(mydic[i], end = " ")

'''
import sys

N = int(sys.stdin.readline())
point = list(map(int, sys.stdin.readline().split()))
myset = set(point)
mylist = list(myset)
mylist.sort()
for i in point:
    if i in mylist:
        print(mylist.index(i), end=" ")

원래 코드에서는 point 안의 값을 가지고 mylist에서 비교한 후 있다면 mylist의 index를 출력하도록 했다.
이것은 시간복잡도 O(n)을 가진 프로그램이었고, mylist를 활용한다면 O(1)의 시간복잡도로 문제를 해결할 수 있다
'''