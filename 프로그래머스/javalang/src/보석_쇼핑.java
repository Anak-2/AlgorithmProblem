import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class 보석_쇼핑 {
    public static void main(String[] args) {

    }
    class Solution {
        // 문제 아이디어: 보석을 해쉬에 넣어서 해쉬 크기로 측정
        // 놓친 아이디어: 효율성을 위해, 시작 지점 보석과 현재 살펴보는 보석의 종류가 겹치면, 한 칸 옆으로 옮기기
        public static int[] solution(String[] gems) {
            int kind = new HashSet<>(Arrays.asList(gems)).size();

            int[] answer = new int[2];
            int length = Integer.MAX_VALUE, start = 0;

            // 보석 이름, 보석 개수
            Map<String, Integer> map = new HashMap<>();

            for (int end = 0; end < gems.length; end++) {
                // 보석 종류 안 겹치면 추가
                map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);

                // 현재 살펴보고 있는 보석이 시작 보석과 종류가 겹친다면, 시작 지점을 한 칸 오른쪽으로 이동
                while (map.get(gems[start]) > 1) {
                    map.put(gems[start], map.get(gems[start]) - 1);
                    start++;
                }

                // 모든 종류의 보석을 가졌고, 이전 길이보다 짧다면 갱신
                if (map.size() == kind && length > (end - start)) {
                    length = end - start;
                    answer[0] = start + 1;
                    answer[1] = end + 1;
                }
            }

            return answer;
        }
    }
}
