package hash_map_set;

public class Longest_Subarray_of_1s_After_Deleting_One_Element {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestSubarray(new int[]{1,1,1}));
    }

    static class Solution {
        public int longestSubarray(int[] nums) {
            int zeroBefore = 0;
            int zeroAfter = 0;
            int longest = 0;
            boolean zeroFound = false;

            for(int num : nums) {
                if(num == 0) {
                    longest = Math.max(zeroBefore + zeroAfter, longest);
                    zeroBefore = zeroAfter;
                    zeroAfter = 0;
                    zeroFound = true;
                } else {
                    zeroAfter++;
                }
            }
            longest = Math.max(zeroBefore + zeroAfter, longest);
            if(!zeroFound) return longest - 1;
            return longest;
        }
    }
}
