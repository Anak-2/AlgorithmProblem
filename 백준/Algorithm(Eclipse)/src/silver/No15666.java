package silver;

import java.util.*;
import java.io.*;

// N과 M(12)
public class No15666 {

	static HashSet<Integer> set = new HashSet<>();
	static int n;
	static int m;
	static int[] ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		ans = new int[m];
		st = new StringTokenizer(br.readLine());
//		중복없는 수열을 만들기 위해 set 이용
		for (int i = 0; i < n; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}

//		오름차순으로 정렬하기 위해 ArrayList로 변환
		ArrayList<Integer> arr = new ArrayList<>(set);
//		ArrayList는 Array.sort가 아닌 Collections.sort로 정렬
		Collections.sort(arr);
		
		increasingForLoop(0, 0, arr);
	}

	private static void increasingForLoop(int ansPrev, int arrPrev, ArrayList<Integer> arr) {
		for (int j = arrPrev; j < arr.size(); j++) {
			ans[ansPrev] = arr.get(j);
			if (ansPrev == m - 1) {
				for(int i : ans) {
					System.out.print(i+" ");
				}
				System.out.println();
			} else {
				increasingForLoop(ansPrev + 1, j, arr);
			}

		}
	}
}