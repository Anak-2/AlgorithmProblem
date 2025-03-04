package prefix_sum;

public class Find_the_Highest_Altitude {

    class Solution {
        public int largestAltitude(int[] gain) {
            int maxAltitude = 0, start = 0;
            for(int i : gain) {
                start += i;
                maxAltitude = Math.max(maxAltitude, start);
            }
            return maxAltitude;
        }
    }
}
