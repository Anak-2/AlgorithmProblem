package silver;

import java.util.*;
import java.io.*;

// N�� M(12)
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
//		�ߺ����� ������ ����� ���� set �̿�
		for (int i = 0; i < n; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}

//		������������ �����ϱ� ���� ArrayList�� ��ȯ
		ArrayList<Integer> arr = new ArrayList<>(set);
//		ArrayList�� Array.sort�� �ƴ� Collections.sort�� ����
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