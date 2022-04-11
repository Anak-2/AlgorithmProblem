import sys
n = int(sys.stdin.readline())
time = [[0]*2 for _ in range(n)]
for i in range(n):
    time[i][0], time[i][1] = map(int, sys.stdin.readline().split())
time.sort(key = lambda x: (x[1], x[0]))
cnt = 1
end_time = time[0][1]

for index in range(1,len(time)):
    if time[index][0] >= end_time:
        cnt += 1
        end_time = time[index][1]
        
print(cnt)