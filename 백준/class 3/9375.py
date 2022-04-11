import sys
input = sys.stdin.readline
test = int(input())
for i in range(test):
    fashion = {}
    n = int(input())
    for j in range(n):
        cloth, category = input().split()
        if category in fashion:
            fashion[category] += 1
        else:
            #옷 안 입는거 까지 고려
            fashion[category] = 2
    result = 1
    for value in fashion.values():
        result = result*value
    result = result - 1
    print(result)