package gold;

import java.util.*;
import java.io.*;

//행렬 곱셈 순서
public class No11049 {
    static int[][] matrixes;
    static int[][] dp;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        matrixes = new int[N][2];
        dp = new int[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(i==j) dp[i][j] = 0;
                else dp[i][j] = Integer.MAX_VALUE/2;
            }
        }
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            matrixes[i][0] = Integer.parseInt(st.nextToken());
            matrixes[i][1] = Integer.parseInt(st.nextToken());
        }
        for(int c = 1; c < N; c++){
            for(int i = 0; i + c < N; i++){
                solution(i, i+c);
            }
        }
        System.out.println(dp[0][N-1]);
    }

    public static void solution(int start, int end){
        for(int i = start; i < end; i++){
            int cost = dp[start][i] + dp[i+1][end] + matrixes[start][0] * matrixes[i][1] * matrixes[end][1];
            dp[start][end] = Math.min(dp[start][end], cost);
        }
    }
}
