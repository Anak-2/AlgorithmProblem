package gold;

import java.util.*;
import java.io.*;

// 동전 1
public class No2293 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
//		동전의 개수
		int n = Integer.parseInt(st.nextToken());
//		구하는 가치
		int k = Integer.parseInt(st.nextToken());
//		주석은 메모리 초과난 풀이
////		현재 동전의 가치에서 누적된 가치를 방문했는지 체크할 배열 (e.g 현재 동전의 가치가 3일 때 10을 방문했는지)
////		(현재 동전의 가치의 idx, 누적된 가치)
//		int[][] dp = new int[n][k+1];
		
//		동전의 가치를 idx로 저장하는 배열
		int[] coinValue = new int[n];
		for(int i = 0; i < n; i++) {
			coinValue[i] = Integer.parseInt(br.readLine());
		}
		
////		(현재 동전의 가치의 idx, 누적된 가치) 를 저장할 priority queue, 누적된 가치가 싼 것부터 꺼낸다
//		PriorityQueue<Integer[]> pq = new PriorityQueue<Integer[]>(
//				(a, b) -> a[1] - b[1]
//				);
////		현재 동전의 가치 idx
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
////				현재 누적된 가치일 때 현재 동전의 가치에서 시작하는 경우의 수
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
		
//		현재 가치를 만드는 경우의 수는
//		이전에 현재 동전의 1개를 추가하기 전 경우의 수와 현재 동전의 가치 1개를 추가한 더해주면 현재 동전의 가치로 만들 수 있는 경우의 수이다.
//		즉, dp[k] = dp[k] + dp[k-coinValue[i]] 와 같다
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
