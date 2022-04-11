#트리의 순회

import sys
from collections import deque

n = int(input())
inorder = list(map(int, input().split()))
postorder = list(map(int, input().split()))
tree = {}
for i in range(1, n+1):
    tree[i] = [0,0]
root = deque()
visited = [0 for _ in range(n)]

inpos = [0]*(n+1)
for i in range(n):
    inpos[inorder[i]] = i
    
popos = [0]*(n+1)
for i in range(n):
    popos[postorder[i]]=i


def split_subtree(root, inorder_list):
    root_index = inpos[root]
    count_left = 0
    count_right = 0
    i = root_index
    while i>0:
        i -= 1
        if visited[i] == 0: 
            count_left += 1
        else:
            break
    i = root_index
    while i<n-1:
        i += 1
        if visited[i] == 0:
            count_right += 1
        else:
            break
    visited[root_index] = 1
    return count_left, count_right

def get_root(root, left_subtree_length, right_subtree_length, post_list):
    root_index = popos[root]
    if left_subtree_length > 0 and right_subtree_length > 0:
        right_root = post_list[root_index - 1]
        left_root = post_list[root_index - right_subtree_length - 1]
    elif left_subtree_length > 0 and right_subtree_length == 0:
        right_root = 0 #right_root가 없음!
        left_root = post_list[root_index - 1]
    elif left_subtree_length == 0 and right_subtree_length > 0:
        right_root = post_list[root_index - 1]
        left_root = 0
    else:
        right_root = 0
        left_root = 0
    return left_root, right_root

root.append(postorder[-1])
while root:
    tmp_root = root.popleft()
    left_len, right_len = split_subtree(tmp_root, inorder)
    left_root, right_root = get_root(tmp_root, left_len, right_len, postorder)
    if left_root != 0:
        tree[tmp_root][0] = left_root
        root.append(left_root)
    if right_root != 0:
        tree[tmp_root][1] = right_root
        root.append(right_root)
        
def preorder(Node):
    if Node:
        print(Node, end=' ')
        preorder(tree[Node][0])
        preorder(tree[Node][1])

preorder(postorder[-1])
