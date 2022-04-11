#벽 부수고 이동하기

import sys
input = sys.stdin.readline
from collections import deque
N, M = map(int, input().split())
graph = [[0 for _ in range(M)] for _ in range(N)]
for i in range(N):
    graph[i] = list(map(int,input().rstrip()))
visited = [[[0]*2 for _ in range(M)] for _ in range(N)]
visited[0][0][1] = 1

def BFS(graph):
    stack = deque()
    stack.append((0,0,1))
    ay = [-1, 1, 0, 0]
    ax = [0, 0, -1, 1]
    while stack:
        y, x, p = stack.popleft()
        if y == N-1 and x == M-1:
            print(visited[y][x][p])
            return 1
        for i in range(4):
            dx = x + ax[i]
            dy = y + ay[i]
            #print("dy:%d dx:%d" %(dy, dx))
            if 0 <= dx < M and 0 <= dy < N:
                if graph[dy][dx] == 0 and visited[dy][dx][p] == 0:
                    #print("y:%d x:%d" %(dy,dx))
                    visited[dy][dx][p] = visited[y][x][p] + 1
                    stack.append((dy, dx, p))
                if graph[dy][dx] == 1 and p == 1:
                    #print("broken y:%d x:%d" %(dy,dx))
                    visited[dy][dx][p-1] = visited[y][x][p] + 1
                    stack.append((dy, dx, p-1))
    return 0

if not BFS(graph):
    print(-1)
    