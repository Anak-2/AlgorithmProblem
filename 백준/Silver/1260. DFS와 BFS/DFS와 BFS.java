
import java.io.*;
import java.util.*;

public class Main {

    private static PriorityQueue<Integer>[] adjacent;
    private static PriorityQueue<Integer>[] copyAdjacent;
    private static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        adjacent = new PriorityQueue[N+1];

        for(int i = 1; i < N+1; i++){
            adjacent[i] = new PriorityQueue<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            adjacent[from].add(to);
            adjacent[to].add(from);
        }

        copyAdjacent = new PriorityQueue[N+1];
        for(int i = 1; i < N+1; i++){
            copyAdjacent[i] = new PriorityQueue<>(adjacent[i]);
        }

        List<Integer> dfsResult = new ArrayList<>();
        dfs(new boolean[N+1], dfsResult, V);

        copyAdjacent = new PriorityQueue[N+1];
        for(int i = 1; i < N+1; i++){
            copyAdjacent[i] = new PriorityQueue<>(adjacent[i]);
        }

        List<Integer> bfsResult = bfs(V);

        StringBuffer sb = new StringBuffer();
        for(int i : dfsResult){
            sb.append(i+" ");
        }
        System.out.println(sb);

        sb = new StringBuffer();
        for(int i : bfsResult){
            sb.append(i+" ");
        }
        System.out.println(sb);
    }

    private static void dfs(boolean[] visited, List<Integer> answer, int start) {
        if(visited[start]){
            return;
        }
        visited[start] = true;
        answer.add(start);

        while(!copyAdjacent[start].isEmpty()){
            dfs(visited, answer, copyAdjacent[start].poll());
        }
    }

    private static List<Integer> bfs(int start){
        List<Integer> returnResult = new ArrayList<>();
        boolean[] visited = new boolean[N+1];
        Deque<Integer> stack = new LinkedList<>();

        visited[start] = true;
        stack.add(start);

        while(!stack.isEmpty()){
            int next = stack.removeFirst();
            returnResult.add(next);
            while(!copyAdjacent[next].isEmpty()){
                int tmp = copyAdjacent[next].poll();
                if(!visited[tmp]){
                    stack.add(tmp);
                    visited[tmp] = true;
                }
            }
        }
        return returnResult;
    }
}
