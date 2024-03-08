package level1;

import java.util.*;

public class 완주하지_못한_선수 {
    public static void main(String[] args) {
        System.out.println(Solution.solution(new String[]{"leo", "kiki", "eden"},
                new String[]{"eden", "kiki"}));
    }
    static class Solution {
        public static String solution(String[] participant, String[] completion) {
            String answer = "";
            HashMap<String, Integer> map = new HashMap<>();
            for (String player : participant)
                map.put(player, map.getOrDefault(player, 0) + 1);
            for (String player : completion)
                map.put(player, map.get(player) - 1);

            Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator();

            while(iter.hasNext()){
                Map.Entry<String, Integer> entry = iter.next();
                if (entry.getValue() != 0){
                    answer = entry.getKey();
                    break;
                }
            }
            return answer;
        }
    }
}
