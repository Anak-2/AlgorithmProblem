package gold;

import java.util.*;
import java.io.*;

// 빙산
public class No2573 {
	static int[][] arr;
	static int[] dr = new int[] { -1, 1, 0, 0 };
	static int[] dc = new int[] { 0, 0, -1, 1 };
	static int N;
	static int M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		boolean[][] visited;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 0;
		Loop1:
		while(true) {
			visited = new boolean[N][M];
			boolean flag = false;
			boolean allMelt = true;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(arr[i][j] > 0 && !visited[i][j]) {
						if(flag) {
							break Loop1;
						}else {
							flag = true;
						}
						allMelt = false;
						DFS(i, j, visited);
					}
				}
			}
			if(allMelt) {
				System.out.println(0);
				return;
			}
			cnt++;
		}
		System.out.println(cnt);
	}

// 다음 행과 열에 빙하인지 체크, 빙하이면 tempIceBergs에 넣고 다음 DFS 시작
	public static void DFS(int r, int c, boolean[][] visited) {
		visited[r][c] = true;
		int nextR, nextC;
		for (int i = 0; i < 4; i++) {
			nextR = r + dr[i];
			nextC = c + dc[i];
			if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < M) {
				if (!visited[nextR][nextC] && arr[nextR][nextC] > 0) {
					DFS(nextR, nextC, visited);
				}
			}
		}
//		빙하 녹이기
		for(int i = 0; i < 4; i++) {
			nextR = r + dr[i];
			nextC = c + dc[i];
			if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < M) {
				if (!visited[nextR][nextC] && arr[nextR][nextC] == 0) {
					arr[r][c]--;
				}
			}
		}
		if(arr[r][c] < 0) arr[r][c] = 0;
	}
	
	public static boolean checkDivide(boolean[][] visited) {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(arr[i][j] > 0 && !visited[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
	
}
