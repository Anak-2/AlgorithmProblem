import java.util.Arrays;

public class String_Compression {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int compress = solution.compress(new char[]{'a', 'a', 'a', 'b', 'b', 'c', 'c', 'c'});
        System.out.println(compress);
    }

    static class Solution {
        public int compress(char[] chars) {
            char prev = chars[0];
            int prevCnt = 1;
            StringBuilder sb = new StringBuilder();
            // 문자열 순회
            for (int i = 1; i < chars.length; i++) {
                if (chars[i] != prev) {
                    // 이전에 나온 문자 저장
                    stringCompress(sb, prev, prevCnt);
                    prev = chars[i];
                    prevCnt = 1;
                } else {
                    prevCnt++;
                }
            }
            stringCompress(sb, prev, prevCnt);
            String s = sb.toString();
            int idx = 0;
            for(char c : s.toCharArray()) {
                chars[idx] = c;
                idx++;
            }
            System.out.println(Arrays.toString(chars));
            return sb.length();
        }

        public void stringCompress(StringBuilder sb, char c, int i) {
            if (i == 1) {
                sb.append(c);
            } else {
                sb.append(c);
                sb.append(i);
            }
        }
    }
}
