package gold;

import java.util.*;
import java.io.*;

// �Ӹ����?
public class No10942 {

//	ó�� ����: �� �����͸� �Ἥ ���۰� �� ���� �ϳ��� �ٿ����� �Ӹ���� �˻�, ���� != ���̸� false
//	�ð� �ʰ��� ����: ��� ����� ���� ���� �߰��� ���캸�� ���� Ż���ϴ� �� �����δ� �ð� �ʰ��� ���� (��ǻ�� ����ɷ��� �ʹ� �д��� ������ ��)
//	�� ��° ����: ���̰� n+2�� �Ӹ������ �˻��� �� �� ���� ������ �˻�� �� ���� ������ ���̰� n�� �迭�� �Ӹ�������� �˻�
//				ó�� ���ٰ� �� ���̰� �����Ŷ� ���������� ���̰� n+2�� �Ӹ���� �˻��ϱ� �� ���̰� n�� �Ӹ�������� �̹� �����صױ� ������ �ξ� ������ ����
//	�� ��° ����: System�� �̿��� ��� ����������... StringBuilder�� ��Ƽ� �� ���� ����ϱ�
	static boolean[][] isPalindrome;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		isPalindrome = new boolean[N][N];
		checkPalindrome();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			if (isPalindrome[s - 1][e - 1]) {
				sb.append("1\n");
			}
			else {
				sb.append("0\n");
			}
		}
		System.out.println(sb);
	}

	static void checkPalindrome() {
		int len = arr.length;
//		���̰� 1�� ���ڿ��� �Ӹ����
		for (int i = 0; i < len; i++) {
			isPalindrome[i][i] = true;
		}
//		���̰� 2�� ���ڿ��� �Ӹ����
		for (int i = 0; i < len - 1; i++) {
			if (arr[i] == arr[i + 1]) {
				isPalindrome[i][i + 1] = true;
			}
		}
//		���̰� 3 �̻��� ���ڿ��� �Ӹ����
//		���� ���̰� 5�� ���ڿ��� �Ӹ������ ���Ѵٸ� ���̰� 4�� �Ӹ������ ������� �̿��ؼ� �ݹ� ���� �� �ִ�
		for (int i = 2; i <= len-1; i++) {
			for (int j = 0; j < len-i; j++) {
				if(arr[j] == arr[j+i] && isPalindrome[j+1][j+i-1]) {
					isPalindrome[j][j+i] = true;
				}
			}
		}
	}
}
