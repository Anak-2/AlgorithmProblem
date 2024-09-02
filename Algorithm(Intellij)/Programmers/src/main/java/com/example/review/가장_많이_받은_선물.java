package com.example.review;

import java.util.HashMap;
import java.util.Map;

public class 가장_많이_받은_선물 {

    public static void main(String[] args) {
        Solution s = new Solution();
        int answer = s.solution(new String[]{"muzi", "ryan", "frodo", "neo"},
                new String[]{"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"});
        System.out.println(answer);
    }

    static class Solution {

        public int solution(String[] friends, String[] gifts) {
            Map<String, Integer> friendMap = new HashMap<>();
            int index = 0;
            for(String f : friends){
                friendMap.put(f, index);
                index++;
            }
            int friendSize = friends.length;
            // 주고 받은 기록
            int[][] giftRecord = new int[friendSize][friendSize];
            // 선물 지수
            int[] giftPriority = new int[friendSize];
            for(String g : gifts){
                String[] gSplit = g.split(" ");
                String from = gSplit[0];
                String to = gSplit[1];

                int give = friendMap.get(from);
                int receive = friendMap.get(to);
                giftRecord[give][receive]++;
                giftPriority[give]++;
                giftPriority[receive]--;
            }

            int[] whoGetMany = new int[friendSize];
            // 주고 받은 기록 확인
            for(int i = 0; i < friendSize; i++){
                for(int j = i + 1; j < friendSize; j++){
                    // 주고 받은게 같거나 없으면 선물 지수
                    if(giftRecord[i][j] == giftRecord[j][i]){
                        if(giftPriority[i] != giftPriority[j]){
                            whoGetMany[giftPriority[i] > giftPriority[j] ? i : j]++;
                        }
                    }else {
                        whoGetMany[giftRecord[i][j] > giftRecord[j][i] ? i : j]++;
                    }
                }
            }

            int max = 0;
            for(int w : whoGetMany){
                max = Math.max(w, max);
            }

            return max;
        }
    }
}
