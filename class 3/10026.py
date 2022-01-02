from collections import deque
import copy
import sys
def check(y, x, arr, visited):
    global n
    color = arr[y][x]
    stack = deque()
    stack.append([y,x])
    dy = [0,0,-1,1]
    dx = [-1,1,0,0]
    while stack:
        ny, nx = stack.popleft()
        for i in range(4):
            ay = ny + dy[i]
            ax = nx + dx[i]
            if 0<=ay<n and 0<=ax<n and color == arr[ay][ax] and visited[ay][ax] == 0:
                stack.append([ay, ax])
                visited[ay][ax] = 1

n = int(sys.stdin.readline())
arr = [[None] for _ in range(n)]
visited = [[0]*n for _ in range(n)]
for i in range(n):
    arr[i] = list(map(str,sys.stdin.readline()))
arr2 = copy.deepcopy(arr)
visited2 = [[0]*n for _ in range(n)]
for i in range(n):
    for j in range(n):
        if arr2[i][j] == "G":
            arr2[i][j] = "R"
            
cnt = 0
cnt2 = 0

for i in range(n):
    for j in range(n):
        if visited[i][j] == 0:
            check(i,j,arr,visited)
            cnt += 1
        if visited2[i][j] == 0:
            check(i,j,arr2,visited2)
            cnt2 += 1

print(cnt, end = ' ')
print(cnt2)