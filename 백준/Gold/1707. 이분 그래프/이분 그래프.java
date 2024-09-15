

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<Integer>[] adjacentList;
    static int[] visited;

    public static void main(String[] args) throws IOException {

       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());

       int K = Integer.parseInt(st.nextToken());

       for(int i = 0; i < K; i++) {
           st = new StringTokenizer(br.readLine());
           int V = Integer.parseInt(st.nextToken());
           int E = Integer.parseInt(st.nextToken());
           adjacentList = new List[V+1];

           for(int j = 0; j <= V; j++) {
               adjacentList[j] = new LinkedList<>();
           }

           visited = new int[V+1];
           Arrays.fill(visited, -1);

           for(int j = 0; j < E; j++) {
               st = new StringTokenizer(br.readLine());
               int from = Integer.parseInt(st.nextToken());
               int to = Integer.parseInt(st.nextToken());
               adjacentList[from].add(to);
               adjacentList[to].add(from);
           }

           boolean isEven = true;

           for(int j = 1; j <= V; j++) {
               if(visited[j] == -1){
                   visited[j] = 0;
                   if(!binaryGraph(j, 1)) {
                       isEven = false;
                       break;
                   }
               }
           }

           if(isEven) {
               System.out.println("YES");
           }else {
               System.out.println("NO");
           }
       }
    }

    private static boolean binaryGraph(int start, int depth) {
        for(int next : adjacentList[start]) {
            // 아직 안 들린 곳
            if(visited[next] == -1) {
                visited[next] = depth % 2;

                boolean result = binaryGraph(next,depth+1);
                if(!result) {
                    return false;
                }
            }
            // 이미 들렸던 곳인데 출발하는 곳이랑 같은 소속이면 NO
            else if(visited[start] == visited[next]){
                return false;
            }
        }
        return true;
    }
}