package ch12;

public class 타깃_넘버 {
    public static void main(String[] args) {
        System.out.println(Solution.solution(
                new int[]{1,1,1,1,1},3
        ));
    }
    static class Solution {
        static int cnt = 0;

        public static int solution(int[] numbers, int target) {
            dfs(numbers, -1*numbers[0], 0, target);
            dfs(numbers, numbers[0], 0, target);
            return cnt;
        }
        public static void dfs(int[] numbers, int curNum, int curIdx, int target){
            // 모든 경우의 수 탐색 (그리디)
            if(curIdx != numbers.length-1){
                curIdx += 1;
                dfs(numbers, curNum+numbers[curIdx], curIdx, target);
                dfs(numbers, curNum-numbers[curIdx], curIdx, target);
            }
            // target 넘버에 도착하면 만들 수 있는 경우 증가
            else if(curNum == target) cnt++;
        }
    }
}
