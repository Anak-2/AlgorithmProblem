package silver;

import java.io.*;
import java.util.*;

// N°ú M(8)
public class No15657 {
//	static public ArrayList<int[]> stack = new ArrayList<>();
	static int n;
	static int m;
	static int[] num;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		num = new int[n];
		String[] numString = br.readLine().split(" ");
		for(int i = 0; i < numString.length; i++) {
			num[i] = Integer.parseInt(numString[i]);
		}
		Arrays.sort(num);
		int[] arr = new int[m];
		increasingForLoop(0, 0, arr);
	}
	
	private static void increasingForLoop(int previousInt, int index, int[] arr) {
		for(int i = previousInt; i < n; i++) {
			arr[index] = num[i];
			if(index+1 < m) {				
				increasingForLoop(i, index+1, arr);
			}
			if(index == m-1) {
				for(int j : arr) {
					System.out.print(j+" ");
				}
				System.out.println();
//				stack.add(arr);
			}
		}
		return;
	}
}
