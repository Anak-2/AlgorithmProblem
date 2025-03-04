package stack;

import java.util.Iterator;
import java.util.Stack;

public class Removing_Stars_From_a_String {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.removeStars("leet**cod*e");
        System.out.println(s);
    }

    static class Solution {
        public String removeStars(String s) {
            char[] arr = s.toCharArray();
            Stack<Character> stack = new Stack<>();
            for(int i = 0; i < arr.length; i++){
                if(arr[i] == '*'){
                    stack.pop();
                }else {
                    stack.push(arr[i]);
                }
            }
            StringBuilder sb = new StringBuilder();
            for(Iterator<Character> it = stack.iterator(); it.hasNext();){
                sb.append(it.next());
            }
            return sb.toString();
        }
    }

}
