import java.util.HashSet;
import java.util.Set;

public class Maximum_Number_of_Vowels_in_a_Substring_of_Given_Length_1456 {

    static class Solution {
        public int maxVowels(String s, int k) {
            Set<Character> vowel = new HashSet<>();
            vowel.add('a');
            vowel.add('e');
            vowel.add('i');
            vowel.add('o');
            vowel.add('u');
            int answer = 0;

            char[] chars = s.toCharArray();
            int cnt = 0;
            for(int i = 0; i < k; i++) {
                if(vowel.contains(chars[i])) {
                    cnt++;
                }
            }
            answer = cnt;

            int cLen = chars.length;
            for(int i = k; i < cLen; i++) {
                if(vowel.contains(chars[i - k])) cnt--;
                if(vowel.contains(chars[i])) cnt++;
                answer = Math.max(answer, cnt);
            }
            return answer;
        }
    }
}
