
import java.util.*;


class Solution {

        static int N;
        static List<List<Integer>> linkedList = new ArrayList<>();

        public int solution(int n, int[][] wires) {
            try{
                N = n;
                for(int i = 0; i <= N; i++) {
                    linkedList.add(new ArrayList<>());
                }

                for(int[] wire : wires) {
                    linkedList.get(wire[0]).add(wire[1]);
                    linkedList.get(wire[1]).add(wire[0]);
                }

                int ans = Integer.MAX_VALUE;
                for(Integer i = 1; i <= N; i++) {
                    for(Integer j : linkedList.get(i)) {
                        List<List<Integer>> temp = copyLinkedList();
                        temp.get(i).remove(j);
                        temp.get(j).remove(i);
                        int diff = calGroupDiff(temp);
                        ans = Math.min(diff, ans);
                    }
                }
                return ans;
            }catch(Exception e) {
                e.printStackTrace();
                return 0;
            }
        }

        private int calGroupDiff(List<List<Integer>> temp) {
            boolean[] visited = new boolean[N+1];
            Deque<Integer> stack = new LinkedList<>();
            stack.add(1);
            visited[1] = true;

            while(!stack.isEmpty()) {
                int cur = stack.removeFirst();
                List<Integer> next = temp.get(cur);
                for(Integer i : next) {
                    if(visited[i]) continue;
                    visited[i] = true;
                    stack.add(i);
                }
            }

            int acc = 0;
            for(boolean b : visited) {
                if(b) acc++;
            }
            return Math.abs((N - acc) - acc);
        }

        private List<List<Integer>> copyLinkedList() {
            List<List<Integer>> temp = new ArrayList<>();
            for(List<Integer> innerList : linkedList) {
                temp.add(new ArrayList<>(innerList));
            }
            return temp;
        }

        private void printLinkedList(List<List<Integer>> temp) {
            for(List<Integer> list : temp) {
                for(Integer i : list) {
                    System.out.print(i+ " ");
                }
                System.out.println();
            }
        }
    }

