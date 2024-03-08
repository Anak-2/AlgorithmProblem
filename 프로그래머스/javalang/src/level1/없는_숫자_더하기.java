package level1;

public class 없는_숫자_더하기 {
    public static void main(String[] args) {
        System.out.println(Solution.solution(new int[]{1,2,3,4,6,7,8,0}));
    }
    static class Solution {
        public static int solution(int[] numbers) {
            int sum = 45;
            for (int i : numbers) {
                sum -= i;
            }
            return sum;
        }
    }
}
