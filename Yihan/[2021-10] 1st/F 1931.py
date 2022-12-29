n = int(input())
time = []
cnt = 0
endtime = 0
for _ in range(n):
    time.append(list(map(int,input().split())))
time = sorted(time, key=lambda a:a[0])
time = sorted(time, key=lambda a:a[1])
for i,j in time:
    if i >= endtime:
        cnt += 1
        endtime = j
print(cnt)

'''
time을 그냥 sort()하여 해결하려 했음. 그 경우 결과값이 예상과 다르게 나옴.
회의가 끝나는 시간이 이를수록 더 많은 회의를 진행할 수 있다는 것을 간과했음.
회의 시작시간으로 sort하고 끝나는 시간으로 다시 sort한다면,
끝나는 시간이 같을 경우에는 시작하는 시간이 빠른 순서대로 정렬됨.
'''