package silver;

import java.util.*;
import java.io.*;

// ���� ����� ����
public class No11724 {
	
	static int cnt = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
//		������ ���� �����ϴ� ���� ����Ʈ {{��� ��� -> ���� ��� -> ���� ���2 ...} ... }
		List<Integer>[] edge = new ArrayList[N+1];
//		������ �湮�� ����
		int[] visited = new int[N+1];
		for(int i = 1; i <= N; i++) {			
			edge[i] = new ArrayList<Integer>();
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			edge[u].add(v);
			edge[v].add(u);
		}
		for(int i = 1; i <= N; i++) {
			if(dfs(edge, i, visited)) cnt++;
		}
		System.out.println(cnt);
	}
	
	public static boolean dfs(List<Integer>[] edge, int start, int[] visited) {
		if(visited[start] != 1) {
			visited[start] = 1;
			for(int i = 0; i < edge[start].size(); i++) {
				dfs(edge, edge[start].get(i), visited);
			}
			return true;
		}
		return false;
	}

}
