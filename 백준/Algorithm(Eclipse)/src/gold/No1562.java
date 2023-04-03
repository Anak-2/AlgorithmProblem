package gold;

import java.util.*;
import java.io.*;

// ��� ��
public class No1562 {
	
//	���ͳ� ������ ����... DP�� ��Ʈ����ŷ�� �����ؼ� Ǯ �� �ִ� �����̴� �� �ٽ� Ǯ� �������� �����!
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int mod = 1000000000;
		
		int[][][] dp = new int[N+1][10][1024];
		
		for(int i = 1; i < 10; i++) {
//			ù ��° �ڸ��� 0�� ������ 1~9�� �� ���̽������� ��Ʈ����ŷ�ϰ� ����� �� 1���� ����
			dp[1][i][1 << i] = 1;
		}
		
		for(int i = 2; i <= N; i++) {
			for(int j = 0; j < 10; j++) {
//				0���� 9���� �湮���ִ� ���鿡 ���� ������Ʈ
				for(int k = 0; k < (1 << 10); k++) {
//					���� �湮�� ��Ͽ� j�� �湮�� ������ ����ϵ��� ������Ʈ
					int bit = k | (1 << j);
					
					if(j == 0) {
//						i��°�� j�� �湮�ϴ� ����� �� 
//						���� ��� j�� 4��� ������ �湮�� ���� 3 �Ǵ� 5�� ��츸 �����Ѵ�
//						(j�� 0�̳� 9�϶� ���� ���°� 1�̳� 8�̾�� �ϹǷ� ���� ó��)
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
