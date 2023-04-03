package gold;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

// 미확인 도착지
public class No9370_2 {
    static class Node implements Comparable<Node>{
        int end, weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }

    static int n;
    static int m;
    static int t;
    static int s;
    static int g;
    static int h;
    static int MAX = Integer.MAX_VALUE/2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
//            노드 개수
            n = Integer.parseInt(st.nextToken());
//            엣지 개수
            m = Integer.parseInt(st.nextToken());
//            목적지 후보 개수
            t = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
//            출발점
            s = Integer.parseInt(st.nextToken());
//            지나간 노드1
            g = Integer.parseInt(st.nextToken());
//            지나간 노드2
            h = Integer.parseInt(st.nextToken());

//            엣지들 담을 인접리스트
            ArrayList<Node>[] arrList = new ArrayList[n+1];
            for(int j = 0; j < n+1; j++){
                arrList[j] = new ArrayList<>();
            }
            for(int j = 0; j < m; j++){
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

//                *** 지나간 노드(g, h)를 잇는 엣지는 가중치를 (2배 - 1) 해서 홀수로 만들고
//                *** 나머지 엣지들은 2배해서 짝수로 만들면
//                *** 최종 결과에서 최단 거리가 짝수인지, 홀수인지에 따라 지나간 노드를 포함하는 최단 거리인지 알 수 있다!
//                *** 만약 지나간 노드의 가중치가 2 다른 엣지의 가중치가 2 일 때 값 변경 후 3, 4가 되서 결과가 달라지나 생각해 볼 수 있지만
//                *** 이건 가중치 4가 아닌 3을 지나게 만드므로 오히려 지나간 노드를 반드시 포함하는 최단 거리를 구하므로 좋다!!
                if((start == g && end == h) || (start == h && end == g)){
                    arrList[start].add(new Node(end, weight*2 - 1));
                    arrList[end].add(new Node(start, weight*2 - 1));
                }else{
                    arrList[start].add(new Node(end, weight*2));
                    arrList[end].add(new Node(start, weight*2));
                }
            }
            int[] dist = dijkstra(arrList);
            ArrayList<Integer> ans = new ArrayList<>();
            for(int j = 0; j < t; j++){
                st = new StringTokenizer(br.readLine());
                int target = Integer.parseInt(st.nextToken());
                if(dist[target] != MAX && dist[target] % 2 == 1){
                    ans.add(target);
                }
            }
            Collections.sort(ans);
            for(int element : ans){
                System.out.print(element+" ");
            }
            System.out.println();
        }
    }

    public static int[] dijkstra(ArrayList<Node>[] arrList){
//        시작점 부터 다른 노드 까지의 거리 정보를 저장할 노드
        int[] dist = new int[n+1];
        Arrays.fill(dist, MAX);
        dist[s] = 0;
//        방문한 노드인지 표시할 visited
        boolean[] visited = new boolean[n+1];
//        방문할 노드들 저장할 pq
        PriorityQueue<Node> stack = new PriorityQueue<>();
        stack.add(new Node(s,0));
        while(!stack.isEmpty()){
            Node cur = stack.poll();
//            이미 방문한 노드면 스킵
            if(visited[cur.end]) continue;
            visited[cur.end] = true;
            for(Node node : arrList[cur.end]){
                if(!visited[node.end] && dist[node.end] > dist[cur.end] + node.weight) {
                    dist[node.end] = dist[cur.end] + node.weight;
                    stack.add(new Node(node.end, dist[node.end]));
                }
            }
        }
        return dist;
    }
}
