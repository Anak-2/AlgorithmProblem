package com.example.ch13;

import java.util.*;

public class 주차_요금_계산 {

    public static void main(String[] args) {
        int[] result = Solution.solution(
                new int[] {1, 461, 1, 10},
                new String[] {
                        "00:00 1234 IN"
                }
        );

        for(int i : result){
            System.out.println(i);
        }
    }

    class Solution {
        //기본 시간, 기본 요금, 단위 시간, 단위 요금
        static int[] fees;
        // 주차해있는 차 (차량 번호, 주차 시각)
        static Map<String, Integer> parkCars = new HashMap();
        // 차 정보 (차량 번호, 누적 시간)
        static Map<String, Integer> carInfo = new HashMap<>();
        public static int[] solution(int[] fee, String[] records) {
            fees = fee;

            for(String record : records){
                // 정보 분리 (시간, 차량 번호, 입차 여부)
                String[] recordInfo = record.split(" ");
                if(recordInfo[2].equals("IN")){
                    parkCars.put(recordInfo[1], convertToMinute(recordInfo[0]));
                    carInfo.putIfAbsent(recordInfo[1], 0);
                }
                if(recordInfo[2].equals("OUT")){
                    // 차 정보 찾아서 누적 시간 더해주기
                    int parkTime = parkCars.remove(recordInfo[1]);
                    int outTime = convertToMinute(recordInfo[0]);
                    carInfo.put(recordInfo[1], carInfo.get(recordInfo[1]) + (outTime - parkTime));
                }
            }

            // 아직 안 나간 차들 계산
            for(Map.Entry<String, Integer> parkCar : parkCars.entrySet()){
                // 차 정보 찾아서 누적 시간 더해주기
                int parkTime = parkCar.getValue();
                int outTime = convertToMinute("23:59");
                carInfo.put(parkCar.getKey(), carInfo.get(parkCar.getKey()) + (outTime - parkTime));
            }

            // 최종 요금들 (차량 번호, 최종 요금) (트리맵은 key가 작은 순으로 정렬)
            Map<String, Integer> result = new TreeMap<>();

            for(Map.Entry<String, Integer> carInfo : carInfo.entrySet()){
                result.put(carInfo.getKey(), calCost(carInfo.getValue()));
            }

            int[] answer = new int[result.size()];
            int idx = 0;
            for (Map.Entry<String, Integer> entry : result.entrySet()) {
                answer[idx] = entry.getValue();
                idx++;
            }

            return answer;
        }

        public static int convertToMinute(String strTime){
            int time = 0;
            String[] splitTime = strTime.split(":");
            return Integer.parseInt(splitTime[0])*60 + Integer.parseInt(splitTime[1]);
        }

        public static int calCost(int totalTime){
            int overTime = totalTime - fees[0];

            if(overTime <= 0) return fees[1];

            return (int) Math.ceil(overTime/(double)fees[2]) * fees[3] + fees[1];
        }

    }
}
