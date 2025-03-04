import java.util.ArrayList;
import java.util.List;

public class Max_Consecutive_Ones_3_1004 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3);
        System.out.println(i);
    }

    static class Solution {
        public int longestOnes(int[] nums, int k) {
            int leftZero = 0;
            int consecutive = 0;
            int answer = 0;
            int left = 0;
            for(int i = 0 ; i < nums.length ; i++){
                if(nums[i] == 0){
                    if(leftZero < k) {
                        leftZero++;
                        consecutive++;
                    } else {
                        answer = Math.max(answer, consecutive);
                        while(nums[left] != 0){
                            left++;
                            consecutive--;
                        }
                        left++;
                    }
                } else {
                    consecutive++;
                }
            }
            return Math.max(answer, consecutive);
        }
    }
}
