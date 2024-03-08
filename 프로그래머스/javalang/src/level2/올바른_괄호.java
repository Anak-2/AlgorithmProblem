package level2;

public class 올바른_괄호 {
    public static void main(String[] args) {
        System.out.println(Solution.solution("()()"));
    }
    static class Solution{
        public static boolean solution(String s){
            int myStack = 0;
            for(char c : s.toCharArray()){
                if(c == '('){
                    myStack++;
                }else{
                    myStack--;
                    if(myStack < 0) return false;
                }
            }
            if(myStack == 0){
                return true;
            }
            return false;
        }
    }
}
