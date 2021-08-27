N, M = map(int, input().split())
s = []      # 수를 저장할 배열 만들기
def dfs():
    if len(s) == M:     # 수열의 길이가 M과 같으면 출력(완성된 수열)
        print(' '.join(map(str, s)))
        return
    for i in range(1, N + 1):
        if i not in s:      # 중복되지 않는 수일 경우에만
            s.append(i)     # 배열에 i 추가
            dfs()           # 재귀 함수로 뒷 요소들을 추가
            s.pop()         # 탐색과 추가가 끝난 이후 이전 노드로 돌아감
dfs()