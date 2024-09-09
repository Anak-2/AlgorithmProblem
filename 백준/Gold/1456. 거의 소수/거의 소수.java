
import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long M = Long.parseLong(st.nextToken());
        long N = Long.parseLong(st.nextToken());

        long[] arr = new long[10000001];
        arr[1] = 1;
        int ans = 0;

        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (arr[i] == 0) {
                int cur = 2;
                while (i * cur <= Math.sqrt(N)) {
                    arr[i * cur] = 1;
                    cur++;
                }
            }
        }

        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (arr[i] == 0) {
                int j = 2;
                while (Math.pow(i, j) <= N) {
                    if (Math.pow(i, j) >= M) {
                        ans++;
                    }
                    j++;
                }
            }
        }

        System.out.println(ans);
    }
}
