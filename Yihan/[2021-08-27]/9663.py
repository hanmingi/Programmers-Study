N = int(input())
chess = [0 for _ in range(N)]
cnt = 0
def adjacent(x):
    for i in range(x):
        if chess[x] == chess[i] or abs(chess[x] - chess[i]) == x - i:
            return False
    return True

def dfs(x):
    global cnt
    if x == N:
        cnt += 1
    else:
        for i in range(N):
            chess[x] = i
            if adjacent(x):
                dfs(x + 1)
dfs(0)
print(cnt)

'''
adjacent함수는 이전 열에서 겹치는 값과 이전 열에서 대각선으로 겹치는 값이 있는지 검사하는 함수이다.
원래 if문에 있는 조건문을 dfs의 조건문에 넣어서 이용했었으나, 2중for문에 코드가 지저분해지는 것 같아 타 코드를 참고해 만들었다
dfs는 원래 chess에 -1로 채우고, -1이 chess에 없을 떄 cnt를 +1 해주려 했으나, x == N에서 모든 경우를 탐색한 것이 낫다고 생각해 바꾸었다.
구상에서 실패했던 부분은 dfs에 입력값을 받을 생각을 못한 것. dfs에 입력값을 받고, 첫 열의 queen값을 얻고, 재귀적으로 다음 열의 queen값을 받아야했는데
입력값을 받지 않고 해결하려고 했던 것에서 알고리즘이 꼬였다.
'''