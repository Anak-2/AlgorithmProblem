package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 교점에_별_만들기 {

    public static void main(String[] args) {
        String[] solution = Solution.solution(new int[][]{
                {0, 1, -1}, {1, 0, -1}, {1, 0, 1}
        });

        for (String s : solution) {
            System.out.println(s);
        }
    }

    public class Solution {

        public static String[] solution(int[][] line) {
            int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;
            int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
            List<int[]> intersections = new ArrayList<>();

            for (int i = 0; i < line.length; i++) {
                for (int j = i + 1; j < line.length; j++) {
                    int[] intersection = findIntersection(line[i], line[j]);
                    if (intersection != null) {
                        intersections.add(intersection);
                        maxX = Math.max(maxX, intersection[0]);
                        maxY = Math.max(maxY, intersection[1]);
                        minX = Math.min(minX, intersection[0]);
                        minY = Math.min(minY, intersection[1]);
                    }
                }
            }

            char[][] grid = new char[maxY - minY + 1][maxX - minX + 1];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    grid[i][j] = '.';
                }
            }

            for (int[] point : intersections) {
                int x = point[0] - minX;
                int y = maxY - point[1];
                grid[y][x] = '*';
            }

            String[] answer = new String[grid.length];
            for (int i = 0; i < grid.length; i++) {
                answer[i] = new String(grid[i]);
            }

            return answer;
        }

        private static int[] findIntersection(int[] a, int[] b) {
            long A = a[0], B = a[1], E = a[2];
            long C = b[0], D = b[1], F = b[2];

            long denominator = A * D - B * C;
            if (denominator == 0) return null; // 평행하거나 일치하는 경우

            long xNumerator = B * F - E * D;
            long yNumerator = E * C - A * F;

            if (xNumerator % denominator != 0 || yNumerator % denominator != 0) {
                return null; // 정수 교점이 아닌 경우
            }

            int x = (int) (xNumerator / denominator);
            int y = (int) (yNumerator / denominator);

            return new int[]{x, y};
        }
    }

}
