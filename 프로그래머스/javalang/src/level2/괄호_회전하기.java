package level2;

import java.util.LinkedList;
import java.util.Stack;

// 괄호 검사를 플러스 마이너스로 검사했다가 해당 예외 케이스 발생 
public class 괄호_회전하기 {
    public static void main(String[] args) {
        System.out.println(Solution.solution("([{)}]"));
    }
    static class Solution {
        public static int solution(String s) {
            int answer = 0;
            LinkedList<Character> ll = new LinkedList<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                ll.addLast(c);
            }
            for(int i = 0; i < s.length(); i++){
                if(checkParenthesis(llToString(ll))){
                    answer++;
                }
                char popC = ll.removeLast();
                ll.addFirst(popC);
            }
            return answer;
        }

        public static boolean checkParenthesis(String str){
            Stack<Character> stack = new Stack<>();
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if (stack.isEmpty()) {
                    stack.push(c);
                } else if (c == ')' && stack.peek() == '(') {
                    stack.pop();
                } else if (c == '}' && stack.peek() == '{') {
                    stack.pop();
                } else if (c == ']' && stack.peek() == '[') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
            return stack.isEmpty();
        }

        public static String llToString(LinkedList<Character> ll){
            StringBuilder sb = new StringBuilder();
            for(Character c : ll){
                sb.append(c);
            }
            return sb.toString();
        }
    }
}
