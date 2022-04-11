import sys
#파이썬 재귀함수를 이용할때 필수!!
#파이썬의 기본 재귀 깊이 제한은 1000이기 때문
sys.setrecursionlimit(10**6)

n = int(input())
inorder = list(map(int, input().split()))
postorder = list(map(int, input().split()))

#inorder에서 요소마다 index를 저장 -> list의 index() 함수는 느리기때문!!!!
pos = [0]*(n+1)
for i in range(n):
    pos[inorder[i]] = i

def divide(in_start, in_end, p_start, p_end):
    if (in_start > in_end) or (p_start > p_end):
        return
    
    parents = postorder[p_end]
    print(parents, end=' ')
    
    left = pos[parents] - in_start
    right = in_end - pos[parents]
    
    divide(in_start, in_start+left-1, p_start, p_start+left-1)
    divide(in_end-right+1, in_end, p_end-right, p_end-1)
    
divide(0, n-1, 0, n-1)
    
            