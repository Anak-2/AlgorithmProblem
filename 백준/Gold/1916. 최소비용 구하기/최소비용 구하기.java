import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a, int[] b) -> {
        return a[1] - b[1];
    });
    private static List<List<int[]>> linkedList = new ArrayList<>();
    private static int[] dijkstra;
    private static boolean[] visited;
    public static final int INF = 100000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken());


        dijkstra = new int[V + 1];
        visited = new boolean[V + 1];
        for (int i = 0; i < V + 1; i++) {
            dijkstra[i] = INF;
            linkedList.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            linkedList.get(start).add(new int[]{end, weight});
        }

        st = new StringTokenizer(br.readLine());
        int startNode = Integer.parseInt(st.nextToken());
        int endNode = Integer.parseInt(st.nextToken());
        dijkstra[startNode] = 0;

        lowestCost(startNode, endNode);
        System.out.println(dijkstra[endNode]);
    }

    private static void lowestCost(int start, int end) {
        pq.add(new int[]{start, 0});
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            if(visited[cur[0]]) continue;
            visited[cur[0]] = true;

            for(int[] bus : linkedList.get(cur[0])) {

                if(dijkstra[bus[0]] > cur[1] + bus[1]) {
                    dijkstra[bus[0]] = dijkstra[cur[0]] + bus[1];
                    pq.add(new int[]{bus[0], dijkstra[bus[0]]});
                }
            }
        }
    }
}
