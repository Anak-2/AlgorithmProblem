package silver;

import java.util.*;
import java.io.*;

// 신나는 함수 실행
public class No9184 {
//	결과를 저장해 둘 dp
	static int[][][] dp = new int[21][21][21];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while(true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(a == -1 && b == -1 && c == -1) break;
			int ans = w(a, b, c);
			sb.append("w("+a+", "+b+", "+c+") "+"= "+ans);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static int w(int a, int b, int c) {
		if(a <= 0 || b <= 0 || c <= 0) return 1;
		if(a > 20 || b > 20 || c > 20) return w(20, 20, 20);
		if(a < b && b < c) {
			if(dp[a][b][c-1] == 0) {
				dp[a][b][c-1] = w(a, b, c-1);
			}
			if(dp[a][b-1][c-1] == 0) {
				dp[a][b-1][c-1] = w(a, b-1, c-1);
			}
			if(dp[a][b-1][c] == 0) {
				dp[a][b-1][c] = w(a, b-1, c);
			}
			return dp[a][b][c-1] + dp[a][b-1][c-1] - dp[a][b-1][c];
		}
		if(dp[a-1][b][c] == 0) {
			dp[a-1][b][c] = w(a-1, b, c);
		}
		if(dp[a-1][b][c-1] == 0) {
			dp[a-1][b][c-1] = w(a-1, b, c-1);
		}
		if(dp[a-1][b-1][c] == 0) {
			dp[a-1][b-1][c] = w(a-1, b-1, c);
		}
		if(dp[a-1][b-1][c-1] == 0) {
			dp[a-1][b-1][c-1] = w(a-1, b-1, c-1);
		}
		return dp[a-1][b][c] + dp[a-1][b][c-1] + dp[a-1][b-1][c] - dp[a-1][b-1][c-1];
	}
}
