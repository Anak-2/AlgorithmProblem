package gold;

import java.util.*;
import java.io.*;

//�Ӹ���� ���� (���ͳ� ������ ����)
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
		
//		���ڿ� �߿��� DP[i]�� ���� ��, DP[1] ~ DP[i-1] �� �Ӹ���� ������ ������ �ּҷ� ��� �� ����
//		DP[i]�� j�� 1���� ��ĭ �� ������Ű�鼭 j���� i�� �Ӹ�����̸� DP[j-1](1���� j���� ���ڿ��� �ּ� �Ӹ���� ���� ����) �� �Ӹ���� 1���� ���� DP[j-1] + 1�� DP[i]�� �ּҰ��̴�
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
//				pointerLeft ~ pointerRight ���� �Ӹ�������� �˻�
//				for�� ������ �ٲ�� �ȵǹǷ� ���� �Ҵ�
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
