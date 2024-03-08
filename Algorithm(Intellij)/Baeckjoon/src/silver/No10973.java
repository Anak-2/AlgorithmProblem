package silver;

import java.util.*;
import java.io.*;

public class No10973 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        boolean check = prev_premutation(arr);
        if(!check){
            System.out.println(-1);
        }else{
            for(int i : arr){
                System.out.print(i+" ");
            }
        }
    }

    public static boolean prev_premutation(int[] a){
        int i = a.length - 1;
        while(i > 0 && a[i-1] <= a[i]){
            i--;
        }
        if(i <= 0){
            return false;
        }
        int j = a.length - 1;

        while(a[i-1] <= a[j]){
            j--;
        }

        int temp = a[j];
        a[j] = a[i-1];
        a[i-1] = temp;

        j = a.length - 1;
        while(j > i){
            temp = a[j];
            a[j] = a[i];
            a[i] = temp;
            i++;
            j--;
        }

        return true;
    }
}
