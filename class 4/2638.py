import sys
input = sys.stdin.readline
from collections import deque
n,m = map(int, input().split())
arr = []
cnt = 0
for i in range(n):
    arr.append(list(map(int,input().split())))

def bfs(arr):
    visited = [[0 for _ in range(m)] for _ in range(n)]
    dx = [0, 0, -1, 1]
    dy = [-1, 1, 0, 0]
    visited[0][0] = 1
    stack = deque()
    stack.append([0,0])
    while stack:
        y,x = stack.popleft()
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if 0 <= ny < n and 0 <= nx < m:
                if visited[ny][nx] == 0:
                    if arr[ny][nx] >= 1:
                        arr[ny][nx] += 1
                    else:
                        visited[ny][nx] = 1
                        stack.append([ny,nx])

while True:
    bfs(arr)
    melt = 0
    for i in range(n):
        for j in range(m):
            if arr[i][j] >= 3:
                arr[i][j] = 0
                melt = 1
            elif arr[i][j] == 2:
                arr[i][j] = 1
    if melt == 1:
        cnt += 1
    else:
        break

print(cnt)