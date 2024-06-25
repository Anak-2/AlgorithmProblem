package com.example.algorithm.dp;

public class 등굣길 {

    public static void main(String[] args) {

    }
    static class Solution {
        public static int solution(int m, int n, int[][] puddles) {
            int[][] board = new int[n + 1][m + 1];

            // 웅덩이 표시
            for (int[] puddle : puddles) {
                board[puddle[1]][puddle[0]] = -1;
            }

            // 집은 1,1 시작 -> 방문 표시
            board[1][1] = 1;

            for(int i = 1; i < n + 1; i++) {
                for(int j = 1; j < m + 1; j++) {
                    // 웅덩이 패스
                    if(board[i][j] == -1) {
                        continue;
                    }
                    // 왼쪽 경우의 수 더함
                    if(board[i - 1][j] > 0) {
                        board[i][j] += board[i - 1][j] % 1000000007;
                    }
                    // 위쪽 경우의 수 더함
                    if(board[i][j - 1] > 0) {
                        board[i][j] += board[i][j - 1] % 1000000007;
                    }
                }
            }

            // 최종 등굣길 반환
            return board[n][m] % 1000000007;
        }
    }
}
