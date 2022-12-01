N = int(input())
house = list(map(int, input().split()))
house.sort()
distance = 0
for i in house:
    distance += i/N
if house[round(N/2)]-distance < house[round(N/2)]-distance:
    print(house[N//2])
else:
    print(house[N//2-1])

"""
distance에 집 위치의 평균값을 for문으로 입력
중간값에 가까운 2개의 집 위치를 선정하여 둘 중 거리가 더 가까운 집의 위치를 반환하도록 설계함
"""