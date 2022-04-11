INF = 999
n, m = map(int, input().split())
arr = [[INF]*n for _ in range(n)]

for i in range(m):
    a,b = map(int,input().split())
    a = a-1
    b = b-1
    arr[a][b]=arr[b][a]=1

def min_relation(n):
    for i in range(n):
        for j in range(n):
            for k in range(n):
                if j != k:
                    arr[j][k] = min(arr[j][k], arr[j][i]+arr[i][k])

def kevin(n):
    sum_list = [0 for _ in range(n)]
    for r in range(n):
        for c in range(n):
            if r != c:
                sum_list[r] = arr[r][c] + sum_list[r]
    min = sum_list[0]
    min_index = 1
    for i in range(n):
        if sum_list[i] < min:
            min = sum_list[i]
            min_index = i+1
    print(min_index)

min_relation(n)
kevin(n)