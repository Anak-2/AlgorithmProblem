

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] indegree;
    static List<Integer>[] adjacentList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N, M;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        indegree = new int[N+1];
        adjacentList = new List[N+1];
        Deque<Integer> dq = new LinkedList<>();
        for(int i = 1; i < N+1; i++) {
            adjacentList[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjacentList[from].add(to);
            indegree[to]++;
        }

        StringBuffer sb = new StringBuffer();

        for(int i = 1; i < N+1; i++){
            if(indegree[i] == 0){
                dq.add(i);
            }
        }
        while(!dq.isEmpty()) {
            int cur = dq.poll();
            sb.append(cur+" ");
            for(int i : adjacentList[cur]) {
                indegree[i]--;
                if(indegree[i] == 0) {
                    dq.add(i);
                }
            }
        }

        System.out.println(sb);
    }
}