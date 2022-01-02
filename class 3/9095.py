from collections import deque
import sys
t = int(sys.stdin.readline())
result = deque()
for _ in range(t):
    cnt = 0
    result.append(0)
    n = int(sys.stdin.readline())
    while result:
        num = result.popleft()
        if(num+1)==n:
            cnt += 1
        elif num+1 < n:
            result.append(num+1)
        if(num+2)==n:
            cnt += 1
        elif num+2 < n:
            result.append(num+2)
        if(num+3)==n:
            cnt += 1
        elif num+3 < n:
            result.append(num+3)
    print(cnt)