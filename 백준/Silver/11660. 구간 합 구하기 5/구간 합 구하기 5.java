
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static class Point {
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] accumSum = new int[N][N];
        int[][] table = new int[N][N];

        // table 초기화
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        // accumSum 초기화
        accumSum[0][0] = table[0][0];

        for(int i = 1; i < N; i++){
            accumSum[i][0] = accumSum[i-1][0] + table[i][0];
            accumSum[0][i] = accumSum[0][i-1] + table[0][i];
        }

        for(int i = 1; i < N; i++){
            for(int j = 1; j < N; j++){
                accumSum[i][j] = accumSum[i-1][j] + accumSum[i][j-1] - accumSum[i-1][j-1] + table[i][j];
            }
        }

        // 정답 구하기
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int[] parsedInt = new int[4];
            for(int j = 0; j < 4; j++){
                parsedInt[j] = Integer.parseInt(st.nextToken());
            }
            Point p1 = new Point(parsedInt[0] - 1, parsedInt[1] - 1);
            Point p2 = new Point(parsedInt[2] - 1, parsedInt[3] - 1);

            int answer = accumSum[p2.x][p2.y];
            if(p1.y > 0){
                answer -= accumSum[p2.x][p1.y-1];
            }
            if(p1.x > 0){
                answer -= accumSum[p1.x-1][p2.y];
            }
            if(p1.x > 0 && p1.y > 0){
                answer += accumSum[p1.x-1][p1.y-1];
            }
            System.out.println(answer);
        }
    }
}
