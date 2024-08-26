

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] intArr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            intArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(intArr);

        int[] accum = new int[N];
        int[] sum = new int[1];
        accum[0] = intArr[0];
        for(int i = 1; i < N; i++){
            accum[i] = accum[i-1] + intArr[i];
        }

        Arrays.stream(accum).forEach(v -> {
            sum[0] += v;
        });

        System.out.println(sum[0]);
    }
}
