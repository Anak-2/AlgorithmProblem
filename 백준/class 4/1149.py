#RGB 거리
import sys
input = sys.stdin.readline
n = int(input())
home_list = []
for _ in range(n):
    home_list.append(list(map(int, input().split())))
for i in range(1,n):
    home_list[i][0] = min(home_list[i-1][1],home_list[i-1][2]) + home_list[i][0]
    home_list[i][1] = min(home_list[i-1][0],home_list[i-1][2]) + home_list[i][1]
    home_list[i][2] = min(home_list[i-1][0],home_list[i-1][1]) + home_list[i][2]
print(min(home_list[n-1]))