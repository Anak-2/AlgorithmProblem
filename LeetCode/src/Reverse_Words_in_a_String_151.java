import java.util.List;
import java.util.Scanner;

public class Reverse_Words_in_a_String_151 {

    public static void main(String[] args) {
        Solution s = new Solution();
        String s1 = s.reverseWords("the sky is blue");
        System.out.println(s1);
    }

    static class Solution {
        public String reverseWords(String s) {
            String[] splitedString = s.replaceAll("\\s+", " ").trim().split(" ");
            StringBuilder sb = new StringBuilder();
            for(int i = splitedString.length - 1; i >= 0; i--){
                sb.append(splitedString[i]).append(" ");
            }
            return sb.deleteCharAt(sb.length()-1).toString();
        }
    }
}
