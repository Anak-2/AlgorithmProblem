INF = float("inf")
n = int(input())
m = int(input())
graph = [[INF]*n for _ in range(n)]
for i in range(m):
    s, e, c = map(int, input().split())
    if graph[s-1][e-1] > c:
        graph[s-1][e-1] = c
for i in range(n):
    for j in range(n):
        for k in range(n):
            if j != k and graph[j][k] > graph[j][i] + graph[i][k]:
                graph[j][k] = graph[j][i] + graph[i][k]

for i in graph:
    for j in i:
        if j == INF:
            print(0, end=' ')
        else:
            print(j, end=' ')
    print()