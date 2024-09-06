
import org.w3c.dom.ls.LSOutput;

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

       int[][] conference = new int[N][2];

       for(int i = 0; i < N; i++) {
           st = new StringTokenizer(br.readLine());
           int start = Integer.parseInt(st.nextToken());
           int end = Integer.parseInt(st.nextToken());

           conference[i][0] = start;
           conference[i][1] = end;
       }

       Arrays.sort(conference, (int[] a, int[] b) -> {
           if(a[1] == b[1]) {
               return a[0] - b[0];
           }
           return a[1] - b[1];
       });

       int proceed = 0;

       int curIdx = 0;
       int endTime = 0;
       for(int i = 0; i < N; i++) {

               if(conference[curIdx][0] >= endTime) {
                   endTime = conference[curIdx][1];
                   proceed++;
               }
               curIdx++;
       }
        System.out.println(proceed);
    }
}
