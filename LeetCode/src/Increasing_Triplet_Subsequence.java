import java.util.Arrays;

public class Increasing_Triplet_Subsequence {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.increasingTriplet(new int[]{20,100,10,12,5,13}));
    }

    static class Solution {
        public boolean increasingTriplet(int[] nums) {
            int first = Integer.MAX_VALUE;
            int second = Integer.MAX_VALUE;

            for (int num : nums) {
                if (num <= first) {
                    first = num; // Smallest number so far
                } else if (num <= second) {
                    second = num; // Second smallest number so far
                } else {
                    return true; // Found a number greater than both -> valid triplet
                }
            }

            return false;
        }
    }
}
