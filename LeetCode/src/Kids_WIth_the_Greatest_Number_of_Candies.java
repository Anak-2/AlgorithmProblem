import java.util.ArrayList;
import java.util.List;

public class Kids_WIth_the_Greatest_Number_of_Candies {

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Boolean> booleans = solution.kidsWithCandies(new int[]{2, 3, 5, 1, 3}, 3);
        booleans.forEach(System.out::println);
    }
    static class Solution {
        public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

            List<Boolean> answer = new ArrayList<Boolean>();

            // candies 에서 최대값 찾기
            int maxCandies = 0;
            for (int i = 0; i < candies.length; i++) {
                maxCandies = Math.max(maxCandies, candies[i]);
            }

            // 여분의 캔디 주고 최대값이 되는지 확인
            for(int i = 0; i < candies.length; i++) {
                Boolean result = false;
                if(candies[i] + extraCandies >= maxCandies) {
                    result = true;
                }
                answer.add(result);
            }

            return answer;
        }
    }
}
