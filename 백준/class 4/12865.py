import sys
input = sys.stdin.readline
n, w = map(int, input().split())
bags = list()
for i in range(n):
    bags.append(list(map(int, input().split())))
prev_max = [0 for _ in range(w+1)]
current_max = [0 for _ in range(w+1)]

for i in range(n):
    for j in range(1, w+1):
        weight = bags[i][0]
        value = bags[i][1]
        if weight <= j:
            current_max[j] = max(value+prev_max[j-weight], prev_max[j])
        else:
            current_max[j] = prev_max[j]
    prev_max = current_max[:]
print(prev_max[w])