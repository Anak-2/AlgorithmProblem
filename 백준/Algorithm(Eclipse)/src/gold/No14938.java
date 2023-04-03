package gold;

import java.io.*;
import java.util.*;

public class No14938 {
	static int INFINITY = 10000;
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
//		지역의 개수
		int n = Integer.parseInt(st.nextToken());
//		수색 범위
		int m = Integer.parseInt(st.nextToken());
//		엣지 개수
		int r = Integer.parseInt(st.nextToken());		
		
		st = new StringTokenizer(br.readLine());
//		각 지역별 아이템 개수
		int[] v = new int[n+1];
//		각 지역별 방문 정보
		int[] isVisit = new int[n+1];
//		각 지역별 최대로 가질 수 있는 아이템, int[] 는 primitive array이기 때문에 T[]인 매개변수에
//		작동하지 않는다. 그래서 Integer[]로 선언!!!!
		Integer[] maxItem = new Integer[n+1];
//		Integer 배열은 선언할 때 자동으로 0으로 초기화 되지 않기 때문에 초기화를 따로 해준다
		Arrays.fill(maxItem, 0);
		for(int i = 1; i <= n; i++) {
			v[i] = Integer.parseInt(st.nextToken());
		}
		
//		간선 정보
		int[][] e = new int[n+1][n+1];
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				e[i][j] = INFINITY;
				if(i==j) {
					e[i][j] = 0;
				}
			}
		}
		
		for(int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			e[start][end] = distance;
			e[end][start] = distance;
		}
	
		
//		플로이드 워셜
		for(int i = 1; i < n+1; i++) {
			for(int j = 1; j < n+1; j++) {
				for(int k = 1; k < n+1; k++) {
					if(i==j || j==k || i==j) continue;
					if(e[j][i] + e[i][k] < e[j][k]) {
						e[j][k] = e[j][i] + e[i][k];
					}
				}
			}
		}
		
//		각 정점을 출발점으로 했을 때 아이템 개수
		for(int i = 1; i < n+1; i++) {
			for(int j = 1; j < n+1; j++) {
				if(e[i][j] <= m) {
					maxItem[i] += v[j];
				}
			}
		}
		
//		내림차순 정렬
		Arrays.sort(maxItem, Collections.reverseOrder());
		System.out.println(maxItem[0]);
		
//		간선 정보 출력
//		for(int i = 1; i <= n; i++) {
//			for(int j = 1; j <= n; j++) {
//				if(e[i][j] == INFINITY) {
//					System.out.print("INF ");
//				}
//				else {						
//					System.out.print(e[i][j]+" ");
//				}
//			}
//			System.out.println();
//		}
		
	}

//	Java MinHeap 라이브러리
//	PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
}
