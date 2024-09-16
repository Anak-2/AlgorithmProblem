
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] water = new int[3];
    static boolean[][][] visited;
    static Set<Integer> answer = new HashSet<>();

    public static void main(String[] args) throws IOException {

       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 3; i++) {
            water[i] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[water[0]+1][water[1]+1][water[2]+1];

        Deque<int[]> dq = new LinkedList<>();

        dq.add(new int[]{0,0,water[2]});

        while(!dq.isEmpty()) {
            int[] cur = dq.poll();
            if(checkVisited(cur)) {
                continue;
            }
            visited[cur[0]][cur[1]][cur[2]] = true;
            int isAnswer = getIfAnswer(cur);
            if(isAnswer != -1){
                answer.add(isAnswer);
            }

            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    if(i != j) {
                        int[] next = Arrays.copyOf(cur, cur.length);
                        poor(next, i, j);
                        if(!checkVisited(next)){
                            dq.add(next);
                        }
                    }
                }
            }
        }

        List<Integer> list = new ArrayList<>(answer);
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for(int i : list){
            sb.append(i+" ");
        }
        System.out.println(sb);
    }

    // 물을 from에서 to로 전달하고 현재 물의 양 (cur) 업뎃
    private static void poor(int[] cur, int from, int to) {
        if(cur[to] + cur[from] > water[to]) {
            cur[from] = cur[from] - (water[to] - cur[to]);
            cur[to] = water[to];
        }else {
            cur[to] += cur[from];
            cur[from] = 0;
        }
    }

    private static boolean checkVisited(int[] cur) {
        return visited[cur[0]][cur[1]][cur[2]];
    }

    private static int getIfAnswer(int[] cur) {
        if(cur[0] == 0) {
            return cur[2];
        }
        return -1;
    }
}