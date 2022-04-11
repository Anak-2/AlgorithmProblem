import sys
import math
input = sys.stdin.readline
a,b = map(int,input().split())
arr = [list(map(int, input().split())) for _ in range(a)]
initial_arr = [item[:] for item in arr]
# num = 1
def get_square(arr, power, prev):
    # global num
    # print("%d"%(num))
    # num += 1
    if power == 0:
        for i in range(a):
            for j in range(a):
                arr[i][j] = arr[i][j]%1000
        return arr
    n = 1
    while n <= power:
        tmp_arr = [[0]*a for _ in range(a)]
        for i in range(a):
            for j in range(a):
                for k in range(a):
                    tmp_arr[i][j] += arr[i][k]*arr[k][j]
                tmp_arr[i][j] = tmp_arr[i][j] % 1000
        arr = [item[:] for item in tmp_arr]
        n += 1
    prev -= pow(2,power)
    # for x in arr:2 5
    #     print(" ".join(map(str,x)))
    if prev > 1:
        arr2 = get_square(initial_arr,int(math.log2(prev)),prev)
        result = [[0]*a for _ in range(a)]
        for i in range(a):
            for j in range(a):
                for k in range(a):
                    result[i][j] += arr[i][k]*arr2[k][j]
                result[i][j] = result[i][j]%1000
        return result
    return arr

arr = get_square(arr,int(math.log2(b)),b)

if b%2 != 0 and b != 1:
    result = [[0]*a for _ in range(a)]
    for i in range(a):
        for j in range(a):
            for k in range(a):
                result[i][j] += arr[i][k]*initial_arr[k][j]
            result[i][j] = result[i][j]%1000
    for x in result:
        print(" ".join(map(str,x)))
else:
    for x in arr:
        print(" ".join(map(str,x)))