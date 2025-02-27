import java.util.ArrayList;
import java.util.List;

public class Reverse_Vowels_of_a_String_345 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseVowels("cec"));
    }

    static class Solution {

        public String reverseVowels(String s) {
            List<Integer> vowelIndexes = new ArrayList<Integer>();
            for (int i = 0; i < s.length(); i++) {
                if(isVowel(s.charAt(i))) {
                    vowelIndexes.add(i);
                }
            }

            char[] answer = s.toCharArray();

            int left = 0;
            int right = vowelIndexes.size() - 1;
            while(left < right) {
                int leftIndex = vowelIndexes.get(left);
                int rightIndex = vowelIndexes.get(right);
                answer[leftIndex] = s.charAt(rightIndex);
                answer[rightIndex] = s.charAt(leftIndex);
                left++;
                right--;
            }

            return new String(answer);
        }

        private boolean isVowel(char c) {
            c = Character.toLowerCase(c);
            return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
        }
    }
}
