

import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = new int[]{-1,1,0,0};
    static int[] dy = new int[]{0,0,-1,1};
    static int[][] miro;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        miro = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for(int j = 0; j < M; j++){
                miro[i][j] = Integer.parseInt(line.substring(j, j+1));
            }
        }

        bfs(new int[] {0,0});
        System.out.println(miro[N-1][M-1]);
    }

    private static void bfs(int[] start){
        Deque<int[]> deque = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        deque.add(start);
        visited[start[0]][start[1]] = true;

        while(!deque.isEmpty()){
            int[] cur = deque.removeFirst();

            for(int i = 0; i < 4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx >= 0 && ny >= 0 && nx < N && ny < M){
                    if(miro[nx][ny] == 1 && !visited[nx][ny]){
                        miro[nx][ny] = miro[cur[0]][cur[1]] + 1;
                        visited[nx][ny] = true;
                        deque.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
