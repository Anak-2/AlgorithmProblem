import java.util.*;

class Solution {
    public String solution(String s) {
        
        StringBuilder sb = new StringBuilder();
        boolean toUpper = true;
        for(char c : s.toCharArray()) {
            if(!Character.isAlphabetic(c)) {
                sb.append(c);
                toUpper = true;
            }else {
                if(toUpper) {
                    sb.append(Character.toUpperCase(c));
                    toUpper = false;
                }else {
                    sb.append(Character.toLowerCase(c));
                    toUpper = true;
                }
            }
        }
        
        return sb.toString(); 
    }
    
}