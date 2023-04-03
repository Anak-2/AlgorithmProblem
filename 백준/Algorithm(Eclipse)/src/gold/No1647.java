package gold;

import java.util.*;
import java.io.*;

// 도시 분할 계획
public class No1647 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
//		집의 개수
		int N = Integer.parseInt(st.nextToken());
//		길의 개수
		int M = Integer.parseInt(st.nextToken());
//		간선 정보 (출발 노드 -> {도착 노드, 비용})
		ArrayList<Integer[]>[] edges = new ArrayList[N+1];
//		각 노드의 간선을 저장할 list 생성 (안할 경우 null pointer Exception)
		for(int i = 1; i <= N; i++) {			
			edges[i] = new ArrayList<Integer[]>();
		}
//		간선 정보 세팅
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			edges[n1].add(new Integer[] {n2, cost});
			edges[n2].add(new Integer[] {n1, cost});
		}
		
		boolean[] visited = new boolean[N+1];
//		(노드, 거리) 로 작은 거리부터 저장할 우선순위 큐
		PriorityQueue<Integer[]> pq = new PriorityQueue<>(
				(Integer[] a,Integer[] b) -> (int)(a[1] - b[1])
		);
//		처음 시작점을 1로 하고 pq 초기화
		for(Integer[] start : edges[1]) {
			pq.add(new Integer[] {start[0], start[1]});
		}
		visited[1] = true;
//		MST를 저장할 변수
		int mst = 0;
//		MST를 이루는 엣지 중 최대값을 저장할 변수
		int mstMaxEdge = 0;
//		프림 알고리즘을 이용한 Minimum Spanning Tree 구하기
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
