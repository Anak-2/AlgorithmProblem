package com.example.level2;

import java.util.Arrays;

public class 피로도 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int solution1 = solution.solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}});
        System.out.println(solution1);
    }

    static class Solution {
        static boolean[] visited;
        static int count = 0;

        public int solution(int k, int[][] dungeons) {
            visited = new boolean[dungeons.length];
            dfs(0, k, dungeons);
            return count;
        }

        private void dfs(int depth, int fatigue, int[][] dungeons){
            for(int i = 0; i < dungeons.length; i++) {
                if (visited[i] || dungeons[i][0] > fatigue){
                    continue;
                }
                visited[i] = true;
                dfs(depth+1, fatigue - dungeons[i][1], dungeons);
                visited[i] = false;
            }
            count = Math.max(count, depth);
        }
    }

}