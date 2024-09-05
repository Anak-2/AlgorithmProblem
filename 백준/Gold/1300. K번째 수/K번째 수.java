

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 정수 배열 크기
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());

        long start = 1;
        long end = K;
        long ans = 0;

        while(start <= end) {
            long middle = (start + end) / 2;

            long cnt = 0;
            for(int i = 1; i <= N; i++){
                cnt += Math.min(middle / i, N);
            }

            if(cnt < K) {
                start = middle + 1;
            }else {
                ans = middle;
                end = middle - 1;
            }
        }

        System.out.println(ans);
    }
}
