package hash_map_set;

import java.util.*;

public class Determine_if_Two_Strings_Are_Close {

    public static void main(String[] args) {
        Solution s = new Solution();
        boolean b = s.closeStrings("cabbba", "abbccc");
        System.out.println(b);
    }

    static class Solution {
        public boolean closeStrings(String word1, String word2) {
            Map<Character, Integer> set1 = new HashMap<>();
            char[] chars1 = word1.toCharArray();
            for(char c : chars1) {
                set1.put(c, set1.getOrDefault(c, 0) + 1);
            }

            Map<Character, Integer> set2 = new HashMap<>();
            char[] chars2 = word2.toCharArray();
            for(char c : chars2) {
                set2.put(c, set2.getOrDefault(c, 0) + 1);
            }

            // 다른 문자가 있으면 false
            // 개수가 다르면 false
            List<Integer> word1List = new ArrayList<>();
            List<Integer> word2List = new ArrayList<>();
            for(Map.Entry<Character, Integer> entry : set1.entrySet()) {
                if(!set2.containsKey(entry.getKey())) {
                    return false;
                }
                word1List.add(entry.getValue());
                word2List.add(set2.get(entry.getKey()));
            }
            for(Map.Entry<Character, Integer> entry : set2.entrySet()) {
                if(!set1.containsKey(entry.getKey())) {
                    return false;
                }
            }

            Collections.sort(word1List);
            Collections.sort(word2List);

            for(int i = 0; i < word1List.size(); i++) {
                if(!Objects.equals(word2List.get(i), word1List.get(i))) {
                    return false;
                }
            }

            return true;
        }
    }
}
