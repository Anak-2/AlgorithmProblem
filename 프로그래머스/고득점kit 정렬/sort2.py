def solution(numbers):
    answer = ''
    numbers = quickSort(numbers)
    for i in numbers:
        answer += str(i)
    return answer

def quickSort(numbers):
    if len(numbers) <= 1:
        return numbers
    pivot = len(numbers)//2
    left_array = []
    right_array = []
    pivot_array = []
    
    for i in range(len(numbers)):
        if int(str(numbers[i])+str(numbers[pivot])) > int(str(numbers[pivot]) + str(numbers[i])):
            left_array.append(numbers[i])
        elif int(str(numbers[i])+str(numbers[pivot])) < int(str(numbers[pivot]) + str(numbers[i])):
            right_array.append(numbers[i])
        else:
            pivot_array.append(numbers[i])
    left_array = quickSort(left_array)
    right_array = quickSort(right_array)
    left_array.extend(pivot_array)
    left_array.extend(right_array)
    return left_array

numbers = list(map(int, input().split()))
print(solution(numbers))