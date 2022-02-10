arr_len = int(input())
arr = list(map(int, input().split()))
prev = [1]*arr_len
value = arr[0]
cnt = 1
for i in range(1, arr_len):
    if value < arr[i]:
        cnt += 1
        value = arr[i]
        prev[i] = cnt

for i in range(1, arr_len):
    cnt = 0
    for j in range(i):
        if arr[i] > arr[j] and cnt < prev[j]:
            cnt = prev[j]
    value = arr[i]
    if cnt+1 <= prev[i]: continue
    elif cnt == 0:
        prev[i] = 1
    else: prev[i] = cnt+1
    for k in range(i+1, arr_len):
        if value < arr[k]:
            if cnt >= prev[k]:
                cnt += 1
                prev[k] = cnt
                value = arr[k]
            else:
                break
print(max(prev))