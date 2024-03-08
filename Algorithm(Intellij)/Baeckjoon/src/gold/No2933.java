package gold;

import java.sql.Array;
import java.util.*;
import java.io.*;

public class No2933 {
    static char[][] map;
    static boolean[][] visited;
    static int R;
    static int C;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static ArrayList<int[]> airCluster;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];
        int[][] cluster = new int[R][C];

//        map 초기화
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
//        왼쪽에서 발사는 0, 오른쪽에서 발사는 1
        int direction = 0;
//        총알 발사
        for (int i = 0; i < N; i++) {
            int fire = Integer.parseInt(st.nextToken());
            if (direction % 2 == 0) {
                for (int j = 0; j < C; j++) {
                    if (map[R - fire][j] == 'x') {
                        map[R - fire][j] = '.';
                        break;
                    }
                }
            } else {
                for (int j = C - 1; j >= 0; j--) {
                    if (map[R - fire][j] == 'x') {
                        map[R - fire][j] = '.';
                        break;
                    }
                }
            }
//        바닥과 닿아있는 미네랄은 1, 공중에 떠있는 미네랄은 2로 표시
            cluster = clustering();
//            cluster 출력
//            for (int a = 0; a < R; a++) {
//                for (int b = 0; b < C; b++) {
//                    System.out.print(cluster[a][b]);
//                }
//                System.out.println();
//            }
//        바닥이나 바닥과 닿아있는 미네랄과 닿을 때까지 row 이동
            if (!airCluster.isEmpty()) {
                moveCluster(cluster);
            }
            direction++;
        }

//        map 출력
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    private static int[][] clustering() {
        int[][] cluster = new int[R][C];
        visited = new boolean[R][C];
        airCluster = new ArrayList<>();
//        바닥과 이어진 크리스탈 clustering
        for (int j = 0; j < C; j++) {
            if (!visited[R - 1][j]) {
                visited[R - 1][j] = true;
                if (map[R - 1][j] == 'x') {
                    cluster[R - 1][j] = 1;
//                바닥과 이어진 크리스탈에서 BFS로 이어진 크리스탈 표시
                    bfs(cluster, R-1, j, 1);
                }
            }
        }
//        바닥과 이어지지 않은 크리스탈 clustering
        for (int i = 0; i < R - 1; i++) {
            for (int j = 0; j < C; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    if (map[i][j] == 'x') {
                        cluster[i][j] = 2;
                        bfs(cluster, i, j, 2);
                        return cluster;
                    }
                }
//                바닥과 이어지지 않은 클러스터는 하나 뿐이니 하나라도 발견하면 끝
            }
        }
        return cluster;
    }

    //    cluster 시작점(sr,sc)에서 bfs로 이어진 부분을 num으로 채우기
    private static void bfs(int[][] cluster, int s, int r, int num) {
        List<int[]> stack = new ArrayList<>();
//        공중에 뜬 클러스터라면 위치를 arrayList에 저장
        stack.add(new int[]{s, r});
//                바닥과 이어진 크리스탈에서 BFS로 이어진 크리스탈 표시
        while (!stack.isEmpty()) {
            int[] cur = stack.remove(0);
            if (num == 2) {
                airCluster.add(new int[]{cur[0], cur[1]});
            }
            for (int k = 0; k < 4; k++) {
                int nr = cur[0] + dr[k];
                int nc = cur[1] + dc[k];
                if (nr >= 0 && nc >= 0 && nr < R && nc < C && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    if (map[nr][nc] == 'x') {
                        stack.add(new int[]{nr, nc});
                        cluster[nr][nc] = num;
                    }
                }
            }
        }
    }

    //    공중에 떠있는 클러스터, 바닥 or 바닥과 이어진 미네랄과 닿을 때까지 이동
    private static void moveCluster(int[][] cluster) {
        int move = 1;
        outerLoop:
        while (true) {
            for (int[] mineral : airCluster) {
                if (mineral[0] + move == R - 1 || cluster[mineral[0] + move + 1][mineral[1]] == 1) {
//                    System.out.println("move "+move);
                    break outerLoop;
                }
            }
            move++;
        }
        for (int[] mineral : airCluster) {
            map[mineral[0]][mineral[1]] = '.';
        }
        for (int[] mineral : airCluster) {
            map[mineral[0] + move][mineral[1]] = 'x';
        }
    }

}

