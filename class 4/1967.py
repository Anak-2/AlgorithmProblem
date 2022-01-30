from collections import deque
import sys
input = sys.stdin.readline
n = int(input())
tree = {i:[] for i in range(n+1)}

for i in range(n-1):
    s, e, w = map(int, input().split())
    tree[s].append([e,w])
    tree[e].append([s,w])

def bfs(root):
    visited = [-1 for _ in range(n+1)]
    result = [0, 0]
    stack = deque()
    stack.append((root, 0))
    visited[root] = 0
    while stack:
        now, weight = stack.popleft()
        for j in tree[now]:
            next, value = j[0], j[1]
            if visited[next] == -1:
                visited[next] = weight + value
                stack.append((next, visited[next]))
                if result[1] < visited[next]:
                    result[0] = next
                    result[1] = visited[next]
    return result

a,b = bfs(1)
c,d = bfs(a)
print(d)