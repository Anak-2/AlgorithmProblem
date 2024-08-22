

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = 1;
        int curVal;
        int answer = 0;

        while(left < N-1) {
            curVal = arr[left] + arr[right];
            // 목표와 같다
            if (curVal == M) {
                answer++;
                left++;
                right = left + 1;
            }
            // 목표보다 작다
            else {
                if (right == N - 1) {
                    left++;
                    right = left + 1;
                } else {
                    right++;
                }
            }
        }

        System.out.println(answer);
    }
}
