n = int(input()) #계단의 개수
arr = list()
for i in range(n):
    arr.append(int(input()))
dp = [0 for _ in range(n)]
dp[0] = arr[0]
if n == 1:
    print(dp[0])
elif n == 2:
    dp[1] = arr[0] + arr[1]
    print(dp[1])
elif n == 3:
    dp[2] = max(arr[0]+arr[2], arr[1]+arr[2])
    print(dp[2])
else:
    dp[1] = arr[0] + arr[1]
    dp[2] = max(arr[0]+arr[2], arr[1]+arr[2])
    for i in range(3,n):
        dp[i] = max(dp[i-3]+arr[i-1]+arr[i], dp[i-2]+arr[i])
    print(dp[n-1])