import java.util.Arrays;

public class Product_of_Array_Except_Self {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.productExceptSelf(new int[]{-1,1,0,-3,3})));
    }

    static class Solution {
        public int[] productExceptSelf(int[] nums) {
            int[] answer = new int[nums.length];
            int zeroCnt = 0;
            int totalProduct = 1;
            for(int i : nums) {
                if(i == 0) {
                    zeroCnt++;
                    continue;
                }
                totalProduct *= i;
            }

            if(zeroCnt >= 2) return answer;

            for(int i = 0; i < nums.length; i++) {
                if(zeroCnt == 0) {
                    answer[i] = totalProduct / nums[i];
                } else if(zeroCnt == 1) {
                    if(nums[i] != 0) {
                        answer[i] = 0;
                    } else {
                        answer[i] = totalProduct;
                    }
                }
            }

            return answer;
        }
    }
}
