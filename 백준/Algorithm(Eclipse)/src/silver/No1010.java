package silver;

import java.io.*;
import java.util.*;

// 다리 놓기
public class No1010 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		int T = Integer.parseInt(st.nextToken());
		int N = 0;
		int M = 0;
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int ans = bridge(N, M);
			sb.append(ans+"\n");
		}
		System.out.println(sb);
	}
	
//	매개변수: (서쪽, 동쪽 다리 개수) 
//	반환값: 다리 놓는 경우의 수 반환
	private static int bridge(int w, int e) {
		int cnt = 0;
		int[][] DP = new int[w+1][e+1];
		for(int i = w; i <= e; i++) {
			DP[w][i] = 1;
		}
		for(int i = w-1; i > 0; i--) {
			for(int j = i; j <= e-w+i; j++) {		
				int sum = 0;
				for(int k = j+1; k <= e; k++) {
					sum += DP[i+1][k];
				}
				DP[i][j] = sum;
			}
		}
		for(int i = 1; i <= e-w+1; i++) {
			cnt += DP[1][i];
		}
		return cnt;
	}

}
