import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int M;
    private static int[] parents;
    private static PriorityQueue<Edge> pq = new PriorityQueue<>((Edge a, Edge b) -> {
        return a.weight - b.weight;
    });
    private static int totalWeight = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parents = new int[N+1];

        for(int i = 0; i <= N; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            Edge edge = new Edge(start, end, weight);
            pq.add(edge);
        }

        int connectedNode = 1;

        while(connectedNode < N) {
            Edge cur = pq.poll();

            if(find(cur.start) != find(cur.end)) {
                union(cur.start, cur.end);
                totalWeight += cur.weight;
                connectedNode++;
            }
        }

        System.out.println(totalWeight);
    }

    private static class Edge {
        int start;
        int end;
        int weight;

        public Edge(final int start, final int end, final int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    private static int find(int node) {
        if(parents[node] == node) {
            return node;
        }
        return parents[node] = find(parents[node]);
    }

    private static void union(int node1, int node2) {
        int a = find(node1);
        int b = find(node2);
        if(a != b) {
            parents[a] = b;
        }
    }
}
