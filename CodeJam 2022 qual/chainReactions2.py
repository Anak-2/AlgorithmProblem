import sys
input = sys.stdin.readline

def isLeaf(node):
    if len(node) == 1:
        return True
    return False

#find minimum value from candidate and swap with parameter value
def findMinAndUpdate(candidate, value):
    min = 10**9
    index = 0
    for i, val in enumerate(candidate):
        if min > val:
            min = val
            index = i
    if min < value:
        candidate[index] = value
    return candidate

#node have own value(node[0]) and child's index(node[1])
def findCandidate(tree, node):
    candidate = []
    for i in node[1]:
        if isLeaf(tree[i]) == True:
            candidate.extend(tree[i])
        else:
            candidate.extend(findCandidate(tree, tree[i]))
    findMinAndUpdate(candidate, node[0])
    return candidate

def getSum(finalList):
    total = 0
    for i in finalList:
        total += i
    return total

case = int(input())
for c in range(case):
    roots = list()
    n = int(input())
    tree = [[] for _ in range(n+1)]
    for index, item in enumerate(list(map(int,input().split())), start=1):
        tree[index].append(item)
    node_connected = list(map(int,input().split()))
    
    #To connect parent with child
    for index,value in enumerate(node_connected, start=1):
        if value == 0:
            roots.append(index)
        else:
            if len(tree[value]) == 1:
                tree[value].append([index])
            else:
                tree[value][1].append(index)
    
    finalSum = 0
    for root in roots:
        if isLeaf(tree[root]) != True:
            finalSum += getSum(findCandidate(tree, tree[root]))
        else:
            finalSum += tree[root][0]
    
    c1 = c+1
    print(f'Case #{c1}: ', end='')
    print(finalSum)
