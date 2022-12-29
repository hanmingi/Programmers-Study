N, M = map(int, input().split())
card = list(map(int, input().split()))
sum = 0
a = len(card)
for i in range(0, a-2):
    for j in range(i+1, a-1):
        for k in range(j+1, a):
            if card[i] + card[j] + card[k] > M:
                continue
            else:
                sum = max(sum, card[i] + card[j] + card[k])
print(sum)

# 처음에 a를 쓰지 않고 N-3, N-2, N-1을 반복문의 요소로 사용했는데 오류가 났습니다.
# 그 이유가 궁금합니다