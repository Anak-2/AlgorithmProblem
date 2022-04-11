import sys
from tkinter.tix import MAX
input = sys.stdin.readline

MAX_INK = 1000000

case = int(input())
for c in range(case):
    printer = []
    for i in range(3):
        printer.append(list(map(int, input().split())))
    minC = MAX_INK
    minM = MAX_INK
    minY = MAX_INK
    minK = MAX_INK
    c1 = c+1
    print(f'Case #{c1}: ', end='')
    for r in range(3):
        minC = min(minC, printer[r][0])
        minM = min(minM, printer[r][1])
        minY = min(minY, printer[r][2])
        minK = min(minK, printer[r][3])
    if minC < MAX_INK:
        if minC + minM < MAX_INK:
            if minC + minM + minY < MAX_INK:
                if minC + minM + minY + minK < MAX_INK:
                    print("IMPOSSIBLE")
                else:
                    k = MAX_INK - minC - minM - minY
                    print(f'{minC} {minM} {minY} {k}')
            else:
                y = MAX_INK - minC - minM
                print(f'{minC} {minM} {y} 0')
        else:
            m = MAX_INK - minC
            print(f'{minC} {m} 0 0')
    else:
        print("1000000 0 0 0")