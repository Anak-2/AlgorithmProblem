import sys
input = sys.stdin.readline
import copy
size = int(input())
triangle = [0 for _ in range(size)]
for i in range(size):
    triangle[i] = list(map(int, input().split()))
triangle2 = copy.deepcopy(triangle)
for i in range(size-1):
    for j in range(len(triangle[i])):
        triangle[i+1][j] = max(triangle[i+1][j], triangle2[i+1][j] + triangle[i][j])
        triangle[i+1][j+1] = max(triangle[i+1][j+1], triangle2[i+1][j+1]+triangle[i][j])
max_value = max(triangle[size-1])
print(max_value)