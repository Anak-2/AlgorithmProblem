package gold;

import java.util.*;
import java.io.*;

// 다각형의 면적, 신발끈의 공식 (점의 위치를 알 때 면적을 구하는 공식)
public class No2166 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        long[] x = new long[N];
        long[] y = new long[N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        long area = 0;
        for(int i = 0; i < N-1; i++){
            area += x[i]*y[i+1];
            area -= x[i+1]*y[i];
        }
        area += x[N-1]*y[0];
        area -= x[0]*y[N-1];
        area = Math.abs(area);
        System.out.printf("%.1f",1d*area/2);
    }
}
