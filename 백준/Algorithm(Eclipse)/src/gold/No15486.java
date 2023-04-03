package gold;

import java.util.*;
import java.io.*;

// 퇴사 2
public class No15486 {
	
	static int[][] arr;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		arr = new int[2][N+1];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[0][i] = Integer.parseInt(st.nextToken());
			arr[1][i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N+1];
		int max = 0;
		int ans = 0;
		int completeDay = 0;
		for(int i = 1; i <= N; i++) {
			int tempMax = 0;
//			시작한 일을 끝내는 날
			completeDay = arr[0][i] + i - 1;
			if(completeDay <= N) {				
				if(dp[completeDay] < max + arr[1][i]) {
					dp[completeDay] = max + arr[1][i];
				}
			}
			if(max < dp[i]) max = dp[i];
		}

		System.out.println(max);
	}
}
