package gold;

import java.util.*;
import java.io.*;

// 비숍 (백트래킹, DFS 이용해서 모든 경우의 수 살펴보기)
public class No1799 {
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = new int[]{-1,-1,1,1};
    static int[] dc = new int[]{-1,1,-1,1};
    static int N;
    static int ans = 0;
    static boolean prevOdd = true;
    public static void main(String[] args) throws Exception{
        int finalAns = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
//        흰색 칸 살펴보기
        bishopPut(0, 0, 0, true);
        finalAns += ans;
//        System.out.println("white: "+ans);
        ans = 0;
//        검은색 칸 살펴보기
        bishopPut(0,1,0,false);
//        System.out.println("black: "+ans);
        finalAns += ans;
        System.out.println(finalAns);
    }

    public static void bishopPut(int r, int c, int cnt, boolean prevOdd) {
        int[] next = getNext(r,c,prevOdd);
//      비숍 놓을 수 있으면 비숍 놓고 다음 칸 이동
        if(isPossible(r,c)){
//            System.out.println("r: "+r+" c: "+c);
            visited[r][c] = true;
            cnt += 1;
//            맨 끝 칸 <<ex) N이 5일 때 (4,4)>> 에서 방문할 수 있던 경우
//            visited true지만 다음 방문할 곳이 없어서 cnt+1을 볼 수 없어서 ans가 갱신되지 않던 문제 때문에
//            cnt++를 체스말 놓을 때 해주는 것으로 바꿨다
            ans = Math.max(cnt, ans);
            if(next != null){
//                줄 바뀌었으면
                if(next[2] == 1){
                    bishopPut(next[0], next[1], cnt, !prevOdd);
                }else{
                    bishopPut(next[0], next[1], cnt, prevOdd);
                }
            }
            cnt--;
            visited[r][c] = false;
        }
//        현재 칸에 놓지 않고 다음 칸 살펴보기
        if(next != null){
//                줄 바뀌었으면
            if(next[2] == 1){
                bishopPut(next[0], next[1], cnt, !prevOdd);
            }else{
                bishopPut(next[0], next[1], cnt, prevOdd);
            }
        }
    }

//    현재 칸에 비숍을 놓을 수 있는지 구하는 함수
    public static boolean isPossible(int r, int c){
//        비숍을 못 놓는 곳이므로 return false
        if(map[r][c] == 0) {
            return false;
        }
        for(int i = 0; i < 4; i++){
            int j = 0;
            while(true){
                j++;
                int nr = r + j*dr[i];
                int nc = c + j*dc[i];
//                대각선을 쭉 봤을 때 이미 방문한 곳이면 비숍 놓지 못하므로 return false
                if(nr >= 0 && nr < N && nc >= 0 && nc < N){
                    if(visited[nr][nc]) {
                        return false;
                    }
                }
//                한 쪽 대각선 다 봤으면 break
                else{
                    break;
                }
            }
        }
//        4쪽 대각선 다 봤는데 비숍이 없으므로 return true
//        System.out.println("r: "+r+" c: "+c);
        return true;
    }

//    다음 비숍이 살펴 볼 좌표를 구하는 함수, return 값은 {다음 살펴볼 칸 행, 열, 줄 바뀌었으면 0 아니면 1}
    public static int[] getNext(int curR, int curC, boolean prevOdd){
//        만약 열 + 2가 가능하면
        if(curC + 2 < N){
            return new int[]{curR, curC+2, 0};
//       열 + 2가 불가능하면 다음 줄로 넘어가는데, 다음 줄이 가능하면
        }else if(curR + 1 < N){
//            이전 줄 시작이 1번째 칸이었을 때
            if(prevOdd){
                return new int[]{curR + 1, 1, 1};
//                이전 줄 시작이 2번째 칸이었을 때
            }else{
                return new int[]{curR + 1, 0, 1};
            }
//            다음 살펴 볼 칸이 없을 때
        }else{
            return null;
        }
    }
}
