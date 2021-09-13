val = [[[0]*21 for _ in range(21)] for __ in range(21)]

def w(a,b,c):
    if a<=0 or b<=0 or c<=0:
        return 1
    if a>20 or b>20 or c>20:
        return w(20,20,20)
    if val[a][b][c]:
        return val[a][b][c]
    if a<b<c:
        val[a][b][c] = w(a,b,c-1)+w(a,b-1,c-1)-w(a,b-1,c)
        return val[a][b][c]
    val[a][b][c] = w(a-1,b,c)+w(a-1,b-1,c)+w(a-1,b,c-1)-w(a-1,b-1,c-1)
    return val[a][b][c]

while True:
    a,b,c = map(int, input().split())

    if a==-1 and b==-1 and c==-1:
        break

    print("w(%d, %d, %d) = %d"%(a,b,c,w(a,b,c)))