package com.example.algorithm.dp;

public class 정수_삼각형 {

    public static void main(String[] args) {
        System.out.println(Solution.solution(new int[][] {
                {7},
                {3, 8},
                {8, 1, 0},
                {2, 7, 4, 4},
                {4, 5, 2, 6, 5}
        }));
    }
    static class Solution {
        public static int solution(int[][] triangle) {
            int answer = 0;
            int[][] dp = new int[triangle.length][triangle.length];
            dp[0][0] = triangle[0][0];

            for (int i = 1; i < triangle.length; i++) {
                // 해당 열 맨 왼쪽부터 시작 (ex. 7 + 3)
                dp[i][0] = dp[i - 1][0] + triangle[i][0];

                // 지금까지 살펴본 왼쪽 애들을 봤을 때,왼쪽으로 갔을 때 값과, 오른쪽으로 갔을 때 값이 크냐 비교
                for (int j = 1; j <= i; j++) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j];
                }

                // 맨 오른쪽은 위 + 오른쪽
                dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];
            }

            for (int i = 0; i < triangle.length; i++) {
                answer = Math.max(answer, dp[triangle.length - 1][i]);
            }

            return answer;
        }
    }



}
