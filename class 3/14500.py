def dfs(y, x, depth, current):
    #print("y: %d x: %d current: %d" %(y,x,current))
    global arr, m, n, max_sum, greatest_value, visited
    if depth == 4:
        max_sum = max(max_sum, current)
        return
    if current+(4-depth)*greatest_value > max_sum:
        d = [[-1,0],[1,0],[0,-1],[0,1]]
        for dy, dx in d:
            ay, ax = y+dy, x+dx
            if 0 <= ay < m and 0 <= ax < n:
                if visited[ay][ax] != 1:
                    visited[ay][ax] = 1
                    if depth == 2:
                        dfs(y, x, depth+1, current+arr[ay][ax])
                    dfs(ay, ax, depth+1, current+arr[ay][ax])
                    visited[ay][ax] = 0

m,n = map(int, input().split())
arr = [[0 for _ in range(n)] for _ in range(m)]
for i in range(m):
    arr[i] = list(map(int, input().split()))
greatest_value = max(map(max, arr))
visited = [[0]*n for _ in range(m)]
max_sum = 0
for i in range(m):
    for j in range(n):
        visited[i][j] = 1
        dfs(i, j, 1, arr[i][j])
        visited[i][j] = 0
print(max_sum)