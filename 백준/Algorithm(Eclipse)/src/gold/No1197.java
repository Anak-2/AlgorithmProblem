package gold;

import java.util.*;
import java.io.*;

public class No1197 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(token.nextToken());
		int E = Integer.parseInt(token.nextToken());

		int[] visited = new int[V + 1];
		List<int[]>[] edge = new ArrayList[V+1];
		for(int i = 1; i < V+1; i++) {
			edge[i] = new ArrayList<int[]>();
		}

		for (int i = 0; i < E; i++) {
//			token = br.readLine().split(" ");
//			edge[Integer.parseInt(token[0])][Integer.parseInt(token[1])] = Integer.parseInt(token[2]);
//			edge[Integer.parseInt(token[1])][Integer.parseInt(token[0])] = Integer.parseInt(token[2]);
			token = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(token.nextToken());
			int e = Integer.parseInt(token.nextToken());
			int w = Integer.parseInt(token.nextToken());
			edge[s].add(new int[] {e, w});
			edge[e].add(new int[] {s, w});
		}

		int ans = 0;
//		�� ��忡�� �ٸ� ���� ���� ��� �� �ּҰ��� ��θ� ���� �鸮�� ���� PriorityQueue(MinHeap) �̿�
//		���� ���� [���� ��� ��ȣ , ���� ���� ����� edge�� ����ġ] �̰� �� ��° ���� ���� ����� ����
		PriorityQueue<int[]> pQueue = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
		pQueue.add(new int[] { 1, 0 });
		while (!pQueue.isEmpty()) {
			int[] curNode = pQueue.poll();
			if(visited[curNode[0]] == 1) continue;
			visited[curNode[0]] = 1;
			ans += curNode[1];
//			System.out.println("current node: " + curNode[0]);
			for(int i = 0; i < edge[curNode[0]].size(); i++) {
				int[] nextNode = edge[curNode[0]].get(i);
				if(visited[nextNode[0]] != 1) {					
					pQueue.add(nextNode);
				}
			}
		}

		System.out.println(ans);
	}

}
