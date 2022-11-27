import collections
a = int(input())
n = collections.deque([i for i in range(1, a+1)])

while len(n) > 1:
    n.popleft()
    n.rotate(-1)

print(n[0])