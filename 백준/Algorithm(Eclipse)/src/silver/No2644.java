package silver;

import java.util.*;
import java.io.*;
public class No2644 {

	public static void main(String []args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //  사람 수
        int n = Integer.parseInt(st.nextToken());
        // graph 생성 1부터 시작
        ArrayList<Integer>[] graph = new ArrayList[n+1];
        // graph 초기화
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        // start, end 노드
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        // 엣지 개수
        int edgeNum = Integer.parseInt(br.readLine());
        // 그래프에 엣지 넣기
        for(int i = 0; i < edgeNum; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());            
            graph[n1].add(n2);
            graph[n2].add(n1);
        }
        
        int[] visitNodes = new int[n+1];
        ArrayList<Integer> queue = new ArrayList<Integer>();
        for(int i = 0; i < visitNodes.length; i++) {
        	visitNodes[i] = -1;
        }
        queue.add(start);
        visitNodes[start] = 0;
        int relation = 0;
        while(!queue.isEmpty()) {
        	int curNode = queue.remove(0);
        	if(curNode == end) break;
			int prevRel = visitNodes[curNode];
			int nextNode = -1;
			for (int i = 0; i < graph[curNode].size(); i++) {
				nextNode = graph[curNode].get(i);
//				방문했던 노드라면 스킵
				if(visitNodes[nextNode] != -1) continue;
				queue.add(graph[curNode].get(i));
				visitNodes[nextNode] = prevRel+1;
			}
        }
        System.out.println(visitNodes[end]);
    }

}
