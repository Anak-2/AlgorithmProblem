package ch13;

import java.util.*;

public class 신고_결과_받기 {

    public static void main(String[] args) {
        String[] id_list = {
                "con", "ryan"
        };
        String[] report = {
                "ryan con", "ryan con", "ryan con", "ryan con"
        };
        int[] result = Solution.solution(id_list, report,3);
        for(int i : result){
            System.out.print(i+" ");
        }
    }

    static class Solution {

        static Map<String, Set<String>> reportResult = new HashMap<>();
        static Map<String, Integer> banResult = new HashMap<>();

        public static int[] solution(String[] id_list, String[] report, int k) {

            int[] answer = new int[id_list.length];

            for(String id : id_list){
                reportResult.put(id, new HashSet<>());
            }

            for(String eachReport : report){
                String[] str = eachReport.split(" ");
                reportUser(str[0], str[1]);
            }

            for(Map.Entry<String, Set<String>> entry : reportResult.entrySet()){
                if(entry.getValue().size() >= k){
                    for(String reporter : entry.getValue()){
                        banResult.put(reporter, banResult.getOrDefault(reporter, 0)+1);
                    }
                }
            }

            for(int i = 0; i < id_list.length; i++){
                answer[i] = banResult.getOrDefault(id_list[i],0);
            }

            return answer;
        }

        // 신고받은 사람에게 신고한 사람들 저장
        public static void reportUser(String reporter, String reportedUser){
            reportResult.get(reportedUser).add(reporter);
        }
    }
}
