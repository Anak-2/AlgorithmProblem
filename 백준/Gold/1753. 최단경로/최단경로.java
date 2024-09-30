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
        int E = Integer.parseInt(st.nextToken());

        dijkstra = new int[V + 1];
        visited = new boolean[V + 1];
        for (int i = 0; i < V + 1; i++) {
            dijkstra[i] = INF;
            linkedList.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        int startNode = Integer.parseInt(st.nextToken());
        dijkstra[startNode] = 0;

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            linkedList.get(start).add(new int[]{end, weight});
        }

        pq.add(new int[]{startNode, 0}); // 도착 지점, 가는데 드는 비용

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int target = cur[0];
            int weight = cur[1];
            if (visited[target]) continue;
            visited[target] = true;

            // 기존 값 갱신
            for (int[] a : linkedList.get(target)) {
                if (dijkstra[a[0]] > dijkstra[target] + a[1]) {
                    dijkstra[a[0]] = dijkstra[target] + a[1];
                    pq.add(new int[]{a[0], dijkstra[a[0]]});
                }
            }
        }

        for (int i = 1; i < V + 1; i++) {
            if (dijkstra[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(dijkstra[i]);
            }
        }
    }
}
