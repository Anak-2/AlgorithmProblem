num = int(input())
dp = [0,0,1,1] #0,1,2,3일 때 걸리는 시간
for i  in range(4,num+1):
    dp.append(dp[i-1]+1)
    if i%3 == 0:
        dp[i] = min(dp[i//3]+1,dp[i])
    if i%2 == 0:
        dp[i] = min(dp[i//2]+1,dp[i])
print(dp[num])