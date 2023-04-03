package gold;

import java.util.*;
import java.io.*;
import java.math.*;

public class No15686 {
//	도시 정보
	static int[][] arr;
	static int n;
	static int m;
//	치킨집 정보
	static ArrayList<int[]> chicken = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
//		NxN 크기 도시
		n = Integer.parseInt(st.nextToken());
//		m개 치킨집 고르기
		m = Integer.parseInt(st.nextToken());

//		(1,1) ~ (n,n) 까지 배열 이용
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
//		도시 지도 출력
//		for(int[] row : arr) {
//			for(int element: row) {
//				System.out.print(element+" ");
//			}
//			System.out.println();
//		}
		
//		운영하는 치킨집의 index들 경우의 수 모음
		ArrayList<ArrayList<int[]>> runIndex = new ArrayList<>();
//		운영하는 치킨집을 chicken list의 index로 알려주기

//		치킨집이 i개 운영될 때 경우의 수
		for (int i = 1; i <= m; i++) {
			ArrayList<int[]> intArr = new ArrayList<int[]>();
			int[] run = new int[i];
			combination(1, chicken.size(), i, run, intArr);
			runIndex.add(intArr);

		}
		
//		ArrayList<ArrayList<Integer>> 출력
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

//	도시의 치킨 거리를 구하는 함수(매개변수: 정수 리스트, 운영하는 치킨집 index 모음)
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

//	a부터 b까지의 숫자 중 num개 만큼 서로 다른 숫자를 뽑는 함수 (조합의 경우의 수 모두 구하기), arr는 num개 만큼 숫자를 뽑은 걸 저장할 배열, intArr는 arr들을 저장할 배열
	private static void combination(int a, int b, int num, int[] arr, ArrayList<int[]> intArr) {
//		a부터 b까지 뽑을 수 있는 수가 num개 보다 작으면 종료
		if (b - a + 1 < num) {
			return;
		}
//		arr배열의 몇 번째 index에 넣어야할 지 계산
		int index = arr.length - num;
//		a부터 b까지 1개만 뽑는 경우라면 1개를 뽑고 arr에 넣어서 intArr에 추가
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
