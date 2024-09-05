
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
        K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int ans = 0;
        int sum = 0;
        int idx = N-1;

        while(sum != K) {
            if(sum + arr[idx] <= K) {
                sum += arr[idx];
                ans++;
            }else {
                idx--;
            }
        }

        System.out.println(ans);
    }
}
