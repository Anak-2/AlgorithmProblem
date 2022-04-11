N = int(input())
M = int(input())
S = input().rstrip()
count = 0
answer = 0
i = 1
while i < M-1:
    if S[i-1] == 'I' and S[i] == 'O' and S[i+1] == 'I':
        count += 1
        i += 2
        if count == N:
            answer += 1
            count -= 1
        continue
    else:
        count = 0
    i += 1
print(answer)