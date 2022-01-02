from collections import deque
import sys
def distance():
    global arr, shark_size, n, m, shark_location
    dx = [0, -1, 1, 0]
    dy = [-1, 0, 0, 1]
    y, x = shark_location[0], shark_location[1]
    visited = [[0 for _ in range(n)]for _ in range(n)]
    stack = deque([(y,x)])
    visited[y][x] = 1
    feed = []
    stop = 0
    dist = 999999
    while stack:
        ny, nx = stack.popleft()
        for i in range(4):
            ay = ny + dy[i]
            ax = nx + dx[i]
            if 0<=ay<n and 0<=ax<n and visited[ay][ax] == 0:
                #상어가 먹을 수 있는 물고기 발견
                if arr[ay][ax] < shark_size and arr[ay][ax] != 0:
                    #print("shark size:%d y:%d x:%d" %(shark_size, ay, ax))
                    dist = visited[ny][nx]
                    visited[ay][ax] = dist + 1
                    feed.append([ay,ax,dist])
                elif arr[ay][ax] <= shark_size and visited[ny][nx] < dist:
                    visited[ay][ax] = visited[ny][nx] + 1
                    stack.append([ay,ax])
    if feed:
        feed.sort(key=lambda x:(x[2],x[0],x[1]))
        shark_location[0], shark_location[1] = feed[0][0], feed[0][1]
        arr[y][x] = 0
        arr[feed[0][0]][feed[0][1]] = 9
        #print("feed:%d y:%d x:%d" %(feed[0][2], feed[0][0], feed[0][1]))
        return feed[0][2]
    return -1

n = int(input())
arr = [0 for _ in range(n)]
for i in range(n):
    arr[i] = list(map(int, sys.stdin.readline().split()))
    
shark_size = 2
shark_location = [-1, -1]

for i in range(n):
    for j in range(n):
        if arr[i][j] == 9:
            shark_location[0], shark_location[1] = i,j
            break
    if shark_location[0] >= 0:
        break
    
next = distance()
time = 0
eat = 0
while next > 0:
    time += next
    eat += 1
    if eat == shark_size:
        shark_size += 1
        eat = 0
    next = distance()
print(time)