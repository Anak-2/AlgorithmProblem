

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        for(int i = 2; i < 10; i++){
            if(isPrim(i)){
                dfs(i);
            }
        }

        for(int e : pq){
            System.out.println(e);
        }
    }

    private static void dfs(int start){
        String curStr = String.valueOf(start);
        // N자리 됐으면 끝
        if(curStr.length() == N){
            pq.add(Integer.parseInt(curStr));
            return;
        }

        for(int i = 0; i < 10; i++){
            String appendedStr = curStr + String.valueOf(i);
            int curInt = Integer.parseInt(appendedStr);
            if(isPrim(curInt)){
                dfs(curInt);
            }
        }
    }

    private static boolean isPrim(int num){
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
