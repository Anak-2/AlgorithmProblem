import sys

n = int(sys.stdin.readline())

class MinHeap:
    def __init__(self):
        self.queue = [None]
        self.output = []
    @staticmethod
    def parent(index):
        return index//2
    def insert(self, n):
        self.queue.append(n)
        i = len(self.queue) - 1
        while i > 1:
            parent = self.parent(i)
            if self.queue[parent] > self.queue[i]:
                self.queue[parent], self.queue[i] = self.queue[i], self.queue[parent]
                i = parent
            else:
                break
    def rightChild(self, n):
        return n*2+1
    def leftChild(self, n):
        return n*2
    def minHeapify(self, i):
        while i < len(self.queue):
            right = self.rightChild(i)
            left = self.leftChild(i)
            min = self.queue[i]
            temp_minIndex = 0
            if left < len(self.queue) and self.queue[left] < min:
                min = self.queue[left]
                temp_minIndex = left
            if right < len(self.queue) and self.queue[right] < min:
                min = self.queue[right]
                temp_minIndex = right
            if min != self.queue[i]:
                self.queue[i], self.queue[temp_minIndex] = self.queue[temp_minIndex], self.queue[i]
                i = temp_minIndex
            else:
                return
    def delete(self):
        self.queue[1], self.queue[len(self.queue)-1] = self.queue[len(self.queue)-1], self.queue[1]
        self.queue.pop(len(self.queue)-1)
        self.minHeapify(1)
    def printMin(self):
        if len(self.queue) == 1:
            self.output.append(0)
        else:
            self.output.append(self.queue[1])
            self.delete()
    def printOutput(self):
        for index in range(len(self.output)):
            print(self.output[index])
            
mh = MinHeap()
for _ in range(n):
    num = int(sys.stdin.readline())
    if num == 0:
        mh.printMin()
    elif num != 0:
        mh.insert(num)
mh.printOutput()