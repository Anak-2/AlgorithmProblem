package gold;

import java.util.*;
import java.io.*;

// 내리막 길 
// dfs와 방문했던 칸에 표시를 해서 다시 재방문 했을 때 같은 경로를 이용하지 않도록 하자는 아이디어엔 도달했지만
// 방문했던 칸을 백트래킹 할 방식 (재귀함수)이 생각나지 않았다
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
//		지도 배열
		arr = new int[M][N];
//		방문한 칸인지, 도착 지점까지 갈 수 있는 길인지 저장할 배열
//		-1 : 아직 방문x
//		1 이상 : 도착지점까지 갈 수 있는 칸, 경우의 수
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
	
//	시작 지점에서 주변에 갈 수 있는 곳 저장 후 재귀
	public static int dfs(int[] start) {
//		도착 지점에 도착했을 때 지나온 길 +1
		if(start[0] == M-1 && start[1] == N-1) {
			return 1;
		}
//		현재 칸이 방문했던 칸이면 살펴보지 않아도 된다
		if(visited[start[0]][start[1]] != -1) return visited[start[0]][start[1]];
		
//		현재 위치를 아직 방문하지 않았던 칸이면 0으로 만들기 
//		(다른 경로에서 이 칸을 방문했을 때 다시 상하좌우를 살펴보지 않기 위해, 만약 도착 지점까지 갈 수 없는 칸이었다면 0인 상태이기 때문에
//		다른 경로에서 이 칸을 찾아와도 0만 더해지고 끝난다)
		visited[start[0]][start[1]] = 0;
//		현재 지점에서 상하좌우로 갈 수 있는 곳이 있는지 확인
		for(int i = 0; i < 4; i++) {
			int nextRow = start[0] + dr[i];
			int nextCol = start[1] + dc[i];
			
			if(nextRow >= 0 && nextRow < M && nextCol >= 0 && nextCol < N) {
//				상화좌우 중 현재 칸 보다 값이 낮다면 dfs시작하고 리턴값 더해주기
				if(arr[nextRow][nextCol] < arr[start[0]][start[1]]) {
					visited[start[0]][start[1]] += dfs(new int[] {nextRow, nextCol});
				}
			}
		}
//		최종 자신의 칸 
		return visited[start[0]][start[1]];
	}
}
