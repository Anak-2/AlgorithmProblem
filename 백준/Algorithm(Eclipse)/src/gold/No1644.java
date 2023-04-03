package gold;

import java.util.*;
import java.io.*;

// 소수의 연속합
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
//		인터넷을 참고하여 "에라토스테네스의 체"를 이용해서 N이하의 소수 구하기
		boolean[] nums = new boolean[N + 1];
		for (int i = 2; i <= N; i++) {
			if (!nums[i]) {
				primeNum.add(i);
//				i * i < N 이었어서 90퍼에서 틀림... i * i 가 N 이랑 같을 때도 i의 배수를 지울 것!!
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
//		{startIdx, endIdx} = startIdx 부터 endIdx - 1까지 합친 값
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
