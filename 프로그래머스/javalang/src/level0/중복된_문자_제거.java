package level0;

import java.util.*;
import java.util.stream.Collectors;

public class 중복된_문자_제거 {
    public static void main(String[] args) {
        System.out.println(Solution.solution("people"));
    }
    static class Solution {
        public static String solution(String my_string) {
            List<Character> cl = new ArrayList<>();
            Set<Character> cs = new HashSet<>();
            char[] characters = my_string.toCharArray();
            for(char c : characters){
                if(cs.contains(c)){
                    continue;
                }
                cs.add(c);
                cl.add(c);
            }
            return cl.stream().map(String::valueOf).collect(Collectors.joining());
        }
    }
}
