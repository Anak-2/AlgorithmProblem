import sys
input = sys.stdin.readline

def makePlusMinus(c):
    plusMinus = []
    for i in range(c):
        if i%2 == 0:
            plusMinus.append('+')
        else:
            plusMinus.append('-')
    return plusMinus

def makePeriods(c):
    periods = []
    for i in range(c):
        if i%2 == 0:
            periods.append('|')
        else:
            periods.append('.')
    return periods
            
def makePunch(r,c):
    r2 = r*2+1
    c2 = c*2+1
    punch = []
    for row in range(r2):
        if row%2 == 0:
            punch.append(makePlusMinus(c2))
        else:
            punch.append(makePeriods(c2))
    punch[0][0] = '.'
    punch[0][1] = '.'
    punch[1][0] = '.'
    for i in range(r2):
        for j in range(c2):
            print(punch[i][j], end='')
        print()

case = int(input())
for k in range(case):
    r,c = map(int, input().split())
    K=k+1
    print(f'Case #{K}:')
    makePunch(r,c)