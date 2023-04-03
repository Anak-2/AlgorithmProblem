package gold;

import java.util.*;
import java.io.*;

// ���չ�
public class No10836 {

	static int N;
	static int M;
	static int[][] arr;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// ���� ũ��
		M = Integer.parseInt(st.nextToken());
		// ��¥
		N = Integer.parseInt(st.nextToken());
		// ���� ���� ������ �迭, 1,2 ��° ĭ�� ��ġ ���
		arr = new int[M][M];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = 1;
			}
		}
		// ���� ��, ��ĭ ����
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int zero = Integer.parseInt(st.nextToken());
			int one = Integer.parseInt(st.nextToken());
			int two = Integer.parseInt(st.nextToken());
			// ���� ���� �� �ֹ��� Ű���
			for (int i = M - 1; i > 0; i--) {
				if (zero != 0) {
					zero--;
				} else if (one != 0) {
					one--;
					arr[i][0] += 1;
				} else if (two != 0) {
					two--;
					arr[i][0] += 2;
				}
			}

			// ���� ���� �� �ֹ��� Ű���
			for (int i = 0; i < M; i++) {
				if (zero != 0) {
					zero--;
				} else if (one != 0) {
					one--;
					arr[0][i] += 1;
				} else if (two != 0) {
					two--;
					arr[0][i] += 2;
				}
			}
		}
//			������ ����
		growthRest();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

//	������ �ֹ����� �����Ű�� �Լ�
	public static void growthRest() {
		for (int i = 1; i < M; i++) {
			for (int j = 1; j < M; j++) {
//				���� ���� ���� ū ����
				arr[i][j] = arr[0][j];
			}
		}
	}
}
