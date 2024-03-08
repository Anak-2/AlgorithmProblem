package level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class 순위_검색 {

    public static void main(String[] args) {
        int[] answer = Solution.solution(new String[]{"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"},
                new String[]{"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"});

        for (int i : answer) {
            System.out.print(i + " ");
        }
    }

    static class Solution {
        static HashMap<String, List<Integer>> map = new HashMap<String, List<Integer>>(); // 모든 경우의 수 + 점수 저장

        public static int[] solution(String[] info, String[] query) {
            int[] answer = new int[query.length];

            for (int i = 0; i < info.length; i++) {
                String[] p = info[i].split(" "); // [java, backend, junior, pizza, 150]
                combi(p, "", 0); // "----150" ~ "javabackendjuniorpizza150"
            }

            for (String key : map.keySet()) {
                Collections.sort(map.get(key)); // 이분 탐색을 위해 점수 순 정렬
            }

            for (int i = 0; i < query.length; i++) {
                query[i] = query[i].replaceAll(" and ", ""); // ["javabackendjuniorpizza 100"]
                String[] q = query[i].split(" "); // ["javabackendjuniorpizza", "100"]
                answer[i] = map.containsKey(q[0]) ? binarySearch(q[0], Integer.parseInt(q[1])) : 0;
            }

            return answer;
        }

        public static void combi(String[] p, String str, int cnt) {
            if (cnt == 4) { // 점수일 경우
                if (!map.containsKey(str)) {
                    List<Integer> list = new ArrayList<>();
                    map.put(str, list);
                }
                map.get(str).add(Integer.parseInt(p[4]));
                return;
            }
            combi(p, str + "-", cnt + 1); // 아무거나 가능한 경우
            combi(p, str + p[cnt], cnt + 1); // 특정 조건
        }

        public static int binarySearch(String key, int score) {
            List<Integer> list = map.get(key);
            int start = 0, end = list.size() - 1;

            while (start <= end) {
                int mid = (start + end) / 2;
                if (list.get(mid) < score)
                    start = mid + 1;
                else
                    end = mid - 1;
            }

            // key에 해당하는 점수의 총 개수 - 점수보다 크거나 같은 처음 index
            return list.size() - start;
        }
    }
}
