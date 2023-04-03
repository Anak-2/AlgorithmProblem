package gold;

import java.util.*;
import java.io.*;

// ���� ���� ��ȹ
public class No1647 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
//		���� ����
		int N = Integer.parseInt(st.nextToken());
//		���� ����
		int M = Integer.parseInt(st.nextToken());
//		���� ���� (��� ��� -> {���� ���, ���})
		ArrayList<Integer[]>[] edges = new ArrayList[N+1];
//		�� ����� ������ ������ list ���� (���� ��� null pointer Exception)
		for(int i = 1; i <= N; i++) {			
			edges[i] = new ArrayList<Integer[]>();
		}
//		���� ���� ����
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			edges[n1].add(new Integer[] {n2, cost});
			edges[n2].add(new Integer[] {n1, cost});
		}
		
		boolean[] visited = new boolean[N+1];
//		(���, �Ÿ�) �� ���� �Ÿ����� ������ �켱���� ť
		PriorityQueue<Integer[]> pq = new PriorityQueue<>(
				(Integer[] a,Integer[] b) -> (int)(a[1] - b[1])
		);
//		ó�� �������� 1�� �ϰ� pq �ʱ�ȭ
		for(Integer[] start : edges[1]) {
			pq.add(new Integer[] {start[0], start[1]});
		}
		visited[1] = true;
//		MST�� ������ ����
		int mst = 0;
//		MST�� �̷�� ���� �� �ִ밪�� ������ ����
		int mstMaxEdge = 0;
//		���� �˰����� �̿��� Minimum Spanning Tree ���ϱ�
		while(!pq.isEmpty()) {
			Integer[] cur = pq.poll();
//			System.out.println("cur node: "+cur[0]);
			if(visited[cur[0]]) {
				continue;
			}
			mst += cur[1];
			if(mstMaxEdge < cur[1]) mstMaxEdge = cur[1];
			visited[cur[0]] = true;
			for(Integer[] next : edges[cur[0]]) {
//				System.out.println("next node: "+next[0]);
				pq.add(new Integer[] {next[0], next[1]});
			}
		}
		System.out.println(mst - mstMaxEdge);
	}
}
