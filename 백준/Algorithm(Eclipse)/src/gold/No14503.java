package gold;

import java.util.*;
import java.io.*;

// 로봇 청소기
public class No14503 {
	static int N;
	static int M;
	// start row
	static int sr;
	// start column
	static int sc;
	// map
	static int[][] map;
	// check is cleaned room
	static boolean[][] visited;
	// N , E , S , W // N -> W to r+1, c-1
	static int[][] rotate = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int cnt = 0;

//	DFS를 이용, 로봇의 방향을 바꿔주거나 유지하면서 이동하는 것이 핵심 구현
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		sr = Integer.parseInt(st.nextToken());
		sc = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		DFS(sr, sc, d);
		System.out.println(cnt);
	}

	public static void DFS(int r, int c, int d) {
		int originalD = d;
		if(!visited[r][c]) {			
			visited[r][c] = true;
			cnt++;
		}
		for (int i = 0; i < 4; i++) {
			d = (d + 3) % 4;
			int nextR = r + rotate[d][0];
			int nextC = c + rotate[d][1];
			if (checkWall(nextR, nextC)) {
				if (!visited[nextR][nextC]) {
//					System.out.println("nextR: "+nextR+" nextC: "+nextC);
					DFS(nextR, nextC, d);
					return;
				}
			}
		}
		int nextR = 0;
		int nextC = 0;
		d = (originalD + 2) % 4;
		nextR = r + rotate[d][0];
		nextC = c + rotate[d][1];
		if(checkWall(nextR, nextC)) {					
			DFS(nextR, nextC, originalD);
		}
	}

	public static boolean checkWall(int r, int c) {
		if (r < 0 || r > N - 1 || c < 0 || c > M - 1) {
			return false;
		} else if (map[r][c] == 1) {
			return false;
		}
		return true;
	}
}