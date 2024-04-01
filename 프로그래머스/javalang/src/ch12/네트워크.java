package ch12;

public class 네트워크 {
    public static void main(String[] args) {
        System.out.println(Solution.solution(
                3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}
        ));
    }
    static class Solution {
        static boolean[] visited;
        public static int solution(int n, int[][] computers) {
            int answer = 0;
            visited = new boolean[n];
            for(int i = 0; i < n; i++){
                // 한 컴퓨터에서 뻗어나간 후 정답 + 1
                if(dfs(i, computers)) answer++;
            }
            return answer;
        }

        public static boolean dfs(int start, int[][] computers){
            boolean flag = false;
            // 연결된 컴퓨터 방문 처리
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
