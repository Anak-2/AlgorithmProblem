n = int(input())
m = int(input())
remote_controller = {str(i) for i in range(10)}

if m>0:
    remote_controller -= set(map(str,input().split()))
current_channel = 100
min_cnt = abs(current_channel - n)
for channel in range(1000000):
    flag = True
    for j in range(len(str(channel))):
        if str(channel)[j] not in remote_controller:
            flag = False
            break
    if flag == True:
        min_cnt = min(min_cnt, abs(channel-n)+len(str(channel)))
print(min_cnt)