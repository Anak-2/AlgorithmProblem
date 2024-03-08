package ch11;

import java.util.*;

public class 이중우선순위큐 {
    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(Solution.solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"}))
        );
    }
    static class Solution {

        public static int[] solution(String[] operations) {
            int[] answer = new int[2];
            //최소 힙, 최대 힙 따로 만드는게 편함
            Queue<Integer> pq = new PriorityQueue<>();
            Queue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());

            for (String op : operations) {
                StringTokenizer st = new StringTokenizer(op);
                String operation = st.nextToken();
                int value = Integer.parseInt(st.nextToken());

                //빈 큐에서 삭제
                if (pq.isEmpty() && operation.equals("D"))
                    continue;

                //삽입 시 최소 힙, 최대 힙에 value 넣기
                if (operation.equals("I")) {
                    pq.offer(value);
                    maxPq.offer(value);
                    continue;
                }

                // 삭제 시 -1 일 때 최소힙에서 선택
                if(value < 0) {
                    int min = pq.poll();
                    maxPq.remove(min);
                    continue;
                }

                // 삭제 시 1 일 때 최대힙에서 선택
                int max = maxPq.poll();
                pq.remove(max);
            }
            if(!pq.isEmpty()) {
                answer[0] = maxPq.poll();
                answer[1] = pq.poll();
            }
            return answer;
        }
    }
}
