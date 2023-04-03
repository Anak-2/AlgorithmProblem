package gold;

import java.util.*;
import java.io.*;

public class No14002 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
//		���� ����� �迭
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
//		�ڽ��� �� index�� ����Ͽ� �ִ� ������ �������� �Ųٷ��ؼ� ������ ����� �� �ֵ��� ���ֱ�
//		[�ڽ��� �� index]
		int[] DP = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		List<Integer> sequence = new ArrayList<>();
		int len = 0;
//		������ �ִ밪�� ������ arr�� index, ���߿� �ִ� �����ϴ� ������ ���� ���� ��Ʈ��ŷ �� �� �ʿ�!
		int max_index = 0;
		sequence.add(arr[0]);
		for (int i = 1; i < N; i++) {
			len = sequence.size();
//			System.out.println("i: "+i+" len: "+len);
			int max = sequence.get(len - 1);
//			���� ���� ������ �ִ밪���� �� ũ�� ������ �� ���� �߰�
			if (arr[i] > max) {
				sequence.add(arr[i]);
				DP[i] = len;
				max_index = i;
//			���� ���� ������ �ִ밪���� �۰ų� ������ �ڽ��� ������ �� �� ��� �� �� �ִ���
//			�̺� Ž���� �̿��� lower_bound ���
			} else {
				int index = lower_bound(sequence, arr[i]);
				DP[i] = index;
			}
		}
//		System.out.print("DP: ");
//		for(int i : DP) {
//			System.out.print(i+" ");
//		}
//		System.out.println();
//		������ ������ stack
		Stack<Integer> ans = new Stack<>();
		ans.push(arr[max_index]);
		for (int i = max_index - 1; i >= 0; i--) {
//			���� ���� ���� ���� �� index���� 1 �۾ƾߵǰ� ���� �۾ƾ��Ѵ�
			if (DP[i] == DP[max_index] - 1 && arr[max_index] > arr[i]) {
				max_index = i;
				ans.push(arr[i]);
			}
		}

		System.out.println(sequence.size());
		while (!ans.isEmpty()) {
			System.out.print(ans.pop() + " ");
		}
	}

//  �����ϴ� �κ� ������ �ִ� ���̸� ���ϴ� �Ϳ� �ǹ̰� ������ �ִ� ������ ������ �̰� ������ ���� �� ����
	public static int lower_bound(List<Integer> sequence, int target) {
		int len = sequence.size();
		int left = 0;
		int mid = len / 2;
		int right = len - 1;
		while (left < right) {
			if (sequence.get(mid) < target) {
				left = mid + 1;
			} else {
				right = mid;
			}
			mid = (left + right) / 2;
		}
		sequence.set(mid, target);
		return mid;
	}

}
