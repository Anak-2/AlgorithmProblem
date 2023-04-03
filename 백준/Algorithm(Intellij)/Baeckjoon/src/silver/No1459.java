package silver;

import java.util.*;
import java.io.*;

// 걷기
public class No1459 {
    static long[] target;
    static long W;
    static long S;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        target = new long[2];
        target[0] = Long.parseLong(st.nextToken());
        target[1] = Long.parseLong(st.nextToken());
//      수직 수평 이동 비용
        W = Integer.parseInt(st.nextToken());
//        대각 이동 비용
        S = Integer.parseInt(st.nextToken());

        long ans = 0;
        if(2*W < S){
            ans = (target[0] + target[1]) * W;
        }
        else if(2*W > 2*S){
            if((target[0]+target[1])%2 == 0){
                ans = Math.max(target[0], target[1])*S;
            }else{
                ans = (Math.max(target[0],target[1])-1)*S;
                ans += W;
            }
        }else{
            if(target[0] == target[1]){
                ans = S*target[0];
            }else{
                ans = Math.min(target[0]*S, target[1]*S);
                ans += Math.abs(target[0] - target[1])*W;
            }
        }
        System.out.println(ans);
    }
}
