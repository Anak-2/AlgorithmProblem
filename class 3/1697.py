from collections import deque

n,m = map(int, input().split())
MAX = 10 ** 5
location = deque()
location.append(n)
def find(m):
    while location:
        x = location.popleft()
        if x == m:
            print(dist[x])
            break
        for nx in (x-1, x+1, x*2):
            if 0 <= nx <= MAX and not dist[nx]:
                dist[nx] = dist[x] + 1
                location.append(nx)

dist = [0] * (MAX+1)
find(m)