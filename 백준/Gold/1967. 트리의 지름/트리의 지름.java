
import java.io.*;
import java.util.*;

public class Main {

    static List<Edge>[] adjacent;
    static int N;
    static int answer = 0;

    private static class Edge {

        int num;
        int weight;

        public Edge(int num, int weight){
            this.num = num;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        adjacent = new ArrayList[N+1];

        for(int i = 0; i < N+1; i++){
            adjacent[i] = new ArrayList<>();
        }

        for(int i = 0; i < N-1; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            adjacent[from].add(new Edge(to, weight));
            adjacent[to].add(new Edge(from, weight));
        }

        int nextIdx = bfs(1);
        bfs(nextIdx);
        System.out.println(answer);
    }

    private static int bfs(int start){
        Deque<Integer> deque = new LinkedList<>();
        deque.add(start);
        int[] distance = new int[N+1];
        boolean[] visited = new boolean[N+1];

        while(!deque.isEmpty()){
            int cur = deque.removeFirst();
            visited[cur] = true;

            for(int i = 0; i < adjacent[cur].size(); i++){
                int next = adjacent[cur].get(i).num;
                if(!visited[next]){
                    distance[next] = distance[cur] + adjacent[cur].get(i).weight;
                    deque.add(next);
                }
            }
        }

        int maxIdx = 0;
        for(int i = 1; i < N+1; i++){
            int tmp = answer;
            answer = Math.max(answer, distance[i]);
            if(tmp != answer){
                maxIdx = i;
            }
        }
        return maxIdx;
    }
}
