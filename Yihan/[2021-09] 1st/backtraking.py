'''1번
N, M = map(int, input().split())
s = []
def dfs():
    if len(s) == M:
        print(*s)
        return
    for i in range(1, N+1):
        if i not in s:
            s.append(i)
            dfs()
            s.pop()
dfs()'''

'''2번
N, M = map(int, input().split())
s = []
def dfs(x):
    if len(s) == M:
        print(*s)
        return
    for i in range(x, N+1):
        if i not in s:
            s.append(i)
            dfs(i+1)
            s.pop()
dfs(1)'''

'''3번
N, M = map(int, input().split())
s = []
def dfs():
    if len(s) == M:
        print(*s)
        return
    for i in range(1, N+1):
        s.append(i)
        dfs()
        s.pop()
dfs()'''

'''4번
N, M = map(int, input().split())
s = []
def dfs(x):
    if len(s) == M:
        print(*s)
        return
    for i in range(x, N+1):
        s.append(i)
        dfs(i)
        s.pop()
dfs(1)'''

'''chess Queen
N = int(input())
chess = [0] * N
chesscnt = 0

def possible(cnt):
    for i in range(cnt):
        if chess[cnt] == chess[i] or abs(chess[cnt]-chess[i]) == cnt - i:
            return False
    return True

def dfs(cnt):
    global chesscnt
    if cnt == N:
        chesscnt += 1
    else:
        for i in range(N):
            chess[cnt] = i
            if possible(cnt):
                dfs(cnt+1)
dfs(0)
print(chesscnt)'''

"""연산자
N = int(input())
nums = list(map(int, input().split()))
plus, minus, multiple, division = map(int, input().split())
maxnum = -1000000000
minnum = 1000000000
def dfs(num, idx, pl, mi, mu, di):
    global maxnum, minnum
    if idx == N:
        maxnum = max(num, maxnum)
        minnum = min(num, minnum)
    if pl > 0:
        dfs(num + nums[idx], idx + 1, pl - 1, mi, mu, di)
    if mi > 0:
        dfs(num - nums[idx], idx + 1, pl, mi - 1, mu, di)
    if mu > 0:
        dfs(num * nums[idx], idx + 1, pl, mi, mu - 1, di)
    if di > 0:
        dfs(int(num / nums[idx]), idx + 1, pl, mi, mu, di - 1)
dfs(nums[0], 1, plus, minus, multiple, division)
print(maxnum)
print(minnum)"""