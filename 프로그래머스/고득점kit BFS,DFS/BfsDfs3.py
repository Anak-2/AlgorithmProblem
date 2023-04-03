# import sys
# input = sys.stdin.readline()
def solution(maps):
    answer = 0
    stack = list()
    # maps 행
    m = len(maps)
    # maps 열
    n = len(maps[0])
    # (r,c)는 현재 위치
    r,c=0,0
    # s는 몇 번째 step인지
    s=1
    rd = [0,0,-1,1]
    cd = [1,-1,0,0]
    # 현재 위치에서 갈 수 있는 곳 stack에 저장, 다음 갈 곳에 +1
    nextStack = []
    for i in range(4):
        if r+rd[i] < m and r+rd[i] >= 0 and c+cd[i] < n and c+cd[i] >= 0:
            if maps[r+rd[i]][c+cd[i]] != 0:
                maps[r+rd[i]][c+cd[i]] += 1
                nextStack.append([r+rd[i], c+cd[i]])
    maps[0][0] = -1
    while(nextStack):
        stack = nextStack
        nextStack = []
        while(stack):
            [r,c] = stack.pop()
            maps[r][c] = -1
            if r == m-1 and c == n-1:
                answer = s+1
                break
            for i in range(4):
                if r+rd[i] < m and r+rd[i] >= 0 and c+cd[i] < n and c+cd[i] >= 0:
                    if maps[r+rd[i]][c+cd[i]] == 1:
                        nextStack.append([r+rd[i], c+cd[i]])
        s += 1
    if answer == 0:
        return -1
    return answer
maps = []
iter = int(input())
for i in range(iter):
    maps.append(list(map(int, input().split())))
print(solution(maps))