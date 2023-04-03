package gold;

import java.util.*;
import java.io.*;

// 파이프 옮기기 1
public class No17070 {
	
	static int n;
	static int[][] arr;
	static int ans = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		pipe(new int[] {0,1}, "rs");
		System.out.println(ans);
	}
	
//	give pipe's current coordinate and shape
	private static void pipe(int[] curLoc, String curPipe) {
//		current row and column
		int r = curLoc[0];
		int c = curLoc[1];
//		System.out.println("r: "+r+" c: "+c);
		if(curPipe.equals("rs")){
//			가로 이동
//			가로 이동
			if(c+1 < n) {
//				System.out.println("가로 이동");
				if(arr[r][c+1] != 1){
					if(r == n-1 && c+1 == n-1) {
						ans += 1;
						return;
					}
					pipe(new int[] {r,c+1}, "rs");
				}
			}
		}
		else if(curPipe.equals("cs")) {
//			세로 이동
			if(r+1 < n) {
//				System.out.println("세로 이동");
				if(arr[r+1][c] != 1) {
					if(r+1 == n-1 && c == n-1) {
						ans += 1;
						return;
					}
					pipe(new int[] {r+1,c}, "cs");
				}
			}
		}
		else {
//			가로 이동
			if(c+1 < n) {
//				System.out.println("가로 이동");
				if(arr[r][c+1] != 1){
					if(r == n-1 && c+1 == n-1) {
						ans += 1;
						return;
					}
					pipe(new int[] {r,c+1}, "rs");
				}
			}
//			세로 이동
			if(r+1 < n) {
//				System.out.println("세로 이동");
				if(arr[r+1][c] != 1) {
					if(r+1 == n-1 && c == n-1) {
						ans += 1;
						return;
					}
					pipe(new int[] {r+1,c}, "cs");
				}
			}
		}
//		대각 이동
		if(r+1 < n && c+1 < n) {
//			System.out.println("대각 이동");
			if(arr[r+1][c] != 1 && arr[r][c+1] != 1 && arr[r+1][c+1] != 1){
				if(r+1 == n-1 && c+1 == n-1) {
					ans += 1;
					return;
				}
				pipe(new int[] {r+1,c+1}, "ds");
			}
		}
	}

}
