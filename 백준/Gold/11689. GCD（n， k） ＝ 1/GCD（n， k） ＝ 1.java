

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long temp = n;
        for (long i=2; i<=Math.sqrt(n); i++) {
            if (n%i == 0) { // n이 3을 약수로가짐
                temp = temp - (temp/i); // 3의 배수 없앰
                while (n%i == 0) {
                    n /= i; // 모든 3의 배수
                }
            }
        }
        if (n > 1) {
            temp = temp - (temp/n);
        }
        System.out.println(temp);
    }
}
