package gold;

import java.util.*;
import java.io.*;


public class No1987 {
    static int R;
    static int C;
    static char[][] map;
    static boolean[][] visited;
    static int[] dr = new int[]{-1, 1, 0, 0};
    static int[] dc = new int[]{0, 0, -1, 1};
    static int ans = 1;
    //        지금까지 지나온 알파벳 저장
    static HashSet<Character> set = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
//        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }


        set.add(map[0][0]);
        dfs(0, 0);
        System.out.println(ans);
    }

    private static void dfs(int r, int c) {
        ans = Math.max(ans, set.size());
        for (int i = 0; i < 4; i++) {
            int nextR = r + dr[i];
            int nextC = c + dc[i];
            if (isAvailable(nextR, nextC)) {
                if (!set.contains(map[nextR][nextC])) {
                    set.add(map[nextR][nextC]);
                    dfs(nextR, nextC);
                    set.remove(map[nextR][nextC]);
                }
            }
        }
    }

    private static boolean isAvailable(int r, int c) {
        if (r < 0 || r >= R || c < 0 || c >= C) {
            return false;
        } else return true;
    }

    private static class Coord {
        int r;
        int c;

        public Coord(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
