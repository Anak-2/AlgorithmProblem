package gold;

import java.util.*;
import java.io.*;

// ������ �� 
// dfs�� �湮�ߴ� ĭ�� ǥ�ø� �ؼ� �ٽ� ��湮 ���� �� ���� ��θ� �̿����� �ʵ��� ���ڴ� ���̵� ����������
// �湮�ߴ� ĭ�� ��Ʈ��ŷ �� ��� (����Լ�)�� �������� �ʾҴ�
public class No1520 {
	static int[][] arr;
	static int[][] visited;
	static int M;
	static int N;
	static int[] dr = new int[] {0, 0, 1 ,-1};
	static int[] dc = new int[] {1, -1, 0 ,0};
	static int ans = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
//		���� �迭
		arr = new int[M][N];
//		�湮�� ĭ����, ���� �������� �� �� �ִ� ������ ������ �迭
//		-1 : ���� �湮x
//		1 �̻� : ������������ �� �� �ִ� ĭ, ����� ��
		visited = new int[M][N];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				visited[i][j] = -1;
			}
		}
		System.out.println(dfs(new int[] {0,0}));
	}
	
//	���� �������� �ֺ��� �� �� �ִ� �� ���� �� ���
	public static int dfs(int[] start) {
//		���� ������ �������� �� ������ �� +1
		if(start[0] == M-1 && start[1] == N-1) {
			return 1;
		}
//		���� ĭ�� �湮�ߴ� ĭ�̸� ���캸�� �ʾƵ� �ȴ�
		if(visited[start[0]][start[1]] != -1) return visited[start[0]][start[1]];
		
//		���� ��ġ�� ���� �湮���� �ʾҴ� ĭ�̸� 0���� ����� 
//		(�ٸ� ��ο��� �� ĭ�� �湮���� �� �ٽ� �����¿츦 ���캸�� �ʱ� ����, ���� ���� �������� �� �� ���� ĭ�̾��ٸ� 0�� �����̱� ������
//		�ٸ� ��ο��� �� ĭ�� ã�ƿ͵� 0�� �������� ������)
		visited[start[0]][start[1]] = 0;
//		���� �������� �����¿�� �� �� �ִ� ���� �ִ��� Ȯ��
		for(int i = 0; i < 4; i++) {
			int nextRow = start[0] + dr[i];
			int nextCol = start[1] + dc[i];
			
			if(nextRow >= 0 && nextRow < M && nextCol >= 0 && nextCol < N) {
//				��ȭ�¿� �� ���� ĭ ���� ���� ���ٸ� dfs�����ϰ� ���ϰ� �����ֱ�
				if(arr[nextRow][nextCol] < arr[start[0]][start[1]]) {
					visited[start[0]][start[1]] += dfs(new int[] {nextRow, nextCol});
				}
			}
		}
//		���� �ڽ��� ĭ 
		return visited[start[0]][start[1]];
	}
}
