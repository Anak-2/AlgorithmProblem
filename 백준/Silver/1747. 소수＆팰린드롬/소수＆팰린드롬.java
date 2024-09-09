
import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[10000001];
        arr[0] = 1;
        arr[1] = 1;

        for(int i = 2; i <= Math.sqrt(10000000); i++) {
            if(arr[i] == 0) {
                for(int j = i+i; j <= 10000000; j = j+i) {
                    arr[j] = 1;
                }
            }
        }

        for(int i = N; i <= 10000000; i++) {
            if(arr[i] == 0) {
                // 팰린드롬 검사
                String s = String.valueOf(i);
                char[] charArr = s.toCharArray();
                boolean flag = true;
                for(int j = charArr.length - 1; j >= 0; j--) {
                    if(charArr[(charArr.length - 1) - j] != charArr[j]) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}
