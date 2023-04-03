package gold;

import java.util.*;
import java.io.*;

// ���� ����
public class No1202 {
//	ó�� ������ �� ��������� �����ؼ� ���濡 �� �� ������ �ְ� ���� ������ ������ �� ���� �� �ִ� ���濡
//	���� �������� ������ ���� ������ �ִٸ� �ѾƳ��� �Ѱܳ� ������ �ڿ� ������ ���캸�鼭 �ڱ⺸�� ������ ���� ������ ã�� ���̾���
//	�׷��� �̷��� �־��� ��� �� �������� ���� ũ�⸸ŭ�� for���� ���� ��� N*K�̰�  N, K�� 30������ �����ϹǷ� (3*10^5)^2 ����� ����

//	���� ��� ���� ������ �������� ���ĵ� ������ for���� ���鼭 ���� ���濡 �� �� �ִ� �������� �̸� �̾Ƶдٸ�
//	������ ��ȸ�� �� ���� ���濡 �� �� �ִ� ������ ���� ���濡�� �� �� �����Ƿ� �ߺ��ؼ� ���캸�� ��츦 ���� �ٿ��ش�
//	���� ������ ���� ������������ �����ϸ� ���� for���� �� �� �� �� �ִ� ���� �� �ִ� ������ �������� �ٽ� ���캸�Ƿ� ��츦 �ٿ��ش�
//	�־��� ����� ���� (���� ���� * ���� ����) �̹Ƿ� ó�� ���ٺ��� ��Ʈ�� ���ŭ �ð����⵵�� �پ���

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
//		���� ����
		int N = Integer.parseInt(st.nextToken());
//		���� ����
		int K = Integer.parseInt(st.nextToken());
//		���� ���� ���� �迭 (����, ����)
		int[][] jewerly = new int[N][2];
//		���� ���� ���� �迭 (��� ����, ����, ���� ����)
		int[][] bag = new int[K][3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			jewerly[i][0] = a;
			jewerly[i][1] = b;
		}
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			bag[i][0] = a;
		}
		

//		���� ��� ���� ������ ���� (a > b �̸� 1 ��ȯ, a = b �̸� 0 ��ȯ, a < b �̸� -1 ��ȯ)
//		compare�� 1�̸� ���� 0�Ǵ� -1�̸� ����
//		sort�� CmparatorŬ���� �Ű������� compare�� ���� �Լ��� ����
//		**�����Լ��� functional interface(�Լ��� �������̽�)�� ��ȯ�ϹǷ� �̱��� �Լ��� 1���� �ִ� Ŭ�������� ���� �Լ� ��� ����

//		���� �������� ����
		Arrays.sort(bag, (a, b) -> Integer.compare(a[0], b[0]));
		Arrays.sort(jewerly, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				if (a[0] == b[0]) {
//					���� ������ ���� ��������
					return b[1] - a[1];
				}
//				���� ��������
				return a[0] - b[0];
			}
		});

//		for(int[] arr : jewerly) {
//			System.out.println(Arrays.toString(arr));
//		}
//		for(int[] arr : bag) {
//			System.out.println(Arrays.toString(arr));
//		}
		
//		long�� �� ���� ans�� �����÷ο� �ż� ����� �ٸ� �� ����
		long ans = 0;
//		���濡 �� �� �ִ� �������� ������ �־�δ� MaxHeap
		PriorityQueue<Integer> pQueue = new PriorityQueue<>(Comparator.reverseOrder());
//			���캻 ������ index
		int jewerlIndex = 0;
		for (int i = 0; i < K; i++) {
//				���� ��� ����
			int bagWeight = bag[i][0];
			for (int j = jewerlIndex; j < N; j++) {
//				���� ����
				int M = jewerly[j][0];
//				���� ����
				int V = jewerly[j][1];
				
				if(M <= bagWeight) {
					pQueue.add(V);
					jewerlIndex += 1;
				}
				else {
					break;
				}
			}
			if(!pQueue.isEmpty()) {
				int putVal = pQueue.poll();
				System.out.println(putVal);
				ans += putVal;
			}
		}

		System.out.println(ans);
	}

}
