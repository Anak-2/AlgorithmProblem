package gold;

import java.util.*;
import java.io.*;

public class No11401 {
    static int divide = 1000000007;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Integer.parseInt(st.nextToken());
        long k = Integer.parseInt(st.nextToken());
        System.out.println(solution(n, k));
    }

    public static long solution(long n, long k) {
        k = (n / 2 >= k) ? k : n - k;
//        System.out.println(k);
        long[] dp = new long[(int)n];
        dp[0] = 1;
        for (int i = 1; i <= k; i++) {
            dp[i] = ((dp[i - 1] % divide) * (n - i + 1) % divide * pow(i, divide-2) % divide) % divide;
        }
        return dp[(int)k];
    }

//    a^b 구하는 함수
    public static long pow(long a, long b){
        if(b == 1){
            return a % divide;
        }
        long temp = pow(a, b/2);
        if(b % 2 == 1){
            return (temp * temp % divide) * a % divide;
        }
        return temp * temp % divide;
    }
}
