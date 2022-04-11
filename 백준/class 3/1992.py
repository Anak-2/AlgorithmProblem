n = int(input())
arr = [list(map(int, input())) for _ in range(n)]

def check(len, y, x):
    same = arr[y][x]
    for i in range(len):
        for j in range(len):
            if arr[y+i][x+j] != same:
                return -1
    return same

def divide(len, y, x):
    if len == 1:
        print(arr[y][x],end='')
        return
    elif check(len, y, x) < 0:
        dx = [x, x+len//2, x, x+len//2]
        dy = [y, y, y+len//2, y+len//2]
        print('(',end='')
        for i in range(4):
            divide(len//2, dy[i], dx[i])
        print(')',end='')
    else:
        print(arr[y][x],end='')
        
divide(n, 0, 0)