package gold;

import java.util.*;
import java.io.*;

// �Ҽ��� ������
public class No1644 {

	static List<Integer> primeNum = new ArrayList<>();
	static int N;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		if(N == 1) {
			System.out.println(0);
			return;
		}
//		���ͳ��� �����Ͽ� "�����佺�׳׽��� ü"�� �̿��ؼ� N������ �Ҽ� ���ϱ�
		boolean[] nums = new boolean[N + 1];
		for (int i = 2; i <= N; i++) {
			if (!nums[i]) {
				primeNum.add(i);
//				i * i < N �̾�� 90�ۿ��� Ʋ��... i * i �� N �̶� ���� ���� i�� ����� ���� ��!!
				if (i * i <= N) {
					int multiple = 2;
					while (i * multiple <= N) {
						nums[i * multiple] = true;
						multiple++;
					}
				}
			}
		}

		int total = 0;
		int startIdx = 0;
		int endIdx = 0;
//		{startIdx, endIdx} = startIdx ���� endIdx - 1���� ��ģ ��
		while(true) {
			if(total >= N) {
				total -= primeNum.get(startIdx);
				startIdx++;
			}
			else if(endIdx == primeNum.size()) break;
			else{
				total += primeNum.get(endIdx);
				endIdx++;
			}
			if(total == N) {
				ans++;
			}
		}
		System.out.println(ans);
	}
	
}
