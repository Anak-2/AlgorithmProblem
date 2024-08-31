

import java.io.*;
import java.util.*;

public class Main {

    private static List<Integer>[] adjacent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        adjacent = new ArrayList[N];

        for(int i = 0; i < N; i++){
            adjacent[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjacent[from].add(to);
            adjacent[to].add(from);
        }

        for(int i = 0; i < N; i++){
            boolean[] visited = new boolean[N];
            if(dfs(0, i, visited)){
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }

    private static boolean dfs(int depth, int start, boolean[] visited){
        if(depth == 5){
            return true;
        }

        if(visited[start]){
            return false;
        }
        visited[start] = true;


        for(int i = 0; i < adjacent[start].size(); i++){
            boolean dfsResult = dfs(depth+1, adjacent[start].get(i), Arrays.copyOf(visited,visited.length));
            if(dfsResult){
                return true;
            }
        }

        return false;
    }
}
