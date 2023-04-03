package gold;

import java.util.*;
import java.io.*;

// �Բ� ��� �ױ�
class No18427 {
	static int n;
	static int m;
	static int h;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		int[][] dp = new int[2][h + 1];
		List<Integer>[] blockList = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			blockList[i] = new ArrayList<Integer>();
			blockList[i].add(0);
			while (st.hasMoreTokens()) {
				blockList[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		for (int k = 0; k < blockList[0].size(); k++) {
			dp[0][blockList[0].get(k)] = 1;
		}
		// ���� ����� ����� ���� �����ؼ� ���� �ڽ��� ���� �� �ִ� ��� ����
		for (int i = 1; i < n; i++) {
			// ���� ����� ���� �� �ִ� ��츦 �������� ���� for��
			for (int j = 0; j <= h; j++) {
				// ���� �ڽ��� �������ִ� ���
				for (int k = 0; k < blockList[i].size(); k++) {
					if (blockList[i].get(k) + j <= h) {
//						System.out.println("����: "+(blockList[i].get(k) + j)+" ����: "+dp[0][j]);
						dp[1][blockList[i].get(k) + j] += dp[0][j];
						dp[1][blockList[i].get(k) + j] %= 10007;
					}
				}
			}
//			System.out.println(Arrays.toString(dp[1]));
			dp[0] = dp[1].clone();
			for(int d = 0; d < dp[1].length; d++) {
				dp[1][d] = 0;
			}
		}

		System.out.println(dp[0][h] % 10007);
	}
}