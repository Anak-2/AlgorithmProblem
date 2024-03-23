package ch13;

import java.util.ArrayList;
import java.util.List;

public class 양과_늑대 {

    public static void main(String[] args) {
        System.out.println(Solution.solution(
                new int[]{0,0,1,1,1,0,1,0,1,0,1,1},
                new int[][]{
                        {0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}
                }
        ));
    }

    class Solution {

        static List<List<Integer>> TREE = new ArrayList<>();
        static int[] INFO;
        static int ANSWER;

        public static int solution(int[] info, int[][] edges) {
            INFO = info;

            for(int i = 0; i < info.length; i++){
                TREE.add(new ArrayList<>());
            }

            for(int[] edge : edges){
                TREE.get(edge[0]).add(edge[1]);
            }

            List<Integer> next = new ArrayList<>();
            next.add(0);

            goNext(0, next, 0, 0);

            return ANSWER;
        }

        // 현재 위치, 다음 갈 수 있는 노드들, 양, 늑대
        static void goNext(int curLoc, List<Integer> ableNodes, int sheep, int wolf){

            if(INFO[curLoc] == 0){
                sheep++;
            }
            if(INFO[curLoc] == 1){
                wolf++;
            }

            // 늑대가 같으면 끝
            if(sheep <= wolf) {
                return;
            }

            // 답 갱신
            if(ANSWER < sheep){
                ANSWER = sheep;
            }

            List<Integer> nextNodes = new ArrayList<>(ableNodes);

            // 현재 노드에서 다음으로 갈 수 있는 노드들 저장
            if(!TREE.get(curLoc).isEmpty()){
                nextNodes.addAll(TREE.get(curLoc));
            }
            // 현재 방문한 노드는 삭제
            nextNodes.remove(Integer.valueOf(curLoc));

            // 다음 갈 노드 선택
            for(int nn : nextNodes){
                goNext(nn, nextNodes, sheep, wolf);
            }
        }
    }
}
