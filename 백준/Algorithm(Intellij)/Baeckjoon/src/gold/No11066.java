package gold;

import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

// 파일 합치기
public class No11066 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        while(T > 0){
            T--;
            int N = Integer.parseInt(br.readLine());
            int[] files = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                files[i] = Integer.parseInt(st.nextToken());
            }
            System.out.println(solution(files));
        }
    }

    public static int solution(int[] files){
        int[] sum = new int[files.length];
        sum[0] = files[0];
        for (int s = 1; s < sum.length; s++) {
            sum[s] = sum[s - 1] + files[s];
        }
        int[][] dp = new int[files.length][files.length];

        for (int i = 0; i < dp.length - 1; i++) {
            dp[i][i + 1] = files[i] + files[i + 1];
        }

        for (int j = 2; j < dp.length; j++) {
            for (int i = 0; i + j < dp.length; i++) {
                for (int k = i; k < i + j; k++) {
                    if (dp[i][i + j] == 0) {
                        dp[i][i + j] = dp[i][k] + dp[k + 1][i + j] + sumDist(sum, i, i + j);
                    } else {
                        dp[i][i + j] = Math.min(dp[i][i + j], dp[i][k] + dp[k + 1][i + j] + sumDist(sum, i, i + j));
                    }
                }
            }
        }
        return dp[0][dp.length - 1];
    }

    private static int sumDist(int[] sum, int start, int end) {
        if (start == 0) {
            return sum[end];
        }

        return sum[end] - sum[start - 1];
    }
}
