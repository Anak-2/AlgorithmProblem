from collections import deque
import sys
n = int(input())
for _ in range(n):
    flag = 1
    rev = 0
    order = sys.stdin.readline().rstrip()
    length = int(input())
    #슬라이싱 이므로 두 번째부터 마지막 -1 번째 요소임!
    arr = sys.stdin.readline().rstrip()[1:-1].split(",")
    queue = deque(arr)
    print(queue)
    #이 문장을 실행안하면 queue의 길이가 1로 측정!
    if length == 0:
        queue = []
    for i in range(len(order)):
        if order[i] == 'R':
            rev += 1
        elif order[i] == 'D':
            #queue가 empty인데 D일 경우
            if len(queue) < 1:
                flag = 0
                print("error")
                break
            else:
                if rev%2 == 0:
                    queue.popleft()
                else:
                    queue.pop()
    if rev%2 == 0 and flag == 1:
        print("["+",".join(queue)+"]")
    elif flag == 1:
        queue.reverse()
        print("["+",".join(queue)+"]")