listA = list(input().strip())
listB = list(input().strip())

dp = [[0 for _ in range(len(listA)+1)] for _ in range(len(listB)+1)]

for i in range(1, len(listB)+1):
    for j in range(1, len(listA)+1):
        if listA[j-1] == listB[i-1]:
            dp[i][j] = dp[i-1][j-1] + 1
        else:
            dp[i][j] = max(dp[i-1][j], dp[i][j-1])
if len(listA) == 0 or len(listB) == 0:
    print(0)        
else:
    print(dp[-1][-1])