minus = input().split('-')
num = []
sum = 0
result = 0
for i in minus:
    list = i.split('+')
    for j in list:
        sum += int(j)
    num.append(sum)
    sum = 0
for i in range(len(minus)):
    if i == 0:
        result = num[i]
    else:
        result = result - num[i]
print(result)