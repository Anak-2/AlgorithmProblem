package silver;

import java.io.*;
import java.util.*;

// ���� �� �����ϴ� �κ� ����
public class No11722 {
	
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
//		dp[k] : k ��° �� ���� �ڽ��� �����ϴ� �ִ� �����ϴ� �κ� ������ ����, 
		int[] dp = new int[n];
		for(int i = 0; i < n; i++) {
			dp[i] = 1;
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < i; j++) {
				if(arr[j] > arr[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
			}
		}
		int max = 0;
		for(int i : dp) {
			if(max < i) max = i;
		}
		System.out.println(max);
	}

}
