import sys
input = sys.stdin.readline
import heapq
INF = float('inf')

V, E = map(int, input().split())
graph = [[] for _ in range(V+1)]
for i in range(E):
    info = list(map(int, input().split()))
    graph[info[0]].append([info[1],info[2]])
    graph[info[1]].append([info[0],info[2]])
A,B = map(int, input().split())

def dijkstra(start):
    global graph
    stack = []
    dist = [INF for _ in range(V+1)]
    heapq.heappush(stack, (0, start))
    dist[start] = 0
    while stack:
        d, n = heapq.heappop(stack)
        for next_n, next_d in graph[n]:
            distance = next_d + d
            if dist[next_n] > distance:
                dist[next_n] = distance
                heapq.heappush(stack, (distance, next_n))
    return dist

result1 = dijkstra(1)
result_v1 = dijkstra(A)
result_v2 = dijkstra(B)

result = min(result1[A]+result_v1[B]+result_v2[V],result1[B]+result_v2[A]+result_v1[V])
print(result if result < INF else -1)