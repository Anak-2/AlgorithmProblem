import sys
input = sys.stdin.readline
from collections import deque

result = list()
stack = list()
op_priority = {'+':1, '-':1, '*':2, '/':2, '(':0, ')':0}
function = list(input().rstrip())

def postfix(function):
    for i in function:
        if i not in op_priority:
            result.append(i)
        elif i == '(':
            stack.append(i)
        elif i == ')':
            while stack:
                top = stack.pop()
                if top == '(':
                    break
                result.append(top)
        elif stack and op_priority[i] <= op_priority[stack[-1]]:
            # print("i: %s"%(i))
            # print("top: %s"%(stack[-1]))
            while stack:
                result.append(stack.pop())
                if not stack or op_priority[i] > op_priority[stack[-1]]:
                    break
            stack.append(i)
        else:
            stack.append(i)
    while stack:
        result.append(stack.pop())

postfix(function)
print("".join(result))
