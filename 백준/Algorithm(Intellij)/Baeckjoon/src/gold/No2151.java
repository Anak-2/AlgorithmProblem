package gold;

import java.util.*;
import java.io.*;


public class No2151 {

    static class Coord implements Comparator<Coord>{
        int r;
        int c;
        //        진행 방향, 상,하,좌,우 -> 0,1,2,3
    //      dir = {'u','d','l','r'};
        int dir;
//        거울 개수
        int mirror;
        
        private Coord(){}
        private Coord(int r, int c, int dir, int mirror){
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.mirror = mirror;
        }


        @Override
        public int compare(Coord o1, Coord o2) {
            return o1.mirror - o2.mirror;
        }
    }

    static int N;
    static char[][] map;
    static Coord start;
    static int endR;
    static int endC;
    static int[] dr = new int[]{-1,1,0,0};
    static int[] dc = new int[]{0,0,-1,1};
    static boolean[][] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new char[N][N];
        visited = new boolean[N][N];
//        다음 살펴 볼 좌표 정보를 저장할 priority queue
        PriorityQueue<Coord> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++){
            map[i] = br.readLine().toCharArray();
            for(int j = 0; j < N; j++){
                if(map[i][j] == '#'){
                    if(start == null){
                        for(int k = 0; k < 4; k++){
                            int nextR = i+dr[k];
                            int nextC = j+dc[k];
                            if(isAvailable(nextR, nextC)){
                                pq.add(new Coord(nextR, nextC, k, 0));
                            }
                        }
                    }else{
                        endR = i;
                        endC = j;
                    }
                }
            }
        }
    }
    
    private static int bfs(Coord start, PriorityQueue<Coord> pq){
        int ans = 0;
        while(!pq.isEmpty()){
            Coord cur = pq.poll();
            if(cur.r == endR && cur.c == endC){
                return ans;
            }
            visited[cur.r][cur.c] = true;
            for(int i = 0; i < 4; i++){
                int nextR = cur.r+dr[i];
                int nextC = cur.c+dc[i];
                if(isAvailable(nextR, nextC)){
//                    if(map[next])
                }
            }
        }
        return -1;
    }

    private static boolean isAvailable(int r, int c){
        if(r < 0 || r >= N || c < 0 || c >= N || visited[r][c] || map[r][c] == '*'){
            return false;
        }
        return true;
    }
}
