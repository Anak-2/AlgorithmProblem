import sys
input = sys.stdin.readline
from collections import deque
n = int(input())
# 메모리 초과
# graph = [0 for _ in range(n)]
# for i in range(n):
#     graph[i] = list(map(int, input().split()))

def min_max():
    a, b, c = map(int, input().split())
    min_dp = [a,b,c]
    max_dp = [a,b,c]
    min_tmp = [0]*3
    max_tmp = [0]*3
    for i in range(1,n):
        a, b, c = map(int, input().split())
        min_tmp[0] = a + min(min_dp[0], min_dp[1])
        max_tmp[0] = a + max(max_dp[0], max_dp[1])
        min_tmp[1] = b + min(min_dp[0], min_dp[1], min_dp[2])
        max_tmp[1] = b + max(max_dp[0], max_dp[1], max_dp[2])
        min_tmp[2] = c + min(min_dp[1], min_dp[2])
        max_tmp[2] = c + max(max_dp[1], max_dp[2])
        min_dp = min_tmp[:]
        max_dp = max_tmp[:]
    return (min(min_dp),max(max_dp))

min, max = min_max()
print(max, end=' ')
print(min)