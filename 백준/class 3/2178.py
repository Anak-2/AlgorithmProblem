from collections import deque

stack = deque()
stack.append([0,0])

n,m = map(int, input().split())
arr = [[0]*m for _ in range(n)]
for i in range(n):
    arr[i] = list(map(int, input()))
visited = [[0]*m for _ in range(n)]

dy = [-1,1,0,0]
dx = [0,0,-1,1]
visited[0][0] = 1
while stack:
    y, x = stack.popleft()
    for i in range(4):
        ny, nx = y+dy[i], x+dx[i]
        if 0<=ny<n and 0<=nx<m and arr[ny][nx] == 1:
            if visited[ny][nx] == 0:
                stack.append([ny, nx])
                visited[ny][nx] = visited[y][x] + 1
print(visited[n-1][m-1])