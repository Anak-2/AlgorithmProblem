package prefix_sum;

public class Find_Pivot_Index {
    class Solution {
        public int pivotIndex(int[] nums) {
            int right = 0;
            int numLen = nums.length;
            if(numLen == 0) return 0;

            for(int i = 1; i < numLen; i++) {
                right += nums[i];
            }

            int left = 0;
            int leftIdx = 0;
            if(left == right) return leftIdx;

            for(int i = 1; i < numLen; i++) {
                left += nums[i-1];
                right -= nums[i];
                leftIdx++;
                if(left == right) {
                    return leftIdx;
                }
            }

            return -1;
        }
    }
}
