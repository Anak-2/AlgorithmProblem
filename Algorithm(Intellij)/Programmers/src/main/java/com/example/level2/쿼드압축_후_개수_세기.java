package com.example.level2;


import java.util.Arrays;

public class 쿼드압축_후_개수_세기 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(Solution.solution(new int[][]{{1, 1, 1, 1, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 1, 1, 1, 1}, {0, 1, 0, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 1, 0, 0, 1}, {0, 0, 0, 0, 1, 1, 1, 1}})));
    }

    static class Solution {

        static int[][] baseArr;
        static int[] answer = new int[2]; // answer [ 0의 개수, 1의 개수 ]

        public static int[] solution(int[][] arr) {
            baseArr = arr;
            quadPress(0, 0, arr[0].length);
            return answer;

            // 재귀 문제

            // 종료 조건 설정 (변의 길이가 1이 되거나, 자신의 구역이 0 또는 1로 모두 차면 재귀 그만)

            // 점화식 (줄어드는 상태) -> 현재 변의 길이를 반띵해서 x,y 좌표 4개 만들어서 다시 재귀
        }

        // r, c, 변의 길이
        public static void quadPress(int r, int c, int length) {
            if (length == 1) {
                answer[baseArr[r][c]]++;
                return;
            }
            int checkArrResult = checkArr(r, c, length);
            if (checkArrResult != -1) {
                answer[checkArrResult]++;
                return;
            }

            quadPress(r, c, length / 2);
            quadPress(r + length / 2, c, length / 2);
            quadPress(r, c + length / 2, length / 2);
            quadPress(r + length / 2, c + length / 2, length / 2);
        }

        // 모두 같으면 0 또는 1 리턴, 아니면 -1 리턴
        public static int checkArr(int r, int c, int length) {

            int baseInt = baseArr[r][c];

            for (int i = r; i < r + length; i++) {
                for (int j = c; j < c + length; j++) {
                    if (baseArr[i][j] != baseInt) {
                        return -1;
                    }
                }
            }

            return baseInt;
        }

    }
}
