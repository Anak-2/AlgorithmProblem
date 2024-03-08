package level2;

import java.util.*;

public class 메뉴_리뉴얼 {

    public static void main(String[] args) {

        System.out.println(Solution.solution(new String[] {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"},
               new int[] {2,3,4}));
    }

    static class Solution {

        static HashMap<String,Integer> map;

        public static ArrayList<String> solution(String[] orders, int[] course) {
            ArrayList<String> answer = new ArrayList<>();

//            모든 만들 수 있는 조합은 정렬되어있어야 하므로, 미리 orders 정렬 (ex, AEDHC -> ACDEH)
            for(int i = 0; i < orders.length; i++){
                char[] charArr = orders[i].toCharArray(); // [A,B,C,F,G]
                Arrays.sort(charArr);
                orders[i] = String.valueOf(charArr);
            }

//            코스의 숫자마다 2번 이상 주문된 음식 조합을 오름차순으로 정렬
            for(int i = 0; i < course.length; i++){
                map = new HashMap<>(); // 각 코스 별 주문 횟수 초기화
                int max = -1; // 주문 횟수 카운트

                for(int j = 0; j < orders.length; j++){
                    StringBuilder sb = new StringBuilder();
                    if(course[i] <= orders[j].length()){
                        combi(orders[j],sb,0,0,course[i]); // 주문으로 만들 수 있는 모든 조합을 course 개수에 따라 만들고 저장
                    }
                }

                for(Map.Entry<String,Integer> entry : map.entrySet()){
                    max = Math.max(max,entry.getValue()); // 가장 주문 많았던 조합의 횟수 저장
                }

                for(Map.Entry<String,Integer> entry : map.entrySet()){
                    if(max >= 2 && entry.getValue() == max) // 최소 2번 이상 주문
                        answer.add(entry.getKey());
                }
            }

            Collections.sort(answer);

            return answer;
        }

        //        각 오더마다 만들 수 있는 모든 경우의 수 조합으로 돌리기
        public static void combi(String str, StringBuilder sb, int idx, int cnt, int n){
            if(cnt == n) { // 코스 개수에 도달하면 반복 종료
                map.put(sb.toString(), map.getOrDefault(sb.toString(),0)+1); // 이미 있는 조합이면 value 값을 1 증가
                return;
            }

            for(int i = idx ; i<str.length();i++){
                sb.append(str.charAt(i));
                combi(str,sb,i+1,cnt+1,n);
                sb.delete(cnt,cnt+1);
            }
        }
    }
}
