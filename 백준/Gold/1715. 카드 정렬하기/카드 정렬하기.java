

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

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(Integer.parseInt(st.nextToken()));
        }

        int ans = 0;
        while(pq.size() != 1){
            int a = pq.poll();
            int b = pq.poll();

            int c = a+b;
            ans += c;
            pq.add(c);
        }

        System.out.println(ans);
    }
}
