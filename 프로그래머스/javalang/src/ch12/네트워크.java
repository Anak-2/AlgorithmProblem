package ch12;

public class 네트워크 {
    class Solution {
        static boolean[] visited;
        public int solution(int n, int[][] computers) {
            int answer = 0;
            visited = new boolean[n];
            boolean check = false;
            for(int i = 0; i < n; i++){
                check = dfs(i, computers);
                if(check) answer++;
                check =false;
            }
            return answer;
        }

        public boolean dfs(int start, int[][] computers){
            boolean flag = false;
            for(int i = 0; i < computers[start].length; i++){
                if(computers[start][i] == 1 && !visited[i]){
                    flag = true;
                    visited[i] = true;
                    dfs(i, computers);
                }
            }
            if(flag) return true;
            else return false;
        }
    }
}
