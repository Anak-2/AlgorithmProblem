package silver;

import java.util.*;
import java.io.*;

// N과 M(9)
public class No15663 {

	static int[] arr;
	static int[] check;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		check = new int[n];
		int[] temp = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		increasingForLoop(0, temp);
	}

//	n개의 숫자들 중에서 temp배열의 index에 숫자를 저장
	private static void increasingForLoop(int index, int[] temp) {
		for(int i = 0; i < arr.length; i++) {
			if(check[i] == 0 && temp[index] < arr[i]) {
				temp[index] = arr[i];
				if(index == temp.length - 1) {
					for(int j = 0; j < temp.length; j++) {
						System.out.print(temp[j]+" ");
					}
					System.out.println();
				}
				else {
					check[i] = 1;
					increasingForLoop(index+1, temp);
					check[i] = 0;
				}
			}
			if(i == arr.length - 1) {
				temp[index] = 0;
			}
		}
	}
}
