public class Is_Subsequence {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isSubsequence("axc", "ahbgdc"));
    }
    static class Solution {
        public boolean isSubsequence(String s, String t) {
            char[] sc = s.toCharArray();
            char[] tc = t.toCharArray();

            int idx = 0;
            for(char c : tc) {
                if(sc[idx] == c) {
                    idx++;
                    if(idx == sc.length) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
