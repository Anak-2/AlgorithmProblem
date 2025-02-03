package platinum;

import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

// 백조의 호수
public class No3197 {
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int R, C;
    static LinkedList<Loc> water = new LinkedList<>();
    static LinkedList<Loc> nextWater = new LinkedList<>();
    static int[] parents;
    static int[][] map;
    static int[][] swans = new int[2][2];
    static int dist = 1;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        parents = new int[R * C];
        Arrays.fill(parents, -1);
        int swanIdx = 0;
        for (int i = 0; i < R; i++) Arrays.fill(map[i], -1);

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                char curChar = str.charAt(j);
                if (curChar == 'L') {
                    swans[swanIdx][0] = i;
                    swans[swanIdx][1] = j;
                    map[i][j] = 0;
                    swanIdx++;
                }else if(curChar == '.'){
                    map[i][j] = 0;
                }
            }
        }
//        백조랑 물 union 하기, 물에 가까운 빙하는 water 셋에 넣기
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == -1) continue;
                boolean insertWater = false;
                for (int k = 0; k < 4; k++) {
                    int nr = i + dr[k];
                    int nc = j + dc[k];
                    if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
//                    다음 녹일 빙하 water에 저장
                    if (map[nr][nc] == -1) {
                        insertWater = true;
                        continue;
                    }
                    union(rcToIndex(i, j), rcToIndex(nr, nc));
                }
                if(insertWater) water.add(new Loc(i,j));
            }
        }
//      백조 둘이 만나는지 확인
        if (find(rcToIndex(swans[0][0], swans[0][1])) == find(rcToIndex(swans[1][0], swans[1][1]))) {
            System.out.println(dist);
            return;
        }

        while(true) {
            nextWater = new LinkedList<>();
//            System.out.println("call melt");
//            for(int[] i : map){
//                for(int j : i){
//                    System.out.print(j+" ");
//                }
//                System.out.println();
//            }
            for (Loc cur : water) {
                for (int k = 0; k < 4; k++) {
                    int nr = cur.r + dr[k];
                    int nc = cur.c + dc[k];
                    if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                    union(rcToIndex(cur.r, cur.c), rcToIndex(nr, nc));
                    //            다음 살펴볼 공간에서 백조 2마리가 만날 때
                    if (find(rcToIndex(swans[0][0], swans[0][1])) == find(rcToIndex(swans[1][0], swans[1][1]))) {
                        System.out.println(map[nr][nc]);
                        return;
                    }
                    if (map[nr][nc] == -1) {
                        nextWater.add(new Loc(nr, nc));
                        map[nr][nc] = dist;
                    }
                }
            }
            dist++;
            water = nextWater;
        }
    }

    private static int find(int a) {
        if (parents[a] < 0) return a;
        return parents[a] = find(parents[a]);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return;
        int h = parents[a]<parents[b]?a:b;
        int l = parents[a]<parents[b]?b:a;
        parents[h]+=parents[l];
        parents[l] = h;
    }

    static int rcToIndex(int r, int c) {
        return r * C + c;
    }

    static class Loc {
        int r;
        int c;

        public Loc(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public int hashCode() {
            int hash = 7;
            hash = 31 * hash + r;
            hash = 31 * hash + c;
            return hash;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || o.getClass() != this.getClass()) return false;
            Loc loc = (Loc) o;
            return this.r == loc.r && this.c == loc.c;
        }
    }
}