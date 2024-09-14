

import java.io.IOException;
import java.util.*;

public class Main {

    static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int N, M, K, X;
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        X = sc.nextInt();

        List<Integer>[] city = new List[N+1];

        for(int i = 0; i < N+1; i++) {
            city[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            city[from].add(to);
        }

        boolean[] visited = new boolean[N+1];
        Deque<int[]> dq = new LinkedList<>();
        dq.add(new int[]{X, 0});

        while(!dq.isEmpty()) {
            int[] cur = dq.removeFirst();
            if(visited[cur[0]]){
                continue;
            }
            visited[cur[0]] = true;

            if(cur[1] == K) {
                answer.add(cur[0]);
                continue;
            }

            for(int i = 0; i < city[cur[0]].size(); i++) {
                int next = city[cur[0]].get(i);
                if(!visited[next]) {
                    dq.addLast(new int[]{next, cur[1]+1});
                }
            }
        }

        if(answer.isEmpty()) {
            System.out.println(-1);
        }else{
            Collections.sort(answer);
            for(int i : answer) {
                System.out.println(i);
            }
        }
    }
}
