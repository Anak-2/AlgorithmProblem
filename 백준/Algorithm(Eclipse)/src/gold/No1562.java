package gold;

import java.util.*;
import java.io.*;

// 계단 수
public class No1562 {
	
//	인터넷 참고한 문제... DP와 비트마스킹을 응용해서 풀 수 있는 문제이니 꼭 다시 풀어서 내것으로 만들기!
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int mod = 1000000000;
		
		int[][][] dp = new int[N+1][10][1024];
		
		for(int i = 1; i < 10; i++) {
//			첫 번째 자리에 0을 제외한 1~9가 온 케이스들한테 비트마스킹하고 경우의 수 1개로 저장
			dp[1][i][1 << i] = 1;
		}
		
		for(int i = 2; i <= N; i++) {
			for(int j = 0; j < 10; j++) {
//				0부터 9까지 방문되있는 경우들에 대해 업데이트
				for(int k = 0; k < (1 << 10); k++) {
//					이전 방문한 기록에 j를 방문한 것으로 기록하도록 업데이트
					int bit = k | (1 << j);
					
					if(j == 0) {
//						i번째에 j를 방문하는 경우의 수 
//						예를 들어 j가 4라면 이전에 방문한 수가 3 또는 5인 경우만 존재한다
//						(j는 0이나 9일때 이전 상태가 1이나 8이어야 하므로 예외 처리)
						dp[i][j][bit] = (dp[i-1][j+1][k] + dp[i][j][bit]) % mod;
					}else if(j == 9) {
						
						dp[i][j][bit] = (dp[i-1][j-1][k] + dp[i][j][bit]) % mod;
					}else {
						
						dp[i][j][bit] = (dp[i-1][j-1][k] + dp[i-1][j+1][k] + dp[i][j][bit]) % mod;
					}
				}
			}
		}
		int ans = 0;
		for(int i = 0; i < 10; i++) {
			ans = (dp[N][i][1023] + ans) % mod;
		}
		System.out.println(ans);
	}

}
