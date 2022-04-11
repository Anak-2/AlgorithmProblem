import sys
input = sys.stdin.readline

n,m = map(int, input().split())
d = [input().strip() for i in range(n)]
b = [input().strip() for i in range(m)]
db = sorted(list(set(d) & set(b)))
# for _ in range(n):
#     d.append(input().strip())
# for _ in range(m):
#     b.append(input().strip())
print(len(db))
for i in db:
    print(i)