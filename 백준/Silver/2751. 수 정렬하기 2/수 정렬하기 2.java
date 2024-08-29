

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] arr, sorted;
    static long result;
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        sorted = new int[N+1];

        for(int i = 1; i < N+1; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(1,N);
        for(int i = 1; i < N+1; i++){
            System.out.println(arr[i]);
        }
    }

    private static void mergeSort(int s, int e){

        if(s >= e){
            return;
        }

        int l = s;
        int m = (s+e) / 2;
        int r = m+1;
        mergeSort(s,m);
        mergeSort(m+1,e);
        int idx = s; // 채워넣을 idx

        while(l <= m && r <= e){
            if(arr[l] <= arr[r]){
                sorted[idx] = arr[l];
                idx++;
                l++;
            }else{
                sorted[idx] = arr[r];
                idx++;
                r++;
            }
        }

        // 왼쪽 배열이 먼저 모두 정렬된 경우
        if(l > m){
            while(r <= e){
                sorted[idx] = arr[r];
                idx++;
                r++;
            }
        } else {
            while(l <= m){
                sorted[idx] = arr[l];
                idx++;
                l++;
            }
        }

        for(int i = s; i <= e; i++){
            arr[i] = sorted[i];
        }
    }
}
