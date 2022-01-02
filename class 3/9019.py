from collections import deque
def D(s):
    ds = s*2
    if ds >= 10000:
        ds = ds - 10000
    return ds
def S(s):
    ds = s-1
    if s-1 < 0:
        ds = 9999
    return ds
def R(s):
    p1 = s//10
    p2 = s%10*1000
    p3 = p1+p2
    return p3
def L(s):
    p1 = (s*10)%10000
    p2 = s//1000
    p3 = p1+p2
    return p3

def DSLR(start,target):
    result = deque()
    result.append([start,""])
    visited = [0 for _ in range(10000)]
    while result:
        n,c = result.popleft()
        d = D(n)
        s = S(n)
        l = L(n)
        r = R(n)
        if d == target:
            return c+'D'
        elif visited[d] != 1:
            result.append([d,c+'D'])
            visited[d] = 1
        if s == target:
            return c+'S'
        elif visited[s] != 1:
            result.append([s,c+'S'])
            visited[s] = 1
        if l == target:
            return c+'L'
        elif visited[l] != 1:
            result.append([l,c+'L'])
            visited[l] = 1
        if r == target:
            return c+'R'
        elif visited[r] != 1:
            result.append([r,c+'R'])
            visited[r] = 1
    
test = int(input())    
for i in range(test):
    s, t = map(int,input().split())
    print(DSLR(s,t))