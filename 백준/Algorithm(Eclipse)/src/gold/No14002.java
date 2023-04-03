package gold;

import java.util.*;
import java.io.*;

public class No14002 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
//		값을 기억할 배열
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
//		자신이 들어간 index를 기억하여 최대 길이의 수열부터 거꾸로해서 정답을 출력할 수 있도록 해주기
//		[자신이 들어간 index]
		int[] DP = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		List<Integer> sequence = new ArrayList<>();
		int len = 0;
//		수열의 최대값을 가지는 arr의 index, 나중에 최대 증가하는 수열의 실제 값을 백트래킹 할 때 필요!
		int max_index = 0;
		sequence.add(arr[0]);
		for (int i = 1; i < N; i++) {
			len = sequence.size();
//			System.out.println("i: "+i+" len: "+len);
			int max = sequence.get(len - 1);
//			현재 값이 수열의 최대값보다 더 크면 수열의 맨 끝에 추가
			if (arr[i] > max) {
				sequence.add(arr[i]);
				DP[i] = len;
				max_index = i;
//			현재 값이 수열의 최대값보다 작거나 같으면 자신이 수열에 들어갈 때 어디에 들어갈 수 있는지
//			이분 탐색을 이용한 lower_bound 사용
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
//		정답을 보관할 stack
		Stack<Integer> ans = new Stack<>();
		ans.push(arr[max_index]);
		for (int i = max_index - 1; i >= 0; i--) {
//			이전 값은 현재 값이 들어간 index보다 1 작아야되고 값도 작아야한다
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

//  증가하는 부분 수열의 최대 길이를 구하는 것엔 의미가 있지만 최대 길이의 수열을 이것 만으론 구할 수 없다
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
