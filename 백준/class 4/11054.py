n = int(input())
arr = list(map(int, input().split()))
dp = [[1,1] for _ in range(n)]
result = [0 for _ in range(n)]

#left increase
for i in range(n):
    for j in range(i):
        if arr[i] > arr[j] and dp[j][0] >= dp[i][0]:
            dp[i][0] = dp[j][0] + 1
#right decrease
for i in range(n-1, -1, -1):
    for j in range(n-1, i, -1):
        if arr[i] > arr[j] and dp[j][1] >= dp[i][1]:
            dp[i][1] = dp[j][1] + 1
#left, right 합치고 +1 => 바이토닉 부분 수열
for i in range(n):
    result[i] = dp[i][0] + dp[i][1] - 1
print(max(result))