package gold;

import java.util.*;
import java.io.*;
import java.math.*;

public class No15686 {
//	���� ����
	static int[][] arr;
	static int n;
	static int m;
//	ġŲ�� ����
	static ArrayList<int[]> chicken = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
//		NxN ũ�� ����
		n = Integer.parseInt(st.nextToken());
//		m�� ġŲ�� ����
		m = Integer.parseInt(st.nextToken());

//		(1,1) ~ (n,n) ���� �迭 �̿�
		arr = new int[n + 1][n + 1];
		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < n + 1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 2) {
					chicken.add(new int[] { i, j });
				}
			}
		}
//		���� ���� ���
//		for(int[] row : arr) {
//			for(int element: row) {
//				System.out.print(element+" ");
//			}
//			System.out.println();
//		}
		
//		��ϴ� ġŲ���� index�� ����� �� ����
		ArrayList<ArrayList<int[]>> runIndex = new ArrayList<>();
//		��ϴ� ġŲ���� chicken list�� index�� �˷��ֱ�

//		ġŲ���� i�� ��� �� ����� ��
		for (int i = 1; i <= m; i++) {
			ArrayList<int[]> intArr = new ArrayList<int[]>();
			int[] run = new int[i];
			combination(1, chicken.size(), i, run, intArr);
			runIndex.add(intArr);

		}
		
//		ArrayList<ArrayList<Integer>> ���
//		for(ArrayList<int[]> q : runIndex) {			
//			for (int[] p : q) {
//				for (int o : p) {
//					System.out.print(o + " ");
//				}
//				System.out.println();
//			}
//		}

		int minCityDist = Integer.MAX_VALUE;

		for (ArrayList<int[]> runChicken : runIndex) {
			for (int[] run : runChicken) {
				int temp = getCityDist(run);
				if (minCityDist > temp) {
					minCityDist = temp;
				}
			}
		}

		System.out.println(minCityDist);
	}

//	������ ġŲ �Ÿ��� ���ϴ� �Լ�(�Ű�����: ���� ����Ʈ, ��ϴ� ġŲ�� index ����)
	private static int getCityDist(int[] run) {
		int minSum = 0;
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (arr[i][j] == 1) {
					int min = Integer.MAX_VALUE;
					for (int k : run) {
						if (min > Math.abs(i - chicken.get(k-1)[0]) + Math.abs(j - chicken.get(k-1)[1])) {
							min = Math.abs(i - chicken.get(k-1)[0]) + Math.abs(j - chicken.get(k-1)[1]);
						}
					}
					minSum += min;
				}
			}
		}
		return minSum;
	}

//	a���� b������ ���� �� num�� ��ŭ ���� �ٸ� ���ڸ� �̴� �Լ� (������ ����� �� ��� ���ϱ�), arr�� num�� ��ŭ ���ڸ� ���� �� ������ �迭, intArr�� arr���� ������ �迭
	private static void combination(int a, int b, int num, int[] arr, ArrayList<int[]> intArr) {
//		a���� b���� ���� �� �ִ� ���� num�� ���� ������ ����
		if (b - a + 1 < num) {
			return;
		}
//		arr�迭�� �� ��° index�� �־���� �� ���
		int index = arr.length - num;
//		a���� b���� 1���� �̴� ����� 1���� �̰� arr�� �־ intArr�� �߰�
		if (index == arr.length - 1) {
			for (int i = a; i <= b; i++) {
				arr[index] = i;
				intArr.add(arr.clone());
			}
			return;
		}
		for (int i = a; i <= b; i++) {
			arr[index] = i;
			combination(i + 1, b, num - 1, arr, intArr);
		}
	}
}
