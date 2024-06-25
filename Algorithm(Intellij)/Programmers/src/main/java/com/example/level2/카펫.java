package com.example.level2;

import java.util.Arrays;

public class 카펫 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(Solution.solution(24, 24)));
    }

    static class Solution {

        public static int[] solution(int brown, int yellow) {
            int[] answer = new int[2];
            int sum = brown + yellow;

            for (int i = 3; i < sum; i++) { // 가로, 세로 모두 3 이상
                int j = sum / i;

                if (sum % i == 0 && j >= 3) { // i * j == sum 이면서 변이 3 이상일 때
                    int col = Math.max(i, j);
                    int row = Math.min(i, j);
                    int center = (col - 2) * (row - 2);

                    if (center == yellow) {
                        answer[0] = col;
                        answer[1] = row;
                        return answer;
                    }
                }
            }
            return answer;
        }
    }
}
