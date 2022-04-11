from collections import deque

n = int(input())
arr = [[0]*n for _ in range(n)]
stack = deque()
for i in range(n):
    arr[i] = list(map(int, input()))
sector = list()
def groupping(list):
    for i in range(n):
        for j in range(n):
            if arr[i][j] == 1:
                cnt = 1
                arr[i][j] = 0
                dx = [-1,1,0,0]
                dy = [0,0,-1,1]
                stack.append([i,j])
                while stack:
                    p = stack.pop()
                    for k in range(4):
                        if 0 <= p[0]+dy[k] < n and 0 <= p[1]+dx[k] < n:
                            if arr[p[0]+dy[k]][p[1]+dx[k]] == 1:
                                stack.append([p[0]+dy[k],p[1]+dx[k]])
                                arr[p[0]+dy[k]][p[1]+dx[k]] = 0
                                cnt += 1
                sector.append(cnt)
groupping(arr)
numSector = len(sector)
print(numSector)
sector.sort()
for index in range(numSector):
    print(sector[index])