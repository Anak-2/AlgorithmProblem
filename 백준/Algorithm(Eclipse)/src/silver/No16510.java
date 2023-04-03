package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No16510 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] works = new int[m];
		int[] workSum = new int[m];
		int idx = 0;
		while (st.hasMoreTokens()) {
			works[idx] = Integer.parseInt(st.nextToken());
			idx++;
		}
		for (int index = 0; index < m; index++) {
			if (index == 0) {
				workSum[index] = works[index];
			} else if (index > 0) {
				workSum[index] = workSum[index - 1] + works[index];
			}
		}
//		이진 탐색 이용해서 할 수 있는 일의 양 구하기
		while (n > 0) {
			int workTime = Integer.parseInt(br.readLine());
			int index = 0;
			if(workTime < workSum[0]) {
				System.out.println(index);
				continue;
			}
			index = findWork(0, m-1, workSum, workTime);
			System.out.println(index);
			n--;
		}
	}
	
	public static int findWork(int left, int right, int[] workSum, int workTime) {
		int index = (left+right)/2;
//		배열이 1칸인 경우 (index가 계속 같은 값)
		if(left == right) {
			if(workTime >= workSum[left]) {
				return index+1;
			}
			else {
				return index;
			}
		}
//		배열이 2칸인 경우 (index가 계속 같은 값)
		else if((right - left) == 1) {
			if(workTime >= workSum[right]) {
				return right+1;
			}
			else if(workTime >= workSum[left]) {
				return left+1;
			}
			else {
				return left;
			}
		}
		if(workSum[index] < workTime) {
			index = findWork(index, right, workSum, workTime);
		}
		else if(workSum[index] == workTime) {
			return index+1;
		}
		else {
			index = findWork(left, index-1, workSum, workTime);
		}
		return index;
	}
}
