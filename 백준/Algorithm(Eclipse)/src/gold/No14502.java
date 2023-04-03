package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 연구소 문제
public class No14502 {
	static int safetyZone = 0;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String[] size = br.readLine().split(" ");
		int n = Integer.parseInt(size[0]);
		int m = Integer.parseInt(size[1]);
		
		List<int[]> gas = new ArrayList<>();
		int[][] arr = new int[n][m];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 2) {					
					gas.add(new int[]{i,j});
				}
			}
		}
		Greedy(arr, gas, 0);
		System.out.println(safetyZone);
	}
	
//	make wall
	private static void Greedy(int[][] arr, List<int[]> gas, int wall) {
		int n = arr.length;
		int m = arr[0].length;
		if(wall == 3) {
			int temp = BFS(arr, gas);
			if(temp > safetyZone) {
				safetyZone = temp;
			}
			return;
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(arr[i][j] == 0) {
					arr[i][j] = 1;
					Greedy(arr, gas, wall+1);
					arr[i][j] = 0;
				}
			}
		}
	}
	
//	** 자바에서 함수를 통한 객체 전달은 Call by reference 방식이다! (String, int, char 등 기본 자료형은 해당x)
//	gas spread
	private static int BFS(int[][] arr, List<int[]> gas) {
		List<int[]> curGas = new ArrayList<>(gas);
//		for(int i = 0; i < curGas.size(); i++) {
//			System.out.println(Arrays.toString(curGas.get(i)));
//		}
		int n = arr.length;
		int m = arr[0].length;
		int[][] curArr = new int[n][m];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				curArr[i][j] = arr[i][j];
			}
		}
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		int safe = 0;
		
		while(!curGas.isEmpty()) {
			int[] current = curGas.remove(0);
			for(int k = 0; k < 4; k++) {
				if(0 <= current[0]+dx[k] && current[0]+dx[k] < n && 0 <= current[1]+dy[k] && current[1]+dy[k] < m && curArr[current[0]+dx[k]][current[1]+dy[k]] == 0) {
					curArr[current[0]+dx[k]][current[1]+dy[k]] = 2;
					curGas.add(new int[] {current[0]+dx[k] , current[1]+dy[k]});
				}
			}
		}
//		System.out.println("현재 연구소");
//		for(int[] i : arr) {
//			for(int j : i) {
//				System.out.print(j+" ");
//			}
//			System.out.println();
//		}
//		System.out.println("가스 퍼진 연구소");
//		for(int[] i : curArr) {
//			for(int j : i) {
//				System.out.print(j+" ");
//			}
//			System.out.println();
//		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(curArr[i][j] == 0) {
					safe += 1;
				}
			}
		}
//		System.out.println("safe: "+safe);
		return safe;
	}
}
