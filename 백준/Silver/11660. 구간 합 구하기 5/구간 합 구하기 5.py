import sys
input = sys.stdin.readline
n,m = map(int, input().split())
dp = [[0 for _ in range(n+1)] for _ in range(n+1)]
s = [list(map(int, input().split())) for _ in range(n)]
for i in range(n):
    for j in range(n):
        dp[i+1][j+1] = dp[i][j+1] + dp[i+1][j] - dp[i][j] + s[i][j]

for _ in range(m):
    x1,y1,x2,y2 = map(int, input().split())
    result = dp[x2][y2] - dp[x1-1][y2] - dp[x2][y1-1] + dp[x1-1][y1-1]
    print(result)