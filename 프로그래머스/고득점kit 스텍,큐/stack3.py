import sys

answer = []

input = sys.stdin.readline
last_pop_index = -1
priorities = list(map(int, input().split()))
# print(priorities)
arr = [[] for _ in range(10)]

for idx, i in enumerate(priorities):
    arr[i].append(idx)
# print(arr)

for i in range(9):
    cur = 9-i
    # print("answer: {0}".format(answer))
    if arr[cur]:
        if last_pop_index == -1:
            while arr[cur]:
                answer.append(arr[cur][0])
                last_pop_index = arr[cur][0]
                arr[cur].pop(0)
            continue
        for idx, j in enumerate(arr[cur]):
            # print("idx: {0}".format(idx))
            if j > last_pop_index:
                # print("current stack: {0}".format(cur))
                # print("where index start to pop: {0}".format(j))
                # print("what idx? {0}".format(idx))
                for i in range(len(arr[cur])-idx):
                    answer.append(arr[cur][idx])
                    last_pop_index = arr[cur][idx]
                    arr[cur].pop(idx)
                break
        if arr[cur]:
            while arr[cur]:
                answer.append(arr[cur][0])
                arr[cur].pop(0)
                last_pop_index = j
location = int(input())
print(answer)
for idx, i in enumerate(answer):
    if i == location:
        print(idx+1)
        break