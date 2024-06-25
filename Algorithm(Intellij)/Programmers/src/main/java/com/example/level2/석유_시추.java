package com.example.level2;

import java.util.*;

public class 석유_시추 {
    static class Solution {

        static int n, m;
        static int[] oil;

        public int solution(int[][] land) {
            n = land.length;
            m = land[0].length;

            oil = new int[m];
            boolean[][] visited = new boolean[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (land[i][j] == 1 && !visited[i][j]) {
                        bfs(land, i, j, visited);
                    }
                }
            }

            return Arrays.stream(oil).max().getAsInt();
        }

        public void bfs(int[][] land, int i, int j, boolean[][] visited) {
            int[] dx = new int[]{0, 0, -1, 1};
            int[] dy = new int[]{-1, 1, 0, 0};

            visited[i][j] = true;

            List<int[]> q = new ArrayList<>();
            Set<Integer> columns = new HashSet<>();

            int count = 1;

            q.add(new int[]{i, j});

            while (!q.isEmpty()) {
                int[] cur = q.remove(q.size() - 1);
                columns.add(cur[1]);

                for (int k = 0; k < 4; k++) {
                    int nx = cur[0] + dx[k];
                    int ny = cur[1] + dy[k];

                    if (check(nx, ny) && land[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        count++;
                        q.add(new int[]{nx, ny});
                    }
                }
            }

            for (int index : columns) {
                oil[index] += count;
            }
        }

        public boolean check(int i, int j) {
            return i >= 0 && i < n && j >= 0 && j < m;
        }
    }
}

