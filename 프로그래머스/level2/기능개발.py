import sys

# 완료된 상태, 하루 진행도
# [93, 30, 55][1, 30, 5][2, 1]
# 7일 소요, 3일 소요, 9일 소요
# 첫 번째 배포 하는 7일 째 -> 2개 배포
# 마지막 -> 1개 배포


def solution(progresses, speeds):
    answer = []
    while progresses:
        curIdx = 0
        # 맨 앞 프로세스가 어느 정도 날짜가 소요되는지 계산
        if (progresses[curIdx] < 100):
            takeTime = int((100 - progresses[curIdx])/speeds[curIdx])
            # 딱 100으로 안 나눠떨어지면 하루 더 걸린다
            if (100 - progresses[curIdx]) % speeds[curIdx] > 0:
                takeTime += 1
        completedProgress = 1  # 맨 앞 프로세스 완료
        progresses.pop(0)
        speeds.pop(0)
        flag = 0
        # 남은 프로세스들도 takeTime 만큼 진행시킨 후, 끝나는 프로세스가 있는지 검사
        for i in range(len(progresses)):
            # 프로세스가 100 이상일 경우
            if progresses[i] + speeds[i]*takeTime >= 100 and flag == 0:
                completedProgress += 1
            # 이전 프로세스가 종료돼야 다음 프로세스를 마무리할 수 있어서 flag는 1로 처리해서,
            # 프로세스가 100을 넘더라도 completedProgress를 1 증가시키지 않음
            else:
                progresses[i] += speeds[i]*takeTime
                flag = 1
        # 맨 앞 프로세스와 함께 종료되는 프로세스들 모두 pop
        for i in range(completedProgress - 1):
            progresses.pop(0)
            speeds.pop(0)
        answer.append(completedProgress)
    return answer
