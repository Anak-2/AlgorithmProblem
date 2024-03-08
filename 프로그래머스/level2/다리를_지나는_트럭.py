def solution(bridge_length, weight, truck_weights):
 #     bridge = [무게,elapsed time]
    bridge = []
    bridge.append([truck_weights.pop(0),1])
    bridge_sum = bridge[0][0] # 다리 총 무게
    answer = 1
    
    while truck_weights:
        answer += 1
        # 트럭 하나 더 올라갈 수 있고, 트럭 무게 버틸 수 있을 때 
        if len(bridge) + 1 <= bridge_length and bridge_sum + truck_weights[0] <= weight:
            # print("1 more truck")
            start_truck = truck_weights.pop(0)
            bridge.append([start_truck,0])
            bridge_sum += start_truck
        # 다리 위에 있는 트럭들 한 칸씩 이동
        for i in range(len(bridge)):
            bridge[i][1] += 1
        # 맨 앞에 있는 트럭이 다리를 지나면, 다리 총 무게에서 빼고 다리에서 뺴기
        if bridge[0][1] == bridge_length:
                    bridge_sum -= bridge[0][0]
                    bridge.pop(0)
    
    # 마지막 트럭은 올라가자 마자 끝나므로 다리 총 길이만큼 더함
    answer += bridge_length
    return answer