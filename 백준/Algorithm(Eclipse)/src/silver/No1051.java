package silver;

import java.util.*;
import java.io.*;

// 숫자 정사각형
public class No1051 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
//		N과 M 중 더 작은 수를 정사각형의 최대 길이
		int len = (N > M) ? M : N;
		
		int[][] arr = new int[N+1][M+1];
		char[] line;
		for(int i = 1; i <= N; i++) {
			line = br.readLine().toCharArray();
			
			for(int j = 1; j <= M; j++) {
				arr[i][j] = (int) line[j-1];
			}
		}
		int val = 0;
		while(len > 0) {
			for(int i = len; i <= N; i++) {
				for(int j = len; j <= M; j++) {
					val = arr[i][j];
					if(val == arr[i-len+1][j] && val == arr[i][j-len+1] && val == arr[i-len+1][j-len+1]) {
						System.out.println(len*len);
						return;
					}
				}
			}
			len--;
		}
	}

}
