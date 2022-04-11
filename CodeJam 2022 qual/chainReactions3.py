#input = sys.stdin.readline을 쓸 경우 input이 1줄을 넘는 byte를 읽지 못하므로 사용하면 오류 발생함!
import sys
#recursion depth 때문에 오류 발생
sys.setrecursionlimit(10 ** 8)

class finalSum:
    def __init__(self):
        self.sum = 0
        
def isLeaf(node):
    if len(node) <= 1:
        return True
    return False

#find minimum value from candidate and add rest of candidate
def findMinAndUpdate(candidate, value, finalSum):
    min = 10**9+1
    index = None
    for i, val in enumerate(candidate):
        if min > val:
            min = val
            index = i
    if min < value:
        candidate[index] = value
    for i, val in enumerate(candidate):
        if i != index:
            finalSum.sum += val
    return candidate[index]

#node have own value(node[0]) and child's index(node[1])
def findCandidate(tree, node, finalSum):
    candidate = []
    # print(f'node[0]: {node[0]} node[1]: {node[1]}')
    for i in node[1]:
        if isLeaf(tree[i]) == True:
            candidate.extend(tree[i])
        else:
            candidate.extend(findCandidate(tree, tree[i], finalSum))
    candidate = [findMinAndUpdate(candidate, node[0], finalSum)]
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
    
    fs = finalSum()
    # print(roots)
    # for idx, i in enumerate(tree):
    #     print(f'tree{idx}: {i}')
    for root in roots:
        if isLeaf(tree[root]) != True:
            h = getSum(findCandidate(tree, tree[root], fs))
            fs.sum += h
        else:
            fs.sum += tree[root][0]
    c1 = c+1
    print(f'Case #{c1}: ', end='')
    print(fs.sum)