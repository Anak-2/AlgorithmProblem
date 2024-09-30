import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a, int[] b) -> {
        return a[1] - b[1];
    });
    private static List<List<int[]>> linkedList = new ArrayList<>();
    private static PriorityQueue<Integer>[] dist;
    private static boolean[] visited;
    public static final int INF = 100000000;
    private static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dist = new PriorityQueue[V + 1];

        visited = new boolean[V + 1];
        for (int i = 0; i < V + 1; i++) {
            dist[i] = new PriorityQueue<>(K, (a, b) -> b-a);
            linkedList.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            linkedList.get(start).add(new int[]{end, weight});
        }

        dist[1].add(0);
        kCost();
        for(int i = 1; i <= V; i++) {
            if(dist[i].size() == K) {
                System.out.println(dist[i].peek());
            }else {
                System.out.println(-1);
            }
        }
    }

    private static void kCost() {
        pq.add(new int[]{1, 0});
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            for(int[] edge : linkedList.get(cur[0])) {
                if(dist[edge[0]].size() < K) {
                    dist[edge[0]].add(cur[1] + edge[1]);
                    pq.add(new int[]{edge[0], cur[1] + edge[1]});
                }else if(dist[edge[0]].peek() > cur[1] + edge[1]){
                    dist[edge[0]].poll();
                    dist[edge[0]].add(cur[1] + edge[1]);
                    pq.add(new int[]{edge[0], cur[1] + edge[1]});
                }
            }
        }
    }
}
