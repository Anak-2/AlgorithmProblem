import java.util.Arrays;

public class Max_Number_of_KSum_Pairs_1679 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.maxOperations(new int[]{1,2,3,4}, 5);
        System.out.println(i);
    }

    static class Solution {
        public int maxOperations(int[] nums, int k) {
            int answer = 0;

            Arrays.sort(nums);

            int left = 0, right = nums.length - 1;

            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum < k) {
                    left++;
                } else if (sum > k) {
                    right--;
                } else if (sum == k) {
                    answer++;
                    left++;
                    right--;
                }
            }

            return answer;
        }
    }
}
