package gold;

import java.util.*;
import java.io.*;

//팰린드롬 분할 (인터넷 참고한 문제)
public class No1509 {

	static boolean[][] palindrome;
	static int[] dp;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int len = str.length();
		palindrome = new boolean[len+1][len+1];
		dp = new int[len+1];
		
		for(int i = 1; i <= len; i++) {
			dp[i] = len;
		}
		
		palindromeCheck(str);
		
//		문자열 중에서 DP[i]를 구할 때, DP[1] ~ DP[i-1] 은 팰린드롬 분할의 개수가 최소로 계산 된 상태
//		DP[i]는 j를 1부터 한칸 씩 증가시키면서 j부터 i가 팰린드롬이면 DP[j-1](1부터 j까지 문자열의 최소 팰린드롬 분할 개수) 에 팰린드롬 1개를 더한 DP[j-1] + 1이 DP[i]의 최소값이다
		for (int i = 1; i <= len; i++) {
			for (int j = 1; j <= i; j++) {
				if (palindrome[j][i]) {
					dp[i] = Math.min(dp[i], dp[j - 1] + 1);
				}
			}
		}
		
		System.out.println(dp[len]);
	}
	
	private static void palindromeCheck(String str) {
		int len = str.length();
		for (int left = 1; left <= len; left++) {
			for (int right = left; right <= len; right++) {
				boolean flag = true;
//				pointerLeft ~ pointerRight 까지 팰린드롬인지 검사
//				for문 변수가 바뀌면 안되므로 새로 할당
				int pl = left - 1;
				int pr = right - 1;
				
				while (pl <= pr) {
					if (str.charAt(pl++) != str.charAt(pr--)) {
						flag = false;
						break;
					}
				}
				if (flag)
					palindrome[left][right] = true;
			}
		}
	}

}
