import sys
test = int(sys.stdin.readline())
for i in range(test):
    n = int(sys.stdin.readline())
    arr = []
    for j in range(n):
        if j < 3:
            arr.append(1)
        else:
            arr.append(arr[j-3]+arr[j-2])
    print(arr[len(arr)-1])