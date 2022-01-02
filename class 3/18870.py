n = int(input())
arr = list(map(int, input().split()))
#정렬 + set으로 중복 제거
arr2 = sorted(list(set(arr)))
#각 숫자마다 순서 기입
dict = {arr2[i] : i for i in range(len(arr2))}
for i in arr:
    print(dict[i], end=' ')