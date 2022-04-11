import heapq
import sys;read=sys.stdin.readline
t = int(read())
def priority_queue():
    minHeap = []
    maxHeap = []
    visited = [0 for _ in range(1000000)]
    n = int(read())
    for i in range(n):
        operand = read().split()
        if operand[0] == 'I':
            heapq.heappush(minHeap,(int(operand[1]),i))
            heapq.heappush(maxHeap,(-int(operand[1]),i))
            visited[i] = 1
        elif operand[1] == '-1':
            while minHeap and not visited[minHeap[0][1]]:
                heapq.heappop(minHeap)
            if minHeap:
                visited[minHeap[0][1]] = 0
                heapq.heappop(minHeap)
        else:
            while maxHeap and not visited[maxHeap[0][1]]:
                heapq.heappop(maxHeap)
            if maxHeap:
                visited[maxHeap[0][1]] = 0
                heapq.heappop(maxHeap)
    
    min, max = 0, 0
    while minHeap and visited[minHeap[0][1]] == 0:
        heapq.heappop(minHeap)
    if minHeap:
        min = minHeap[0][0]
    while maxHeap and visited[maxHeap[0][1]] == 0:
        heapq.heappop(maxHeap)
    if maxHeap:
        max = -1*maxHeap[0][0]

    if min != 0 and max != 0:
        print(max, end=" ")
        print(min)
    else:
        print("EMPTY")

for _ in range(t):
    priority_queue()