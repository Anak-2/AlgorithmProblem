
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
        long[] S = new long[N];
        st = new StringTokenizer(br.readLine());
        long answer = 0;
        long[] restArr = new long[M];
        for(int i = 0; i < N; i++){
            S[i] = Long.parseLong(st.nextToken());
            if(i != 0){
                S[i] += S[i-1];
            }
            S[i] = S[i] % M;
            if(S[i] == 0){
                answer++;
            }
            restArr[(int) S[i]]++;
        }

        for(int i = 0; i < M; i++){
            answer += (restArr[i] * (restArr[i] - 1)) / 2;
        }

        System.out.println(answer);
    }
}
