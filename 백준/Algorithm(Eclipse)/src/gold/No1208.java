package gold;

import java.util.*;
import java.io.*;

// 부분수열의 합2 (인터넷 참고)
public class No1208 {
	static int N, S;
	static long cnt;
	static ArrayList<Integer> leftList = new ArrayList<>();
	static ArrayList<Integer> rightList = new ArrayList<>();
	static int[] arr;

//	이 문제를 DP를 이용하여 모든 경우의 수를 살펴보는 방식으로 접근했다
//	경우의 수가 최악의 경우 N이 40이므로 2^40 이었지만, 경우의 수를 다 비교하는 방법 말고는 생각할 수 없었기 떄문에 그대로 진행했고, DP를 이용하여 계산된 값을 이용했기 때문에 금방 비교 가능할 줄 알았다
//	하지만 투 포인트 알고리즘을 이용하면 배열에서 두 원소의 합이 특정 값을 만족하는 모든 경우를 계산 안하고 구할 수 있기 때문에 훨씬 빨랐다
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
//		N개의 정수
		N = Integer.parseInt(st.nextToken());
//		부분수열의 합
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
		
//		목표값이 0인 경우 왼쪽, 오른쪽 부분합이 모두 0인 경우도 포함되므로 -1
		if(S == 0) {
			System.out.println(cnt - 1);
		}else {
			System.out.println(cnt);
		}

////		계산값들을 저장할 DP
//		List<Integer>[] DP = new ArrayList[N];
//		for(int i = 0; i < N; i++) {
//			DP[i] = new ArrayList<Integer>();
//		}
//		
//		int ans = 0;
//	
////		수열 입력 & 저장
//		st = new StringTokenizer(br.readLine());
//		for(int i = 0; i < N; i++) {
//			DP[i].add(Integer.parseInt(st.nextToken()));
//		}
////		첫 부분수열만 특별하게 처리
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

//	왼쪽, 오른쪽 list에 부분합의 경우의 수 담기
	private static void subTotal(int sum, int start, int end, ArrayList<Integer> list) {
		// 지정된 범위까지 재귀 호출이 끝나는 시점에 list에 넣어 모든 부분수열 합의 경우를 list에 담음
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

			// 합이 목적 값과 같으면 합을 이루고 있는 각 수가 list 내에 몇개 있는지 센다.
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

			// 목표값보다 더 큰 경우
			if (lv + rv > S) {
				pointerR--;
			}

			// 목표값보다 더 작은 경우
			if (lv + rv < S) {
				pointerL++;
			}

		}

	}
}
