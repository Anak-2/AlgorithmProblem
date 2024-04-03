package pccp_1;

public class 체육대회 {

    class Solution {
        static int[][] Ability;
        static int Answer = 0;
        static boolean[] Visited;

        public int solution(int[][] ability) {
            Ability = ability;
            Visited = new boolean[Ability.length];
            permutation(0, 0);
            return Answer;
        }

        public void permutation(int depth, int total){
            // 운동 종목 수
            int c = Ability[0].length;

            // 운동 종목 수 만큼 뽑았을 때
            if(c == depth){
                Answer = Math.max(Answer, total);
                return;
            }

            for(int i = 0; i < Ability.length; i++){
                if(!Visited[i]){
                    Visited[i] = true;
                    permutation(depth+1, total+Ability[i][depth]);
                    Visited[i] = false;
                }
            }
        }
    }
}
