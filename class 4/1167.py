#트리의 지름
import sys
from collections import deque
input = sys.stdin.readline
n = int(input())
graph = [[] for _ in range(n+1)]
for _ in range(n):
    c = list(map(int, input().split()))
    for i in range(1, len(c) - 2, 2):
        graph[c[0]].append((c[i],c[i+1]))

def BFS(start):
    stack = deque()
    global n, graph
    max_value = [0,0]
    stack.append(start)
    visited = [-1 for _ in range(n+1)]
    visited[start] = 0
    
    while stack:
        start = stack.popleft()
        for node, d in graph[start]:
            if visited[node] == -1:
                visited[node] = visited[start] + d
                stack.append(node)
            elif max_value[0] < visited[start]:
                max_value = visited[start], start
    return max_value

v, i = BFS(1)
v, i = BFS(i)
print(v)