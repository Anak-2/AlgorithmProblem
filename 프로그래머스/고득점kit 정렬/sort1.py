import sys
sys.setrecursionlimit(10000)

array = list(map(int,input().split()))
commands = []
nextInput = input()
while(nextInput):
    commands.append(list(map(int,nextInput.split())))
    nextInput = input()
    
print(array)
print(commands)

def solution(array, commands):
    answer = []
    for c in commands:
        i,j,k = c[0], c[1], c[2]
        print("i: {0} j: {1} k:{2}".format(i,j,k))
        numbers = array[i-1:j]
        print(numbers)
        numbers = quickSort(numbers)
        print(numbers)
        answer.append(numbers[k-1])
    return answer

def quickSort(numbers):
    if not numbers or len(numbers) <= 1:
        return numbers
    sorted_array = []
    pivot = len(numbers)//2
    left_array = []
    right_array = []
    equal_pivot = []
    for i in numbers:
        if i < numbers[pivot]:
            left_array.append(i)
        elif i > numbers[pivot]:
            right_array.append(i)
        else:
            equal_pivot.append(i)
    left_array = quickSort(left_array)
    right_array = quickSort(right_array)
    left_array.extend(equal_pivot)
    left_array.extend(right_array)
    return left_array
    

print(solution(array, commands))