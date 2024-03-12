package ch12;

import java.util.Arrays;

public class 단속카메라 {

    public static void main(String[] args) {
        System.out.println(Solution.solution(
                new int[][]{{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}}
        ));
    }

    static class Solution {
        public static int solution(int[][] routes) {
            int answer = 0;

            Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);
            int length = routes.length;
            boolean[] visited = new boolean[length];

            for (int i = 0; i < length; i++) {
                if (visited[i]) continue;
                visited[i] = true;
                for (int j = i; j < length - 1; j++) {
                    if (checkIntersection(routes[i], routes[j+1])) {
                        visited[j + 1] = true;
                    }
                }
                answer++;
            }

            return answer;
        }

        static boolean checkIntersection(int[] range1, int[] range2) {
            return (
                    range1[1] >= range2[0]);
        }
    }
}
