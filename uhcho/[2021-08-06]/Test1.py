num = int(input())
antennadis = []
closeant = []
house = []
distance = 0


# house에 num 갯수만큼 집 위치를  받고, sort로 정렬
for i in range(num):
    house.append(int(input()))

lasthouse = house[num-1]

# 마지막 집의 위치 안에 안테나가 위치함. 집의 위치와의 거리를 절댓값으로 비교하며, antenna와의 거리를 저장
for i in house:
    for j in range(num):
        distance += abs(house[j] - i)
    antennadis.append(distance)
    closeant.append(distance)
    distance = 0
closeant.sort()

# 안테나와의 거리를 정렬, 가장 적은 거리를 가진 안테나의 index를 받아와 그 index의 집 위치를 print
for i in range(num):
    if closeant[0] == antennadis[i]:
        index= antennadis.index(closeant[0])
        print(house[index])
        break

    """
    처음에 안테나를 집에만 위치시킬 수 있다는 조건을 보지 못해 코드를 일부 수정함.
    실패한 부분 : 띄워쓰기로 입력받아야 한다는 조건 만족 못함
    """