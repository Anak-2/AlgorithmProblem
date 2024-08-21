
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int sum = 1;
        int left = 1;
        int right = 1;
        int answer = 0;
        while(right <= N){
            if(sum < N){
                right++;
                sum += right;
            }else if(sum == N){
                answer++;
                right++;
                sum += right;
            }else{
                sum -= left;
                left++;
            }
        }
        System.out.println(answer);
    }
}
