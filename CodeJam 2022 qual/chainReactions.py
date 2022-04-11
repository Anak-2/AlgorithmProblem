from asyncio.windows_events import NULL
import sys
input = sys.stdin.readline

def find_max(start):
    max_value = 0
    now = start
    cnt = 0
    while True:
        next = node_connection[now-1]
        if visited[next] != 1:
            max_value = max(max_value, node_list[now-1])
            now = next
        else:
            max_value = max(max_value, node_list[now-1])
            break
    return max_value, now, cnt

case = int(input())

for c in range(case):
    num = int(input())
    #value of nodes
    node_list = list(map(int, input().split()))
    #link of node 
    node_connection = list(map(int, input().split()))
    c1 = c+1
    print(f'Case #{c1}: ',end='')
    #To record trigger index
    triggers = list()
    #the nodes which have child (It needs to find trigger nodes)
    is_parent_node = [0 for _ in range(num+1)]
    #To manage visited nodes
    visited = [0 for _ in range(num+1)]
    visited[0] = 1
    #sum of max
    sum = 0
    for n in node_connection:
        is_parent_node[n] = 1
    for i in range(num+1):
        if is_parent_node[i] == 0:
            triggers.append(i)
    #to find maximun difference
    while triggers:
        dif = -(10**9)
        index = triggers[0]
        max_val = 0
        max_idx = 0
        final_max_val = 0
        final_max_idx = 0
        for i in triggers:
            # print(f'i = {i}')
            #find max's value and index during one trigger travel
            max_val, max_idx, cnt = find_max(i)
            # print(f'com = {com}')
            tmp = max(dif, max_val - node_list[i-1])
            if tmp != dif:
                # print("NOT EQUAL")
                index = i
                dif = tmp
                final_max_val = max_val
                final_max_idx = max_idx
        print(f'index = {index}')
        print(f'visited = {visited}')
        print(f'triggers = {triggers}')
        print(f'final_max_val = {final_max_val}')
        print(f'final_max_idx = {final_max_idx}')
        sum += final_max_val
        visited[final_max_idx] = 1
        triggers.remove(index)
    print(sum)