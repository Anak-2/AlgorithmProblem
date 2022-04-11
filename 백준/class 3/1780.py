n = int(input())
arr = [[0]*(n) for _ in range(n)]
cnt = [0,0,0]

for i in range(n):
    arr[i] = list(map(int, input().split()))
    
def check(x,y,length):
    same = arr[y][x]
    for i in range(length):
        for j in range(length):
            if(arr[y+i][x+j] == same):
                continue
            else:
                return -1
    cnt[same+1] += 1
    return 1

def divide(x,y,n):
    global cnt
    if check(x,y,n) < 0:
        n = n//3
        dx = [0,0,0,n,n,n,n*2,n*2,n*2]
        dy = [0,n,n*2,0,n,n*2,0,n,n*2]
        for i in range(9):
            divide(x+dx[i],y+dy[i],n)

divide(0,0,n)
for i in cnt:
    print(i)