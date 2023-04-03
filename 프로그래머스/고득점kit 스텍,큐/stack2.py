import sys

progresses = list(map(int, sys.stdin.readline().split()))
speeds = list(map(int, sys.stdin.readline().split()))

answer = []

def solution(progresses, speeds):
    while progresses:
        curIdx = 0
        if(progresses[curIdx] < 100):
            # / 은 float 반환, // 은 int 반환
            takeTime = int((100 - progresses[curIdx])/speeds[curIdx])
            if (100 - progresses[curIdx])%speeds[curIdx] > 0:
                takeTime += 1
        completedProgress = 1
        progresses.pop(0)
        speeds.pop(0)
        flag = 0
        # print("take time {0}".format(takeTime))
        for i in range(len(progresses)):
            if progresses[i] + speeds[i]*takeTime >= 100 and flag == 0:
                completedProgress += 1
            else:
                progresses[i] += speeds[i]*takeTime
                flag = 1
        for i in range(completedProgress - 1):
            progresses.pop(0)
            speeds.pop(0)
        answer.append(completedProgress)
        # print("completed progresses: {0}".format(completedProgress))
        # print("progresses: {0}".format(progresses))
        # print("speeds: {0}".format(speeds))

solution(progresses, speeds)
# print("answer: {0}".format(answer))
print(answer)