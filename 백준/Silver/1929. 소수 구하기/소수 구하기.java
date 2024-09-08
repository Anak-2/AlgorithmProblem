

import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        arr[1] = 1;

        for(int i = 2; i <= Math.sqrt(N); i++) {
            if(arr[i] == 0) {
                int cur = 2;
                while(i * cur <= N) {
                    arr[i * cur] = 1;
                    cur++;
                }
            }
        }

        for(int i = M; i <= N; i++) {
            if(arr[i] == 0) {
                System.out.println(i);
            }
        }
    }
}
