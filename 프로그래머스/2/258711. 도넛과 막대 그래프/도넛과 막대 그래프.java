
import java.util.*;

class Solution {

        public int[] solution(int[][] edges) {

            Map<Integer, int[]> nodes = new HashMap<>();

            int extraNode = -1;
            int doughnut = 0;
            int stick = 0;
            int figure8 = 0;


            for( int[] edge: edges ){
                int from = edge[0];
                int to = edge[1];

                if(!nodes.containsKey(from)){
                    nodes.put(from, new int[]{0,0});
                }
                if(!nodes.containsKey(to)){
                    nodes.put(to, new int[]{0,0});
                }

                nodes.get(from)[0]++;
                nodes.get(to)[1]++;
            }

            for( int key : nodes.keySet()){
                int[] count = nodes.get(key);

                if(count[0] >= 2 && count[1] == 0) {
                    extraNode = key;
                }

                else if(count[0] == 0 && count[1] > 0) {
                    stick++;
                }
      
                else if(count[0] >= 2 && count[1] >= 2) {
                    figure8++;
                }
            }

            doughnut = nodes.get(extraNode)[0] - stick - figure8;

            return new int[]{ extraNode, doughnut, stick, figure8 };

        }
    }