import java.util.ArrayList;
import java.util.List;

public class Move_Zeros {

    static class Solution {
        public void moveZeroes(int[] nums) {
            List<Integer> list = new ArrayList<>();
            for(int i : nums) {
                if(i != 0) {
                    list.add(i);
                }
            }
            int zeroCnt = nums.length - list.size();
            for(int i = 0; i < zeroCnt; i++) {
                list.add(0);
            }
            int k = list.size();
            for(int i = 0; i < k; i++) {
                nums[i] = list.get(i);
            }
        }
    }
}
