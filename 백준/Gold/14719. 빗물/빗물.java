
import java.util.*;

public class Main {

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int H = sc.nextInt();
       int W = sc.nextInt();
       int[] arr = new int[W+1];

       int topH = 0;
       int topIdx = 0;

       for(int i = 1; i < W+1; i++){
           int height = sc.nextInt();
           arr[i] = height;
           if(topH <= height){
               topH = height;
               topIdx = i;
           }
       }

        // 나보다 더 높거나 같은 기둥 만나면 정답에 추가
        int answer = 0;
       // 더 높은 기둥 만나기 전까지 임시 저장
       int temp = 0;
       int curH = 0;
       for(int i = 1; i <= topIdx; i++){
           if(arr[i] >= curH){
               curH = arr[i];
               answer += temp;
               temp = 0;
           }else{
               temp += curH - arr[i];
           }
       }

       temp = 0;
       curH = 0;
       for(int i = W; i >= topIdx; i--){
           if(arr[i] >= curH){
               curH = arr[i];
               answer += temp;
               temp = 0;
           }else{
               temp += curH - arr[i];
           }
       }
        System.out.println(answer);
    }
}
