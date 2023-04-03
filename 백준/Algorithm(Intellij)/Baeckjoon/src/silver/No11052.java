package silver;

import java.util.*;
import java.io.*;

public class No11052 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] cost = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            cost[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N+1];
        for(int i = 1; i < N+1; i++){
            for(int j = 0; j <= i; j++){
                dp[i] = Math.max(dp[i-j]+cost[j], dp[i]);
            }
        }
        System.out.println(dp[N]);
    }
}
