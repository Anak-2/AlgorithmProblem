package gold;

import java.util.*;
import java.io.*;

// 외판원 순회 (Traveling Salesman problem)
public class No2098 {
    static int N;
    static int[][] map;
    static int[][] dp;
    static int maxBitMask;
    static int ans = Integer.MAX_VALUE/2;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        maxBitMask = (int)Math.pow(2,N);
        dp = new int[N][maxBitMask];
        for(int i = 0; i < N; i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE/2);
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 1);
        System.out.println(ans);
    }

//    @param : 현재 방문한 도시, 현재까지 방문한 도시들
    public static void dfs(int city, int visited){
//        전부 방문했으면
        if(visited == maxBitMask-1){
//            마지막 노드에서 출발 노드로 돌아오는 엣지가 없으면 오류
            if(map[city][0] == 0){
                return;
            }
            ans = Math.min(ans, dp[city][visited]+map[city][0]);
            return;
        }
        for(int i = 0; i < N; i++){
            if((visited & (1 << i)) == 0 && map[city][i] != 0){
//                System.out.println("현재 방문: "+String.format("%04d",Integer.parseInt(Integer.toBinaryString(visited))));
//                System.out.println("다음 방문: "+String.format("%04d",Integer.parseInt(Integer.toBinaryString(visited | (1 << i)))));
//                System.out.println("현재 값: "+dp[city][visited]);
//                System.out.println("다음 값: "+dp[city][visited | (1 << i)]);
//                System.out.println("-----------");
                //        출발점에서 다음 노드까지 거리 초기화
                if(visited == 1){
//                    System.out.println("초기 값 세팅");
                    dp[i][visited | (1 << i)] = map[0][i];
                    dfs(i, visited | (1 << i));
                }
                else if(dp[i][visited | (1 << i)] > dp[city][visited] + map[city][i]){
                    dp[i][visited | (1 << i)] = dp[city][visited] + map[city][i];
                    dfs(i, visited | (1 << i));
                }
            }
        }
    }
}
