package shake;

import java.util.*;
import java.io.*;

public class No1 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
//        총 경기 수
        int play = (int) (Math.log(N)/Math.log(2));
//        자신의 탄산 내성보다 낮은 사람들과 경기 수
        int lowerK = (int) (Math.log(K)/Math.log(2));
//        자신보다 탄산 내성이 높은 사람들과 치뤄야하는 경기 수
        int restPlay = play - lowerK;
        int ans = 0;
        ans += lowerK;
        if(restPlay > M){
            ans += M;
        }else{
            ans += restPlay;
        }
        System.out.println(ans);
    }
}
