
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

        st = new StringTokenizer(br.readLine());
        int findSize = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < findSize; i++){
            int target = Integer.parseInt(st.nextToken());
            if(binSearchLoop(target)) {
//            if(binSearchRecursive(target,0,N-1)) {
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }
    }

    private static boolean binSearchRecursive(int target, int left, int right) {
        if(left > right) return false;
        int mid = (left + right) / 2;
        if(target == intArr[mid]){
            return true;
        }else if(target > intArr[mid]){
            return binSearchRecursive(target, mid+1, right);
        }else{
            return binSearchRecursive(target, left, mid-1);
        }
    }

    private static boolean binSearchLoop(int target) {
        int left = 0;
        int right = intArr.length - 1;
        int mid = (left + right) / 2;

        while(left <= right) {
            if(target == intArr[mid]) {
                return true;
            } else if(target > intArr[mid]) {
                left = mid + 1;
                mid = (left + right) / 2;
            } else {
                right = mid - 1;
                mid = (left + right) / 2;
            }
        }

        return false;
    }
}
