import sys
input = sys.stdin.readline

case = int(input())
for c in range(case):
    current = 0
    index = 0
    c1 = c+1
    length = int(input())
    dices = list(map(int,input().split()))
    dices.sort()
    print(f'Case #{c1}: ', end='')
    while index < length:
        if current < dices[index]:
            current += 1
            index += 1
        else:
            index += 1
    print(current)
    