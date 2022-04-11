import sys
import heapq
input = sys.stdin.readline
INF = 99999
#from collections import deque
N, M, X = map(int, input().split())
graph = [[] for _ in range(N+1)]
for _ in range(M):
    info = list(map(int, input().split()))
    graph[info[0]].append([info[1],info[2]])#노드, 거리
    
def dijkstra(start):
    visited = [0] * (N+1)
    dist = [INF] * (N+1)
    stack = []
    dist[start] = 0
    heapq.heappush(stack, (0, start))
    while stack:
        dis, now = heapq.heappop(stack)
        
        if dist[now] < dis:
            continue
        
        for node, d in graph[now]:
            new_distance = dis+d
            if new_distance < dist[node]:
                dist[node] = dis + d
                heapq.heappush(stack, (new_distance, node))
    return dist

max_num = 0
back = dijkstra(X)
for i in range(1,N+1):
    go = dijkstra(i)
    max_num = max(max_num, go[X] + back[i])
        
print(max_num)