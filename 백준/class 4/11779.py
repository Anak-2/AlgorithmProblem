#최소비용 구하기2
#dijkstra 이용
import sys
input = sys.stdin.readline
INF = float('inf')
import heapq
from collections import deque
n = int(input())
m = int(input())
#start, end, cost
bus = [[] for _ in range(n+1)]
for _ in range(m):
    s,e,c = map(int, input().split())
    bus[s].append((c,e))

def dijkstra(start, end, bus):
    distance = [INF for _ in range(n+1)]
    distance[start] = 0
    prev = [0 for _ in range(n+1)]
    stack = list()
    heapq.heappush(stack, (0,start))
    while stack:
        cd, cn = heapq.heappop(stack)
        if distance[cn] < cd:
            continue
        for nd, nn in bus[cn]:
            if distance[nn] > distance[cn] + nd:
                distance[nn] = distance[cn] + nd
                heapq.heappush(stack, (nd, nn))
                prev[nn] = cn
    return distance, prev

a,b = map(int, input().split())
distance, prev = dijkstra(a,b,bus)
next = b
p = deque()
while next != 0:
    p.appendleft(next)
    next = prev[next]

print(distance[b])
print(len(p))
for i in p:
    print(i, end=' ')