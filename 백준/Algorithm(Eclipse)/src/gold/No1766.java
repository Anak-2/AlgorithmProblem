package gold;

import java.util.*;
import java.io.*;

// ������
public class No1766 {
	
	public static PriorityQueue<Integer> queue;
	public static ArrayList<Integer>[] ansList;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
//		������ ��
		int N = Integer.parseInt(st.nextToken());
//		������ ����
		int M = Integer.parseInt(st.nextToken());
//		�� ����� indegree�� ������ �迭
		int[] indegree = new int[N+1];
//		(start node ��ȣ- > ���� node ��ȣ) �� �׷����� ������ ArrayList
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
//		(indegree�� 0�� node ��ȣ -> �̾��� �ִ� node ��ȣ) �� �׷����� ������ ArrayList
		ansList = new ArrayList[N+1];
//		indegree�� 0�� �� ������ ������ ���� �� ���� ����
		queue = new PriorityQueue<>((a,b) -> a-b);
//		���� ������ ����
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
