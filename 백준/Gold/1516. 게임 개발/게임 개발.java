
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] indegree;
    static int[] times;
    static int[] answer;
    static List<Integer>[] adjacentList;
    static PriorityQueue<Node> pq = new PriorityQueue<>((Node n1, Node n2) -> {
        return n1.time - n2.time;
    });

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        indegree = new int[N+1];
        times = new int[N+1];
        answer = new int[N+1];
        adjacentList = new List[N+1];
        for(int i = 0; i < N+1; i++) {
            adjacentList[i] = new ArrayList<>();
        }

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int cur = Integer.parseInt(st.nextToken());
            times[i] = cur;
            cur = Integer.parseInt(st.nextToken());
            while(cur != -1) {
                adjacentList[cur].add(i);
                indegree[i]++;
                cur = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i <= N; i++) {
            if(indegree[i] == 0){
                pq.add(new Node(i, times[i]));
            }
        }

        while(!pq.isEmpty()) {
            Node curNode = pq.poll();
            for(int next : adjacentList[curNode.num]) {
                indegree[next]--;
                answer[next] = Math.max(answer[next], answer[curNode.num] + times[curNode.num]);
                if(indegree[next] == 0) {
                    pq.add(new Node(next, times[next]));
                }
            }
        }

        for(int i = 1; i <= N; i++) {
            System.out.println(answer[i] + times[i]);
        }
    }

    static class Node {
        int num;
        int time;

        public Node(int num, int time) {
            this.num = num;
            this.time = time;
        }
    }
}