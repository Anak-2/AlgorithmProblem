package silver;

import java.util.*;
import java.io.*;

// 쉬운 계단 수
public class No10844 {
	
	static int N;
	static int ans;
	static int div = 1000000000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int[][] dp = new int[10][N];
//		처음 시작하는 계단 초기화
		for(int i = 1; i < 10; i++) {
			dp[i][0] = 1;
		}
//		이전 계단을 보고 0, 9를 특이 케이스로 따로 계산하고 나머지 다음 계단 계산
		for(int i = 0; i < N-1; i++) {
			for(int j = 0; j < 10; j++) {
				if(j == 0) {
					dp[j+1][i+1] += dp[j][i];
					dp[j+1][i+1] %= div;
				}else if(j == 9) {
					dp[j-1][i+1] += dp[j][i];
					dp[j-1][i+1] %= div;
				}else {
					dp[j-1][i+1] += dp[j][i];					
					dp[j+1][i+1] += dp[j][i];
					dp[j-1][i+1] %= div;
					dp[j+1][i+1] %= div;
				}
			}
		}
		for(int i = 0; i < 10; i++) {
			ans += dp[i][N-1];
			ans %= div;
		}
		System.out.println(ans);
	}
}
