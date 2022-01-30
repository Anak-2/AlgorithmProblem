from collections import deque
import sys
input = sys.stdin.readline
text = list(input().rstrip())
bomb = list(input().rstrip())
temp = deque()
temp.append(0)
stack = list()
for c in text:
    stack.append(c)
    if temp and c == bomb[temp[0]]:
        temp[0] += 1
        if temp[0] == len(bomb):
            del stack[-len(bomb):]
            temp.popleft()
    elif c == bomb[0]:
        if len(bomb) == 1:
            stack.pop()
            continue
        temp.appendleft(1)
    elif temp and temp[0] != 0:
        temp.clear()
        temp.append(0)
        
if stack:
    print(''.join(stack))
else:
    print("FRULA")