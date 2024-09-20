
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int Q = Integer.parseInt(st.nextToken());

        long[] F = new long[21];
        long[] S = new long[21];

        boolean[] visited = new boolean[21];
        F[0] = 1;
        for(int i = 1; i <= N; i++) {
            F[i] = F[i-1] * i;
        }

        if(Q == 1) {
            long K = Long.parseLong(st.nextToken());
            // n 번째 자리 수 구하기
            for(int i = 1; i <= N; i++) {
                // n 번째 자리 가능한 숫자들 검사
                for(int j = 1, cnt = 1; j <= N; j++){
                    if(visited[j]){
                        continue;
                    }
                    if(K <= cnt * F[N-i]) {
                        K -= ((cnt - 1) * F[N-i]);
                        S[i]= j;
                        visited[j] = true;
                        break;
                    }
                    cnt++;
                }
            }
            for(int i = 1; i <= N; i++) {
                System.out.print(S[i]+" ");
            }
        }else if(Q == 2) {
            long K = 1;
            for(int i = 1; i <= N; i++) {
                S[i] = Integer.parseInt(st.nextToken());
                long cnt = 0;
                for(int j = 1; j < S[i]; j++) {
                    if(visited[j] == false) {
                        cnt++;
                    }
                }
                K += (cnt * F[N-i]);
                visited[(int) S[i]] = true;
            }
            System.out.println(K);
        }
    }
}

