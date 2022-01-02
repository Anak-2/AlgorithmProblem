from collections import deque
n,m,v = map(int, input().split())
graph = [[0]*(n+1) for _ in range(n+1)]

for k in range(1,n+1):
    graph[k][k] = 1
for _ in range(m):
    a,b = map(int, input().split())
    graph[a][b] = graph[b][a] = 1

def DFS(v):
    if graph[v][0] != 1:
        print(v, end=' ')
        graph[v][0] = 1
    for i in range(1,n+1):
        if graph[v][i] == 1 and graph[i][0] != 1:
            DFS(i)
    return

def BFS(v):
    q = deque()
    q.append(v)
    graph[v][0] = 1
    while q:
        v = q.popleft()
        print(v,end=" ")
        for i in range(1, n+1):
            if graph[i][0] == 0 and graph[v][i] == 1:
                q.append(i)
                graph[i][0] = 1
    return

DFS(v)
for i in range(1,n+1):
    graph[i][0] = 0
print()
BFS(v)