public class Maximum_Average_Subarray_1_643 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        double maxAverage = solution.findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4);
        System.out.println(maxAverage);
    }

    static class Solution {
        public double findMaxAverage(int[] nums, int k) {
            double sum = 0;
            for(int i = 0; i < k; i++) {
                sum += nums[i];
            }

            double prev = sum;
            for(int i = k; i < nums.length; i++) {
                prev -= nums[i - k];
                prev += nums[i];
                sum = Math.max(prev, sum);
            }
            return (double) (Math.round(sum * Math.pow(10, 5)) / k) / Math.pow(10, 5);
        }
    }
}
