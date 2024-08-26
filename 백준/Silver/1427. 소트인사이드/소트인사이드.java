

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        char[] c = String.valueOf(N).toCharArray();

        int[] intArr = new int[N.length()];
        for(int i = 0; i < N.length(); i++){
            intArr[i] = N.charAt(i) - '0';
        }
        for(int i = 0; i < N.length(); i++){
            int max = intArr[i];
            int maxIdx = i;
            for(int j = i+1; j < N.length(); j++){
                if(max < intArr[j]){
                    max = intArr[j];
                    maxIdx = j;
                }
            }
            int temp = intArr[i];
            intArr[i] = max;
            intArr[maxIdx] = temp;
        }
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < N.length(); i++){
            sb.append(intArr[i]);
        }
        String s = sb.toString();
        System.out.println(s);
    }
}
