package bronze;

import java.util.*;
import java.io.*;

public class No2596 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int[] A = { 0, 0, 0, 0, 0, 0 };
		int[] B = { 0, 0, 1, 1, 1, 1 };
		int[] C = { 0, 1, 0, 0, 1, 1 };
		int[] D = { 0, 1, 1, 1, 0, 0 };
		int[] E = { 1, 0, 0, 1, 1, 0 };
		int[] F = { 1, 0, 1, 0, 0, 1 };
		int[] G = { 1, 1, 0, 1, 0, 1 };
		int[] H = { 1, 1, 1, 0, 1, 0 };
		
		char[] charArr = {'A','B','C','D','E','F','G','H'};
		List<int[]> intArr = new ArrayList<>();
		intArr = List.of(A, B, C, D, E, F, G, H);
//		for (int[] i : intArr) {
//			for (int item : i) {
//				System.out.print(item + " ");
//			}
//			System.out.println("");
//		}
		
//		입력 받기
		int intInput = Integer.parseInt(bf.readLine());
		String strInput= bf.readLine();
		int iter = 0;
		boolean found = false;
		StringBuffer sb = new StringBuffer();
		while(iter < intInput) {
			found = false;
//			A~H까지 일치 검사
			int saveIndex = 0;
			for(int[] i : intArr) {
				int cnt = 0;
//				A(부터 H까지)와 1개 빼고 일치하는지 검사
				for(int index = 0; index < 6; index++) {
//					System.out.println(charArr[saveIndex]);
//					System.out.print("compare "+i[index]);
//					System.out.println(" with "+((int)(strInput.charAt(index+iter*6))-'0'));
					if(i[index] != ((int)(strInput.charAt(index+iter*6))-'0')) {
						cnt += 1;
					}
					if(cnt > 1) {
//						System.out.println("does not same");
						break;
					}
				}
				if(cnt < 2) {
//					System.out.println("same!");
					sb.append(charArr[saveIndex]);
					found = true;
					break;
				}
				saveIndex++;
			}
			if(!found) {
				System.out.println(iter+1);
				return;
			}
			iter++;
		}
		System.out.println(sb.toString());
	}
}
