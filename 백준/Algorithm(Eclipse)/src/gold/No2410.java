package gold;

import java.util.*;
import java.io.*;

public class No2410 {
	public static void main(String args[]) throws Exception{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int power = 0;
		
//		2�� ����� ���� nums
		int[] nums = new int[20];
		nums[0] = 1;
		for(int i = 1; i < 20; i++) {
			nums[i] = nums[i-1]*2;
		}
//		�Է°� n�� �ִ� 2�� �� �������� �˾Ƴ���
		for(int i : nums) {
			if(n < i) {
				power += 1;
				break;
			}
			power += 1;
		}
		
//		1~n���� 2�� ����� ������ ��Ÿ�� �迭 dp
		int[] dp = new int[1000001];
		dp[0] = 1;

		for(int i = 0; i < power; i++) {
			for(int j = nums[i]; j <= n; j++) {
				dp[j] = (dp[j] + dp[j - nums[i]])%1000000000;
			}
		}
		System.out.println(dp[n]);
	}
}
