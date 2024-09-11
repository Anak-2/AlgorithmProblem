
import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long MIN = Long.parseLong(st.nextToken());
        long MAX = Long.parseLong(st.nextToken());

        boolean[] arr = new boolean[(int) (MAX - MIN + 1)];
        int ans = 0;

        for(long i = 2; i*i <= MAX; i++) {
            long pow = i*i;
            long startIdx = MIN / pow;
            if(MIN % pow != 0) {
                startIdx++;
            }

            for(long j = startIdx; j * pow <= MAX; j++) {
                arr[(int) ((j*pow) - MIN)] = true;
            }
        }

        for(int i = 0; i <= MAX-MIN; i++) {
            if(!arr[i]) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
