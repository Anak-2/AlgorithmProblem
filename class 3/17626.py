import sys
input = sys.stdin.readline
n = int(input())
cnt = 4
end = 0
done3 = 0
done4 = 0
temp = int(n**(1/2))
#stack = []
while temp > 0:
    tcnt = 1
    ntemp = n - temp**2
    #처음부터 ntemp^2이면 종료
    if ntemp == 0:
        #stack.append(temp)
        cnt = 1
        break
    #2개의 숫자의 제곱으로 표현 가능하면 종료
    #왜냐하면 처음부터 ntemp^2이 아닌 이상 최소 2개이기 때문
    if end == 1:
        break
    temp2 = int(ntemp**(1/2))
    #하위 숫자의 제곱들은 상위 숫자보다 크지 않아야한다 (temp랑 temp2 역전되면 쓸데없이 중복되는 경우 생김)
    while temp2 > 0 and temp >= temp2:
        tcnt += 1
        ntemp2 = ntemp - temp2**2
        if ntemp2 == 0:
            #stack.append([temp,temp2])
            cnt = 2
            end = 1
            break
        temp3 = int(ntemp2**(1/2))
        #숫자 3개 조합을 찾았으면 다른 temp, temp2가 들어오더라도 계산x
        while temp3 > 0 and temp2 >= temp3 and not done3:
            tcnt += 1
            ntemp3 = ntemp2 - temp3**2
            if ntemp3 == 0:
                if cnt > 3:
                    #stack.append([temp,temp2,temp3])
                    cnt = 3
                    done3 = 1
            temp4 = int(ntemp3**(1/2))
            #temp4의 경우 1번만 찾으면 이후 반복x (temp3와 마찬가지)
            if temp4 > 0 and not done4:
                false3 = 0
                tcnt += 1
                ntemp4 = ntemp3 - temp4**2
                if ntemp4 != 0:
                    temp3 -= 1
                else:
                    if cnt > 4:
                        #stack.append([temp,temp2,temp3,temp4])
                        cnt = 4
                        done4 = 1
            temp3 -= 1
        temp2 -= 1
    temp -= 1
            
                
#print(stack.pop())
print(cnt)