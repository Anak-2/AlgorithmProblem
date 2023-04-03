package silver;

import java.util.*;
import java.io.*;

// ���� ��� ��
public class No10844 {
	
	static int N;
	static int ans;
	static int div = 1000000000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int[][] dp = new int[10][N];
//		ó�� �����ϴ� ��� �ʱ�ȭ
		for(int i = 1; i < 10; i++) {
			dp[i][0] = 1;
		}
//		���� ����� ���� 0, 9�� Ư�� ���̽��� ���� ����ϰ� ������ ���� ��� ���
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
