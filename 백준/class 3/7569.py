import sys
from collections import deque
input = sys.stdin.readline
m,n,h = map(int, input().split())
s = [[list(map(int,input().split())) for _ in range(n)] for _ in range(h)]
queue = deque()

for i in range(h):
    for j in range(n):
        for k in range(m):
            if s[i][j][k] == 1:
                queue.append([i,j,k])

dx = [-1, 1, 0, 0, 0, 0]
dy = [0, 0, -1, 1, 0, 0]
dz = [0, 0, 0, 0, -1, 1]
flag = 1
max_num = 0

while queue:
    z,y,x = queue.popleft()
    for i in range(6):
        ax = x + dx[i]
        ay = y + dy[i]
        az = z + dz[i]
        if 0 <= ay < n and 0 <= ax < m and 0 <= az < h:
            if s[az][ay][ax] == 0:
                s[az][ay][ax] = s[z][y][x] + 1
                queue.append([az,ay,ax])

for i in range(h):
    for j in range(n):
        for k in range(m):
            if s[i][j][k] == 0:
                flag = 0
                break
            else:
                max_num = max(max_num, s[i][j][k])
        if flag == 0:
            break
    if flag == 0:
        break

if flag == 0:
    print(-1)
else:
    print(max_num - 1)

