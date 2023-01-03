import sys

sudoku = [list(map(int, sys.stdin.readline().split())) for _ in range(9)]
answer = [(i, j) for i in range(9) for j in range(9) if sudoku[i][j] == 0]

def hori(x, val):                   # 가로 검사
    if val in sudoku[x]:
        return False
    return True

def verti(y, val):                  # 세로 검사
    for i in range(9):
        if val == sudoku[i][y]:
            return False
    return True

def three(x, y, val):               # 33 박스 검사
    nx = x//3 * 3
    ny = y//3 * 3
    for i in range(3):
        for j in range(3):
            if val == sudoku[nx+i][ny+j]:
                return False
    return True

def dfs(index):
    if index == len(answer):
        for row in sudoku:
            print(*row)
        sys.exit(0)                                                     # 이게 없으니 오류가 나는데 이게 왜 필요한지 모르겠음.
    else:                                                               # 학습 후 readme에 업로드 예정
        for i in range(1, 10):
            nx = answer[index][0]
            ny = answer[index][1]

            if hori(nx, i) and verti(ny, i) and three(nx, ny, i):       # 세 조건을 모두 만족 할 경우 값을 넣고
                sudoku[nx][ny] = i
                dfs(index + 1)
                sudoku[nx][ny] = 0                                      # 다시 탐색함
dfs(0)