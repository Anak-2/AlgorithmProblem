package com.example.level2;

import java.util.ArrayList;
import java.util.List;

public class 전력망을_둘로_나누기 {

    public static void main(String[] args) {
        Solution s = new Solution();
    }

    static class Solution {

        public int solution(int n, int[][] wires) {
            int answer = Integer.MAX_VALUE;

            List<List<Integer>> tree = new ArrayList<>();
            for(int i = 0; i < n+1; i++){
                tree.add(new ArrayList<>());
            }

            for(int[] wire : wires){
                tree.get(wire[0]).add(wire[1]);
                tree.get(wire[1]).add(wire[0]);
            }

            for(int[] wire : wires){
                List<List<Integer>> copy = deepCopy(tree);
                // if(wire[0] < copy.size() && wire[1] < copy.size()){
                copy.get(wire[0]).remove((Integer) wire[1]);  // wire[1]을 remove할 때 오토박싱 문제를 피하기 위해 (Integer)를 명시적으로 사용
                copy.get(wire[1]).remove((Integer) wire[0]);
                // }
                boolean[] visited = new boolean[n+1];

                int result = -1;
                for(int i = 1; i < visited.length; i++){
                    if(!visited[i]){
                        visited[i] = true;
                        if(result == -1){
                            result = getLinkedNode(i, copy, visited, 1);
                        }else{
                            int result1 = getLinkedNode(i, copy, visited, 1);
                            answer = Math.min(answer, Math.abs(result - result1));
                        }
                    }
                }

            }

            return answer;
        }

        private int getLinkedNode(int startNode, List<List<Integer>> tree, boolean[] visited, int cnt){
            List<Integer> linked = tree.get(startNode);
            for(Integer i : linked){
                if(visited[i]) continue;
                visited[i] = true;
                int result = getLinkedNode(i, tree, visited, cnt+1);
                cnt = Math.max(cnt, result);
            }
            return cnt;
        }

        private List<List<Integer>> deepCopy(List<List<Integer>> tree){
            List<List<Integer>> copy = new ArrayList<>();
            for(List<Integer> eachTree : tree){
                List<Integer> copyTree = new ArrayList<>(eachTree);
                copy.add(copyTree);
            }
            return copy;
        }
    }
}
