public class Container_With_Most_Water {
    class Solution {
        public int maxArea(int[] height) {
            int maxWater = 0;
            int left = 0;
            int right = height.length - 1;
            while(left < right) {
                maxWater = Math.max(getWater(height[left], height[right], right - left), maxWater);
                if(height[left] > height[right]) {
                    right--;
                } else {
                    left++;
                }
            }
            return maxWater;
        }

        // 물 양 구하기
        private int getWater(int left, int right, int len) {
            return Math.min(left, right) * len;
        }
    }
}
