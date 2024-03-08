package level1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// 자연수 뒤집어 배열로 만들기
public class No12932 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();

        // int 11자리 -> 44바이트
        int[] answer = new int[n.length()];

        for(int i = 0; i < n.length(); i++){
            answer[i] = (n.charAt(n.length()-i-1)) - '0';
        }

        Arrays.stream(answer).asLongStream().forEach(System.out::println);
    }
}
