package gold;

import java.util.*;
import java.io.*;

public class No2212 {
	
    public static void main(String []args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        Integer[] arr = set.toArray(new Integer[0]);
        Arrays.sort(arr);
        int answer = 0;
        Integer[] diff = new Integer[arr.length-1];
        for(int i = 0; i < arr.length - 1; i++) {
           diff[i] = arr[i+1] - arr[i];
        }
        Arrays.sort(diff, Comparator.reverseOrder());
        for(int i = M - 1; i < diff.length; i++) {
        	answer += diff[i];
        }
        System.out.println(answer);
    }
}
