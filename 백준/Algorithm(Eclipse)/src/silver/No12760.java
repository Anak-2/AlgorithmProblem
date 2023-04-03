package silver;

import java.io.*;
import java.util.*;

public class No12760 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][m];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr[i]);
		}
//		기본적으로 java의 int배열은 0으로 초기화
		int[] score = new int[n];
		
		for(int j = 0; j < m; j++) {
			int maxNum = 0;
			for(int i = 0; i < n; i++) {
				if(maxNum < arr[i][j]) {
					maxNum = arr[i][j];
				}
			}
			for(int idx = 0; idx < n; idx++) {
				if(arr[idx][j] == maxNum) {
					score[idx] += 1;
				}
			}
		}
//		for(int i:score) {
//			System.out.print(i+" ");
//		}
		StringBuffer sb = new StringBuffer();
		int maxNum = 0;
		for(int i = 0; i < n; i++){
			if(maxNum < score[i]) {
				maxNum = score[i];
				sb.delete(0,sb.length());
				sb.append(i+1+" ");
			}
			else if(maxNum == score[i]){
				sb.append((i+1)+" ");
			}
		}
		
		System.out.println(sb.toString());
	}
}
