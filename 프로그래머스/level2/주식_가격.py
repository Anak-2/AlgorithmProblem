def solution(prices):
    answer = [0 for _ in range(len(prices))]
    not_fallen = []
    
    for idx, i in enumerate(prices):
        if idx == 0:
            # [자신의 값, 안 떨어진 기간, 자신의 위치]
            not_fallen.append([i, 0, idx])
            continue
        not_fallen_len = len(not_fallen)
        for j in range(not_fallen_len):
            j = not_fallen_len - 1 - j
            not_fallen[j][1] += 1
            # 현재 살펴보고 있는 값보다 큰 값이 리스트에 있다면 꺼내기
            if not_fallen[j][0] > i:
                answer[not_fallen[j][2]] = not_fallen[j][1]
                not_fallen.pop(j)
        not_fallen.append([i, 0, idx])
    while not_fallen:
        answer[not_fallen[-1][2]] = not_fallen[-1][1]
        not_fallen.pop()
    return answer
