n = int(input())
m = int(input())
arr = [[0]*n for _ in range(n)]
for _ in range(m):
    i, j = map(int, input().split())
    arr[i-1][j-1], arr[j-1][i-1] = 1, 1
cnt = 0
visited = [0 for _ in range(n)]
stack = []
visited[0] = 1
def infect(k):
    global cnt
    for i in range(n):
        if arr[k][i] == 1 and visited[i] != 1:
            cnt += 1
            visited[i] = 1
            stack.append(i)
    while stack:
        next = stack.pop()
        infect(next)
infect(0)
print(cnt)