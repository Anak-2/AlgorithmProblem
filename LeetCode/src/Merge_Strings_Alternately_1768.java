public class Merge_Strings_Alternately_1768 {
    
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }

    static class Solution {
        public String mergeAlternately(String word1, String word2) {
            StringBuilder result = new StringBuilder();
            int i = 0;
            while (i < word1.length() || i < word2.length()) {
                if (i < word1.length()) {
                    result.append(word1.charAt(i));
                }
                if (i < word2.length()) {
                    result.append(word2.charAt(i));
                }
                i++;
            }
            return result.toString();
        }
    }
}