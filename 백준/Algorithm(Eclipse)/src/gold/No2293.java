package gold;

import java.util.*;
import java.io.*;

// ���� 1
public class No2293 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
//		������ ����
		int n = Integer.parseInt(st.nextToken());
//		���ϴ� ��ġ
		int k = Integer.parseInt(st.nextToken());
//		�ּ��� �޸� �ʰ��� Ǯ��
////		���� ������ ��ġ���� ������ ��ġ�� �湮�ߴ��� üũ�� �迭 (e.g ���� ������ ��ġ�� 3�� �� 10�� �湮�ߴ���)
////		(���� ������ ��ġ�� idx, ������ ��ġ)
//		int[][] dp = new int[n][k+1];
		
//		������ ��ġ�� idx�� �����ϴ� �迭
		int[] coinValue = new int[n];
		for(int i = 0; i < n; i++) {
			coinValue[i] = Integer.parseInt(br.readLine());
		}
		
////		(���� ������ ��ġ�� idx, ������ ��ġ) �� ������ priority queue, ������ ��ġ�� �� �ͺ��� ������
//		PriorityQueue<Integer[]> pq = new PriorityQueue<Integer[]>(
//				(a, b) -> a[1] - b[1]
//				);
////		���� ������ ��ġ idx
//		int idx = 0;
//		for(int i : coinValue) {
//			pq.add(new Integer[] {idx, i});
//			dp[idx][i] = 1;
//			idx++;
//		}
//		while(!pq.isEmpty()) {
//			Integer[] cur = pq.poll();
////			System.out.println(Arrays.deepToString(cur));
//			for(int i = cur[0]; i < n; i++) {
//				if(cur[1] + coinValue[i] > k) break;
////				���� ������ ��ġ�� �� ���� ������ ��ġ���� �����ϴ� ����� ��
//				if(dp[i][cur[1]+coinValue[i]] == 0) {					
//					pq.add(new Integer[] {i, cur[1]+coinValue[i]});
//				}
//				dp[i][cur[1]+coinValue[i]] += dp[cur[0]][cur[1]];
//			}
//		}
//		int cnt = 0;
//		for(int i = 0; i < n; i++) {
//			cnt += dp[i][k];
//		}
//		System.out.println(cnt);
		
//		���� ��ġ�� ����� ����� ����
//		������ ���� ������ 1���� �߰��ϱ� �� ����� ���� ���� ������ ��ġ 1���� �߰��� �����ָ� ���� ������ ��ġ�� ���� �� �ִ� ����� ���̴�.
//		��, dp[k] = dp[k] + dp[k-coinValue[i]] �� ����
		int[] dp = new int[k+1];
		dp[0] = 1;
		for(int i = 0; i < n; i++) {
			for(int j = coinValue[i]; j <= k; j++) {
				dp[j] += dp[j-coinValue[i]];
			}
		}
		System.out.println(dp[k]);
	}

}
