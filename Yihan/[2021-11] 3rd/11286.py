import sys
import heapq

n = int(sys.stdin.readline())
heap = []

for _ in range(n):
    num = int(sys.stdin.readline())
    if num == 0:
        try: print(heapq.heappop(heap)[1])
        except: print(0)
    else: heapq.heappush(heap, (abs(num), num))