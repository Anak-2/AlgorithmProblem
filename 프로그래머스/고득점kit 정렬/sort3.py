def solution(citations):
    sorted_array = quickSort(citations)
    print(sorted_array)
    for idx, i in enumerate(sorted_array):
        if i <= idx+1:
            answer = i
            break
    return answer

def quickSort(numbers):
    if len(numbers) <= 1:
        return numbers
    pivot = len(numbers)//2
    left_array = []
    right_array = []
    pivot_array = []
    
    for i in range(len(numbers)):
        if numbers[i] > numbers[pivot]:
            left_array.append(numbers[i])
        elif numbers[i] < numbers[pivot]:
            right_array.append(numbers[i])
        else:
            pivot_array.append(numbers[i])
    left_array = quickSort(left_array)
    right_array = quickSort(right_array)
    left_array.extend(pivot_array)
    left_array.extend(right_array)
    return left_array

citations = list(map(int, input().split()))
print(solution(citations))
                 