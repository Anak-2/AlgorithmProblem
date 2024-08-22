

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int answer = 0;

        for(int i = 0; i < N; i++){
            if(twoPointer(arr, i)){
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static boolean twoPointer(int[] arr, int targetIdx){
        int target = arr[targetIdx];
        int left = 0;
        int right = arr.length - 1;
        int sum = arr[left] + arr[right];

        while(left < right){
            if(sum == target){
                if(left != targetIdx && right != targetIdx){
                    return true;
                }else if(left == targetIdx){
                    left++;
                }else {
                    right--;
                }
            }else if(sum < target){
                left++;
            }else {
                right--;
            }
            sum = arr[left] + arr[right];
        }

        return false;
    }

    private static <V> void ifNoKeyPutZero(Map<V, Integer> nums, V key){
        nums.put(key, nums.getOrDefault(key, 0) + 1);
    }
}
