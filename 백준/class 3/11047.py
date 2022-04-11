import sys
input = sys.stdin.readline
n, k = map(int, input().split())
price = [0 for _ in range(n)]
for i in range(n):
    price[i] = int(input())
value = 0
index = len(price) - 1
cnt = 0
while value < k:
    if price[index] + value <= k:
        rest = (k-value)//price[index]
        value = value + price[index]*rest
        cnt += rest
        index -= 1
        if value == k:
            break
    elif index > -1:
        index -= 1
    else:
        print("Error")
        break
print(cnt)