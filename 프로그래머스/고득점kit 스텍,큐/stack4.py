import sys

input = sys.stdin.readline

bridge_length = int(input())
weight = int(input())
truck_weights = list(map(int, input().split()))

def solution(bridge_length, weight, truck_weights):
    #     bridge = [weight,elapsed time]
    bridge = []
    bridge.append([truck_weights.pop(0),1])
    bridge_sum = bridge[0][0]
    answer = 1

    while truck_weights:
        answer += 1
        if len(bridge) + 1 <= bridge_length and bridge_sum + truck_weights[0] <= weight:
            # print("1 more truck")
            start_truck = truck_weights.pop(0)
            bridge.append([start_truck,0])
            bridge_sum += start_truck
        for i in range(len(bridge)):
            # print("bridge[i][1]: {0}".format(bridge[i][1]))
            bridge[i][1] += 1
        # print("answer: {0}".format(answer))
        # print("bridge: {0}".format(bridge))
        # print("bridge sum: {0}".format(bridge_sum))
        if bridge[0][1] == bridge_length:
                    bridge_sum -= bridge[0][0]
                    bridge.pop(0)
    
    # finish last truck
    answer += bridge_length
    return answer

print(solution(bridge_length, weight, truck_weights))