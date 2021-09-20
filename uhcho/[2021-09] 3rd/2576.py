n = int(input())
stair = [0 for _ in range(301)]
st_sum = [0 for _ in range(301)]
for i in range(n):
    stair[i] = int(input())
st_sum[0] = stair[0]
st_sum[1] = stair[0] + stair[1]
st_sum[2] = max(stair[0]+stair[2], stair[1]+stair[2])
for i in range(3,n):
    st_sum[i] = max(st_sum[i-3]+stair[i-1]+stair[i], st_sum[i-2]+stair[i])
print(st_sum[n-1])

'''
stair list를 빈 list로 선언하고, stair.append(int(input()))으로 했을 때
백준 코드에서는 index error가 발생했다. 이유가 무엇일까?
'''