t = int(input())
for i in range(t):
    flag = 0
    m,n,x,y = map(int, input().split())
    while x <= m*n:
        if (x-y)%n == 0:
            print(x)
            flag = 1
            break
        x += m
    if flag != 1:
        print(-1)