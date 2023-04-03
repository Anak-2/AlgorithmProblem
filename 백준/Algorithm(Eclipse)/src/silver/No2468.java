package silver;

import java.util.*;
import java.io.*;

// ���� ����
public class No2468 {

	static int[] dr = new int[] { -1, 1, 0, 0 };
	static int[] dc = new int[] { 0, 0, -1, 1 };
	static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// �� �� ũ���
		n = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][n];

		// map�� �ִ� ����
		int mapMaxHeight = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(mapMaxHeight < map[i][j]) mapMaxHeight = map[i][j];
			}
		}
		// �湮�� �� ���� ǥ���� visited �迭
		boolean[][] visited;
		int safeZoneMax = 0;
		LinkedList<Integer[]> dfs;
		for (int i = 0; i < mapMaxHeight; i++) {
			visited = new boolean[n][n];
			int cnt = 0;
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					// ���� ħ�� ���̿� ���ų� ������ ħ��
					if (map[j][k] > i) {
						// find white space and white space area size
						if (!visited[j][k]) {
//							ArrayList ���� LinkedList�� ����, �������� �ξ� ����!!!!!
//							dfs = new LinkedList<>();
//							dfs.add(new Integer[] { j, k });
							// check white spaces
//							
//							DFS�� �� ���� BFS, �Լ� �ƴ� ������ ����� Ž���� ������ ���� �ٸ� ������ �湮�� ����
//							�ʹ� ���� �־ �޸� �ʰ� & �ð� �ʰ��� �Ͼ��!!
//							�ǵ����̸� DFS BFS�� �Լ��� �Ἥ ó���� ����
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
