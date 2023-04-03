package silver;

import java.util.*;
import java.io.*;

// ������ �ý�
public class No2156 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
//		���� 3���� ���¸� ���
//		dp[2] 2�� �������� ���� �� ���� �� �� ������ ��
//		dp[1] 1�� �������� ���� �� ���� �� �� ������ ��
//		dp[0] 0�� �������� ���� �� ���� �� �� ������ ��
		int[] dp = new int[3];

		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}

//		n�� 1�϶� 2�϶� ����ؼ� �ڵ� �ۼ��س��� return�� ���ϰ� �����ع����� ��� Ʋ�� �ٺ����� �Ǽ�...
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
//			System.out.print("���� dp: ");
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
//				������ 0�� ����
				dp[0] = temp1 + i;
//				������ 1�� ����
				dp[1] = temp2 + i;
//				������ 2�� ����
//				max �� �� ���� 2�� �����ߴ� �͵� ���� ���� ����
//				100 100 3 4 100 �� ��츦 �����غ��� �ȴ�!
				dp[2] = Math.max(temp0, Math.max(temp1, temp2));
//				System.out.print("���� dp: ");
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
