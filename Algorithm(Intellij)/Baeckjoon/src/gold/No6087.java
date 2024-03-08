package gold;

import java.util.*;
import java.io.*;

//레이저 통신
public class No6087 {
    static int R;
    static int C;
    static int[][] map;
    static int[][] cLoc = new int[2][2];
    static int[] dr = new int[]{-1,1,0,0};
    static int[] dc = new int[]{0,0,-1,1};

//    반례를 위해 visitedRow, Col 추가
//    4 6
//    C...
//    ....
//    **.*
//    ....
//    ...C
//    ans: 2

//    만약 visited가 없이 방문한 곳의 크기만으로 stack에 추가하도록 알고리즘을 설계했다면
//    3행 **.* 위에 2행 3열 ....에서 길을 통과할 때 방문한 곳의 크기가 1이지만 열 이동 중인지, 행 이동 중인지에 따라
//    답이 2,3 으로 달라지는데 2행 3열에서 이미 열 이동중인 애가 1로 방문했으면 행 이동중인 1이 걸러지므로 답이 3이 나옴
    static boolean[][] visitedRow;
    static boolean[][] visitedCol;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        visitedRow = new boolean[R][C];
        visitedCol = new boolean[R][C];
        int idx = 0;
        for(int i = 0; i < R; i++){
            char[] charArray = br.readLine().toCharArray();
            for(int j = 0; j < C; j++){
                if(charArray[j] == '.'){
                    map[i][j] = Integer.MAX_VALUE/2;
                }else if(charArray[j] == '*'){
                    map[i][j] = -1;
                }else{
                    map[i][j] = Integer.MAX_VALUE/2;
                    cLoc[idx][0] = i;
                    cLoc[idx++][1] = j;
                }
            }
        }
        bfs(new int[]{cLoc[0][0], cLoc[0][1]}, new int[]{cLoc[1][0], cLoc[1][1]});
//        System.out.println("bfs 끝");
        System.out.println(map[cLoc[1][0]][cLoc[1][1]]);
    }

    static class Razer{
        int item;
        int r;
        int c;
//        행 이동인지 체크
        boolean changeR;

        Razer(int r, int c, int item, boolean changeR){
            this.r = r;
            this.c = c;
            this.item = item;
            this.changeR = changeR;
        }

        @Override
        public String toString() {
            return "Razer{" +
                    "item=" + item +
                    ", r=" + r +
                    ", c=" + c +
                    ", changeR=" + changeR +
                    '}';
        }
    }

    public static void bfs(int[] start, int[] end){
        PriorityQueue<Razer> stack = new PriorityQueue<>(new Comparator<Razer>() {
            @Override
            public int compare(Razer o1, Razer o2) {
                return o1.item - o2.item;
            }
        });
        Razer razer;
        for(int i = 0; i < 4; i++){
            int nr = start[0] + dr[i];
            int nc = start[1] + dc[i];
            if(isAvailable(nr, nc)){
                if(i < 2){
                    razer = new Razer(nr, nc, 0, true);
                    stack.add(razer);
                }else{
                    razer = new Razer(nr, nc, 0, false);
                    stack.add(razer);
                }
            }
        }
        while(!stack.isEmpty()){
            Razer curRazer = stack.poll();
//            System.out.println(curRazer);
            if(map[curRazer.r][curRazer.c] > curRazer.item){
                map[curRazer.r][curRazer.c] = curRazer.item;
            }
            if(curRazer.changeR){
                visitedRow[curRazer.r][curRazer.c] = true;
            }else{
                visitedCol[curRazer.r][curRazer.c] = true;
            }
            if(curRazer.r == end[0] && curRazer.c == end[1]) {
                continue;
            }
            for(int i = 0; i < 4; i++) {
                int nr = curRazer.r + dr[i];
                int nc = curRazer.c + dc[i];
                if (isAvailable(nr, nc)) {
//                  행 이동
                    if (i < 2) {
                        //행 변하는 razer였다면
                        if (curRazer.changeR) {
                            razer = new Razer(nr, nc, curRazer.item, true);
                        }else{
                            razer = new Razer(nr, nc, curRazer.item+1, true);
                        }
//                  열 이동
                    }else{
                        if (curRazer.changeR) {
                            razer = new Razer(nr, nc, curRazer.item+1, false);
                        }else{
                            razer = new Razer(nr, nc, curRazer.item, false);
                        }
                    }
                    if(map[nr][nc] < razer.item || map[cLoc[1][0]][cLoc[1][1]] < razer.item){
                        continue;
                    }else if(map[nr][nc] == razer.item){
                        if(razer.changeR){
                            if(visitedRow[nr][nc]) continue;
                        }else{
                            if(visitedCol[nr][nc]) continue;
                        }
                    }
                    stack.add(razer);
                }
            }
        }
    }

    public static boolean isAvailable(int r, int c) {
        if (0 <= r && r < R && 0 <= c && c < C && map[r][c] != -1) {
            return true;
        }
        else return false;
    }
}
