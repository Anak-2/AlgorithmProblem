
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        StringBuffer sb = new StringBuffer();

        PriorityQueue<Integer> pq = new PriorityQueue<>((Integer a, Integer b) -> {
            if(Math.abs(a) == Math.abs(b)){
                return a > 0 ? 1 : -1;
            }
            return Math.abs(a) - Math.abs(b);
        });


        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            if(n == 0){
                if(pq.isEmpty()){
                    sb.append(0).append("\n");
                }else{
                    int ans = pq.poll();
                    sb.append(ans).append("\n");
                }
            }else{
                pq.add(n);
            }
        }
        System.out.println(sb);
    }
}
