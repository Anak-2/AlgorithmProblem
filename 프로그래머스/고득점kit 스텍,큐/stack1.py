import sys

def solution(arr):
    top = -1
    answer = []
    for i in arr:
        if not answer or arr[top] != i:
            answer.append(i)
        top += 1
    # [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
    return answer

lines = sys.stdin.readlines()
for line in lines:
    inputArr = list(map(int, input().split()))
    answer = solution(inputArr);
    print(answer)