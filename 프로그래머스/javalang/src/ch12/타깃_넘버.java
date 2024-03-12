package ch12;

public class 타깃_넘버 {
    class Solution {
        static int cnt = 0;

        public int solution(int[] numbers, int target) {
            dfs(numbers, -1*numbers[0], 0, target);
            dfs(numbers, numbers[0], 0, target);
            int answer = cnt;
            return answer;
        }
        public void dfs(int[] numbers, int curNum, int curIdx, int target){
            if(curIdx != numbers.length-1){
                curIdx += 1;
                dfs(numbers, curNum+numbers[curIdx], curIdx, target);
                dfs(numbers, curNum-numbers[curIdx], curIdx, target);
            }
            else if(curNum == target) cnt++;
        }
    }
}
