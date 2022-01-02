n = int(input())
arr = [[0]*n for _ in range(n)]
zero = 0
one = 0
for i in range(n):
    arr[i] = list(map(int, input().split()))

# for i in arr:
#     for j in i:
#         print(j, end=' ')
#     print()

def check(y, x, len):
    same = arr[y][x]
    for i in range(len):
        for j in range(len):
            if arr[i+y][j+x] != same:
                return -1
    return 1

def divide(y, x, len):
    global one, zero
    if len == 1:
        if arr[y][x] == 0:
            zero += 1
        else:
            one += 1
        return
    dx = [x, x, x+len//2, x+len//2]
    dy = [y, y+len//2, y, y+len//2]
    if check(y,x,len)>0:
        if arr[y][x] == 0:
            zero += 1
        else:
            one += 1
    else:
        for i in range(4):
            divide(dy[i], dx[i], len//2)

divide(0, 0, n)
print(zero)
print(one)