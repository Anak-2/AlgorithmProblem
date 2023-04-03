package gold;

import java.util.*;
import java.io.*;

//부분합 다른 풀이, DP를 이용해 길이를 1씩 증가시키며 부분합 구하기
//위 풀이도 시간초과가 났기 때문에 인터넷을 참고하여 투포인터로 풀었다
//아... 부분합이 S인 것이 아닌 S이상인 것을 지금까지 문제 잘못보고 풀었다 ㅠ
public class No1806_2 {
    static int N;
    static int S;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
//      N짜리 수열
        N = Integer.parseInt(st.nextToken());
//      합이 S 이상
        S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] nums = new int[N+1];
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int ans = Integer.MAX_VALUE/2;
        int left = 0, right = 0;
        int sum = 0;
        while(left <= N && right <= N) {
            if(sum >= S && ans > right - left) ans = right - left;

            if(sum < S) sum += nums[right++];
            else sum -= nums[left++];
        }
        ans = (ans == Integer.MAX_VALUE/2) ? 0 : ans;
        System.out.println(ans);
    }
}
