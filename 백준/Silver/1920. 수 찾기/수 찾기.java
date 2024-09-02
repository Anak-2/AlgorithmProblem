

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] intArr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 정수 배열 크기
        N = Integer.parseInt(st.nextToken());
        // 정수 배열
        intArr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            intArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(intArr);
        // 찾는 수 의 크기
        st = new StringTokenizer(br.readLine());
        int findSize = Integer.parseInt(st.nextToken());
        // 찾는 수들
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < findSize; i++){
            int target = Integer.parseInt(st.nextToken());
            if(binSearch(target,0,N-1)){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }

    }

    private static boolean binSearch(int target, int left, int right) {
        if(left > right) return false;
        int mid = (left + right) / 2;
        if(target == intArr[mid]){
            return true;
        }else if(target > intArr[mid]){
            return binSearch(target, mid+1, right);
        }else{
            return binSearch(target, left, mid-1);
        }
    }

}
