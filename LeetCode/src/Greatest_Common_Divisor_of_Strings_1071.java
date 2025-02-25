public class Greatest_Common_Divisor_of_Strings_1071 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.gcdOfStrings("ababab", "abab"));
    }

    static class Solution {
        public String gcdOfStrings(String str1, String str2) {
            int minLength = Math.min(str1.length(), str2.length());
            String ans = "";

            for(int i = 1; i < minLength + 1; i++) {
                String parsedStr1 = str1.substring(0, i);
                String parsedStr2 = str2.substring(0, i);

                if(!parsedStr1.equals(parsedStr2)) {
                    return ans;
                }

                if(isDividable(str1, parsedStr1) && isDividable(str2, parsedStr2)) {
                    ans = parsedStr1;
                }
            }

            return ans;
        }

        private boolean isDividable(String dividend, String divisor) {
            if(dividend.length() % divisor.length() != 0) {
                return false;
            }

            for(int i = 0; i < dividend.length(); i++) {
                if(dividend.charAt(i) != divisor.charAt(i % divisor.length())) {
                    return false;
                }
            }
            return true;
        }
    }
}
