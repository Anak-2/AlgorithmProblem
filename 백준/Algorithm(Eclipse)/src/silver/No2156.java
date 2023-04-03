package silver;

import java.util.*;
import java.io.*;

// 포도주 시식
public class No2156 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
//		이전 3잔의 상태를 기억
//		dp[2] 2잔 연속으로 마실 수 있을 때 총 와인의 양
//		dp[1] 1잔 연속으로 마실 수 있을 때 총 와인의 양
//		dp[0] 0잔 연속으로 마실 수 있을 때 총 와인의 양
		int[] dp = new int[3];

		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}

//		n은 1일때 2일때 고려해서 코드 작성해놓고 return을 안하고 진행해버려서 계속 틀린 바보같은 실수...
		if (n == 1) {			
			System.out.println(list.get(0));
			return;
		}
		else if (n == 2) {
			System.out.println(list.get(0) + list.get(1));
			return;
		}
		else {
			int first = list.removeFirst();
			int second = list.removeFirst();
			int third = list.removeFirst();
			dp[2] = first + second;
			dp[1] = first + third;
			dp[0] = second + third;
//			System.out.print("시작 dp: ");
//			for(int element : dp) {
//				System.out.print(element+" ");
//			}
//			System.out.println();

			int temp0 = 0;
			int temp1 = 0;
			int temp2 = 0;
			for (int idx = 0; idx < list.size(); idx++) {
				temp0 = dp[0];
				temp1 = dp[1];
				temp2 = dp[2];
				int i = list.get(idx);
//				다음에 0잔 가능
				dp[0] = temp1 + i;
//				다음에 1잔 가능
				dp[1] = temp2 + i;
//				다음에 2잔 가능
//				max 고를 때 잔이 2잔 가능했던 것도 같이 비교한 이유
//				100 100 3 4 100 인 경우를 생각해보면 된다!
				dp[2] = Math.max(temp0, Math.max(temp1, temp2));
//				System.out.print("현재 dp: ");
//				for(int element : dp) {
//					System.out.print(element+" ");
//				}
//				System.out.println();
			}

		}

		int max = 0;
		for(int i : dp) {
			if(i > max) max = i;
		}
		System.out.println(max);
	}
}
