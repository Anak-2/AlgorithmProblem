n = int(input())
star = ["  *  "," * * ","*****"]
n = n//3

def print_star(star):
    l = len(star)
    for i in range(l):
        star.append(star[i] + " " + star[i])
        star[i] = " "*l + star[i] + " "*l
        print("////////")
        for j in star:
            print(j)
        print("////////")
        print()
    return star

cnt = 0
while n > 1:
    n //= 2
    cnt += 1

for i in range(cnt):
    print_star(star)

for j in star:
    print(j)