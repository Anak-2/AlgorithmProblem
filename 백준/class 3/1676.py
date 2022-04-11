result = 1
cnt = 0
def factorial(n):
    global result
    if n > 1:
        result = result*n
        factorial(n-1)
def count_zero(r):
    global cnt
    while(r%10 == 0):
        cnt += 1
        r = r//10

number = int(input())
factorial(number)
count_zero(result)
print(cnt)
