import sys

nums = [0 for _ in range(10001)]
N = int(sys.stdin.readline())
for _ in range(N):
    a = int(sys.stdin.readline())
    nums[a] += 1
for i in range(10001):
    if nums[i] != 0:
        for _ in range(nums[i]):
            print(i)

### 추후 readme에 알고리즘 분석 후 업로드 예정