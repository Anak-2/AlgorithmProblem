package gold;

import java.util.*;
import java.io.*;

// �κм����� ��2 (���ͳ� ����)
public class No1208 {
	static int N, S;
	static long cnt;
	static ArrayList<Integer> leftList = new ArrayList<>();
	static ArrayList<Integer> rightList = new ArrayList<>();
	static int[] arr;

//	�� ������ DP�� �̿��Ͽ� ��� ����� ���� ���캸�� ������� �����ߴ�
//	����� ���� �־��� ��� N�� 40�̹Ƿ� 2^40 �̾�����, ����� ���� �� ���ϴ� ��� ����� ������ �� ������ ������ �״�� �����߰�, DP�� �̿��Ͽ� ���� ���� �̿��߱� ������ �ݹ� �� ������ �� �˾Ҵ�
//	������ �� ����Ʈ �˰����� �̿��ϸ� �迭���� �� ������ ���� Ư�� ���� �����ϴ� ��� ��츦 ��� ���ϰ� ���� �� �ֱ� ������ �ξ� ������
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
//		N���� ����
		N = Integer.parseInt(st.nextToken());
//		�κм����� ��
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		cnt = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		subTotal(0, 0, N / 2, leftList);
		subTotal(0, N / 2, N, rightList);

		Collections.sort(leftList);
		Collections.sort(rightList);
		
		twoPoint();
		
//		��ǥ���� 0�� ��� ����, ������ �κ����� ��� 0�� ��쵵 ���ԵǹǷ� -1
		if(S == 0) {
			System.out.println(cnt - 1);
		}else {
			System.out.println(cnt);
		}

////		��갪���� ������ DP
//		List<Integer>[] DP = new ArrayList[N];
//		for(int i = 0; i < N; i++) {
//			DP[i] = new ArrayList<Integer>();
//		}
//		
//		int ans = 0;
//	
////		���� �Է� & ����
//		st = new StringTokenizer(br.readLine());
//		for(int i = 0; i < N; i++) {
//			DP[i].add(Integer.parseInt(st.nextToken()));
//		}
////		ù �κм����� Ư���ϰ� ó��
//		if(DP[0].get(0) == S) {
//			ans += 1;
//		}
//		for(int i = 1; i < N; i++) {
////			System.out.println("i :"+i);
//			int cur = DP[i].get(0);
////			System.out.println(cur);
//			if(cur == S) {
//				ans += 1;
//			}
//			int prev = DP[i-1].get(0);
//			for(int j = 1; j < Math.pow(2, i-1); j++) {
//				int prevListInt = DP[i-1].get(j);
//				if((prevListInt + cur - prev) == S) {
//					ans += 1;
//				}
////				System.out.println(prevListInt+" + "+cur+" - "+prev);
////				System.out.println(prevListInt + cur - prev);
//				DP[i].add(prevListInt + cur - prev);
//			}
//			for(int j = 0; j < Math.pow(2, i-1); j++) {
//				int prevListInt = DP[i-1].remove(0);
////				System.out.println(prevListInt+cur);
//				if((prevListInt + cur) == S) {
//					ans += 1;
//				}
//				DP[i].add(prevListInt + cur);
//			}
//		}
//		System.out.println(ans);

	}

//	����, ������ list�� �κ����� ����� �� ���
	private static void subTotal(int sum, int start, int end, ArrayList<Integer> list) {
		// ������ �������� ��� ȣ���� ������ ������ list�� �־� ��� �κм��� ���� ��츦 list�� ����
		if (start == end) {
			list.add(sum);
			return;
		}
		subTotal(sum, start + 1, end, list);
		subTotal(sum + arr[start], start + 1, end, list);
	}

//	
	private static void twoPoint() {
		int pointerL = 0;
		int pointerR = rightList.size() - 1;

		while (true) {
			if (pointerL == leftList.size() || pointerR < 0) {
				break;
			}
			int lv = leftList.get(pointerL);
			int rv = rightList.get(pointerR);

			// ���� ���� ���� ������ ���� �̷�� �ִ� �� ���� list ���� � �ִ��� ����.
			if (lv + rv == S) {
				long lc = 0;
				while (pointerL < leftList.size() && leftList.get(pointerL) == lv) {
					lc++;
					pointerL++;
				}

				long rc = 0;
				while (0 <= pointerR && rightList.get(pointerR) == rv) {
					rc++;
					pointerR--;
				}
				cnt += lc * rc;
			}

			// ��ǥ������ �� ū ���
			if (lv + rv > S) {
				pointerR--;
			}

			// ��ǥ������ �� ���� ���
			if (lv + rv < S) {
				pointerL++;
			}

		}

	}
}
