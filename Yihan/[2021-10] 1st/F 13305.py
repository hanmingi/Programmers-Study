n = int(input())
dis = list(map(int, input().split()))
gas = list(map(int, input().split()))
sum = 0
minVal = gas[0]
for i in range(n-1):
    if gas[i] < minVal:
        minVal = gas[i]
    sum += minVal * dis[i]
print(sum)
'''subtask 1 : 주유소 가격은 전부 1로 동일
print(sum(dis))
'''
# for i in range(n):
#     for j in range(i+1, n):
#         if gas[i] <= gas[j]:
#             if j == n-1:
#                 sum += dis[i] * gas[i]
#                 break
#             dis[i] += dis[j]
#         else:
#             sum += dis[i] * gas[i]
#             x = j
#     if x != i-1: continue
# print(sum)
'''
너무 복잡하게 생각했다. 기름값의 최솟값 minVal을 첫 인자로 받은 후,
더 작은 기름값이 나왔다면 minVal값을 초기화해준 후 km를 이동하면 되는거였는데,
첫 인자부터 뒤쪽까지 탐색한 후, 탐색한 위치까지의 거리를 한번에 더한 후,
임의의 변수 x에 그 위치를 입력, i가 j가 될때까지 진행한 후 반복하는 코드를 구성했더니,
시간초과 및 값 또한 복잡한 코드로 인해 잘못 나오는 결과가 나왔다.
알고리즘을 생각하지 않고, 생각의 흐름대로 코딩한 결과라고 생각된다.
'''