class ManagePrice:
    def __init__(self, price, myIndex):
        self.price = price
        self.myIndex = myIndex
        self.maintanance = 0

def solution(prices):
    answer = [0 for _ in range(len(prices))]
    not_fallen = []
    for idx, i in enumerate(prices):
        print("{0} 번째".format(idx))
        if idx == 0:
            not_fallen.append(ManagePrice(i, idx))
            continue
        not_fallen_len = len(not_fallen)
        for j in range(not_fallen_len):
            j = not_fallen_len - 1 - j
            not_fallen[j].maintanance += 1
            print("j: {0}".format(j))
            print("not_fallen[j].maintanance: {0}".format(not_fallen[j].maintanance))
            if not_fallen[j].price > i:
                answer[not_fallen[j].myIndex] = not_fallen[j].maintanance
                not_fallen.pop(j)
        not_fallen.append(ManagePrice(i, idx))
    while not_fallen:
        answer[not_fallen[-1].myIndex] = not_fallen[-1].maintanance
        not_fallen.pop()
    return answer

prices = list(map(int, input().split()))
print(solution(prices))