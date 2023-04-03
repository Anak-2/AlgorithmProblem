package gold;

import java.util.*;
import java.io.*;

// 문제집
public class No1766 {
	
	public static PriorityQueue<Integer> queue;
	public static ArrayList<Integer>[] ansList;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
//		문제의 수
		int N = Integer.parseInt(st.nextToken());
//		정보의 개수
		int M = Integer.parseInt(st.nextToken());
//		각 노드의 indegree를 저장할 배열
		int[] indegree = new int[N+1];
//		(start node 번호- > 다음 node 번호) 로 그래프를 저장할 ArrayList
		ArrayList<Integer>[] list = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list[s].add(e);
			indegree[e] += 1;
		}
//		(indegree가 0인 node 번호 -> 이어져 있는 node 번호) 로 그래프를 저장할 ArrayList
		ansList = new ArrayList[N+1];
//		indegree가 0이 된 노드들은 다음에 살펴 볼 노드로 지정
		queue = new PriorityQueue<>((a,b) -> a-b);
//		정답 순서를 저장
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++) {
			if(indegree[i] == 0) {
				queue.add(i);
			}
		}
		while(!queue.isEmpty()) {
			int startNode = queue.poll();
			sb.append(startNode+" ");
			BFS(startNode, indegree, list);
		}
		System.out.println(sb.toString());
	}

	public static void BFS(int startNode, int[] indegree, ArrayList<Integer>[] list) {
		for(Integer nextNode : list[startNode]) {
			indegree[nextNode]--;
			if(indegree[nextNode] == 0) {
				queue.add(nextNode);
			}
		}
	}
}
