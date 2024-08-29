
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] arr, tmp;
    static int N;
    static long answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        tmp = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N+1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(1,N);
        System.out.println(answer);
    }

    private static void mergeSort(int s, int e){
        if(s >= e) return;

        int l = s;
        int m = (s+e)/2;
        int r = m+1;

        mergeSort(s,m);
        mergeSort(m+1,e);

        int idx = s;

        while(l <= m && r <= e){
            if(arr[l] <= arr[r]){
                tmp[idx] = arr[l];
                l++;
                idx++;
            } else{
                tmp[idx] = arr[r];
                answer = answer + r - idx;
                r++;
                idx++;
            }
        }

        if(l <= m){
            while(l <= m){
                tmp[idx] = arr[l];
                l++;
                idx++;
            }
        }else{
            while(r <= e){
                tmp[idx] = arr[r];
                r++;
                idx++;
            }
        }

        for(int i = s; i <= e; i++){
            arr[i] = tmp[i];
        }
    }
}
