package silver;

import java.util.*;
import java.io.*;

// 안전 영역
public class No2468 {

	static int[] dr = new int[] { -1, 1, 0, 0 };
	static int[] dc = new int[] { 0, 0, -1, 1 };
	static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 총 맵 크기기
		n = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][n];

		// map의 최대 높이
		int mapMaxHeight = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(mapMaxHeight < map[i][j]) mapMaxHeight = map[i][j];
			}
		}
		// 방문한 곳 인지 표시할 visited 배열
		boolean[][] visited;
		int safeZoneMax = 0;
		LinkedList<Integer[]> dfs;
		for (int i = 0; i < mapMaxHeight; i++) {
			visited = new boolean[n][n];
			int cnt = 0;
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					// 만약 침수 높이와 같거나 낮으면 침수
					if (map[j][k] > i) {
						// find white space and white space area size
						if (!visited[j][k]) {
//							ArrayList 보다 LinkedList가 삽입, 삭제에서 훨씬 빠름!!!!!
//							dfs = new LinkedList<>();
//							dfs.add(new Integer[] { j, k });
							// check white spaces
//							
//							DFS를 안 쓰고 BFS, 함수 아닌 것으로 썼더니 탐색할 예정인 곳에 다른 곳에서 방문한 것을
//							너무 많이 넣어서 메모리 초과 & 시간 초과가 일어났다!!
//							되도록이면 DFS BFS는 함수를 써서 처리를 하자
							DFS(j,k,visited,map,i);
							cnt++;
						}
						if (safeZoneMax < cnt)
							safeZoneMax = cnt;
					}
				}
			}
		}
		System.out.println(safeZoneMax);
	}
	public static void DFS(int r, int c, boolean[][] visited, int[][] map, int i) {
		visited[r][c] = true;
		for (int iter = 0; iter < 4; iter++) {
			// check near white space
			int nextR = r + dr[iter];
			int nextC = c + dc[iter];
			if (nextR >= 0 && nextR < n && nextC >= 0 && nextC < n) {
				if (!visited[nextR][nextC] && map[nextR][nextC] > i) {
					DFS(nextR, nextC, visited, map, i);
				}
			}
		}
	}
}
