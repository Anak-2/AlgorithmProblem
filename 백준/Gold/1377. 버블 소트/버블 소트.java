

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][2];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int input = Integer.parseInt(st.nextToken());
            arr[i][0] = input;
            arr[i][1] = i;
        }

        Arrays.sort(arr, (int[] a, int[] b) -> {
            return a[0] - b[0];
        });

        int maxDiff = 0;

        for(int i = 0; i < N; i++){
            maxDiff = Math.max(maxDiff, arr[i][1] - i + 1);
        }

        System.out.println(maxDiff);
    }
}
