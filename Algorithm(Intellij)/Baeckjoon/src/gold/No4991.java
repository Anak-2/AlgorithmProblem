package gold;

import java.util.*;
import java.io.*;

public class No4991 {
    static class Point { // 위치 정보 클래스
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

//    정답
    private static int minMove;
//    각 먼지까지 거리
    private static int[][] distance;
//    로봇 청소기, 먼지 위치
    private static Point[] list;
    private static int[] dr = new int[]{-1,1,0,0};
    private static int[] dc = new int[]{0,0,-1,1};
//    map 정보
    private static char[][] map;
//    전체 크기
    private static int W;
    private static int H;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());

            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            minMove = Integer.MAX_VALUE/2;

            if (W == 0 && H == 0)
                break; // 종료

            map = new char[H][W];
            list = new Point[11]; // 먼지의 갯수 최대 10개. +1인 로봇청소기
            int dust_cnt = 1;
            for (int i = 0; i < H; i++) {
                char[] input = br.readLine().toCharArray();
                for (int j = 0; j < W; j++) {
                    map[i][j] = input[j];
                    if (input[j] == 'o') { // 0번은 무조건 로봇청소기
                        list[0] = new Point(i, j);
                    } else if (input[j] == '*') { // 그 뒤는 먼지
                        list[dust_cnt++] = new Point(i, j);
                    }
                }
            } // input end
            dust_cnt--;
            distance = new int[dust_cnt+1][dust_cnt+1];
            process(map, dust_cnt);
            System.out.println(minMove);
        } // while end
    }

    public static void process(char[][] map, int dust_cnt){
        for(int i = 0; i < dust_cnt; i++){
            for(int j = i+1; j < dust_cnt+1; j++){
//                i부터 j (j부터 i)까지 가는 최소거리 갱신
                int dist = bfs(list[i], list[j]);
//                i부터 j까지 갈 수 없으면 -1
                if(dist == -1){
                    minMove = -1;
                    return;
                }
                distance[i][j] = dist;
                distance[j][i] = dist;
            }
        }

//        로봇 청소기에서 어떤 순서로 더러운 곳 방문하면 최소 거리인지
//        distance 배열과 DFS로 경우의 수 살펴보기
        boolean[] dfsVisited = new boolean[dust_cnt]; // dfs 돌 때 방문표시 할 배열
        int distSum = 0; // dfs 돌면서 방문한 거리 누적할 변수
//        로봇 청소기 부터 시작은 고정
        for(int i = 0; i < dust_cnt; i++){
//            prev변수는 이전 방문한 로봇 청소기 또는 먼지가 어딘지 알려줌
            dfs(dfsVisited, distSum, 0);
            distSum = 0;
        }
    }

//    start부터 end까지 가는 최소거리 구해서 distance 배열 갱신
    public static int bfs(Point start, Point end){
        ArrayList<Point> stack = new ArrayList<>();
        stack.add(start);
        int[][] visited = new int[H][W];
        for(int[] i : visited){
            Arrays.fill(i,-1);
        }
        visited[start.r][start.c] = 0;
        while(!stack.isEmpty()){
            Point cur = stack.remove(0);
            for(int i = 0; i < 4; i++){
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if(isAvailable(nr, nc, visited)){
                    if(map[nr][nc] != 'x'){
                        visited[nr][nc] = visited[cur.r][cur.c] + 1;
                        if(nr == end.r && nc == end.c){
                            return visited[nr][nc];
                        }
                        stack.add(new Point(nr, nc));
                    }
                }
            }
        }
        return -1;
    }

    public static boolean isAvailable(int r, int c, int[][] visited){
        return 0 <= r && r < H && 0 <= c && c < W && visited[r][c] == -1;
    }

    public static void dfs(boolean[] dfsVisited, int distSum, int prev){
        boolean isLast = true;
        for(int i = 0; i < dfsVisited.length; i++){
            if(!dfsVisited[i]) {
                isLast = false;
                dfsVisited[i] = true;
                distSum += distance[prev][i+1];
                dfs(dfsVisited, distSum, i+1);
                distSum -= distance[prev][i+1];
                dfsVisited[i] = false;
            }
        }
        // 전부 방문했다면 최소 거리 갱신
        if(isLast) minMove = Math.min(minMove, distSum);
    }
}

