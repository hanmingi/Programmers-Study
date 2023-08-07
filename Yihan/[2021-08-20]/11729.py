n = int(input())

def hanoi(n, start, middle, destination):
    if n == 1:
        print(start, destination)
    else:
        hanoi(n-1, start, destination, middle)
        print(start, destination)
        hanoi(n-1, middle, start, destination)
print(2 ** n -1)
hanoi(n, 1, 2, 3)