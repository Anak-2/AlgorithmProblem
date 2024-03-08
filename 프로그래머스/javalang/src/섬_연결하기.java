import java.util.*;
public class 섬_연결하기 {
    public static void main(String[] args) {
        System.out.println(Solution.solution(4,
                new int[][]{{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}}));
    }

    // 문제 아이디어: 섬 연결했을 때 모든 섬을 포함하는 지 바로 확인 가능하도록 union find 사용
    static class Solution {
        public static int solution(int n, int[][] costs) {
            int answer = 0;
            int[] island = new int[n];

            for(int i = 0; i < n; i++){
                island[i] = i;
            }

            // 건설 비용 순으로 정렬
            Arrays.sort(costs, (a,b) -> Integer.compare(a[2],b[2]));

            // 건설 비용이 낮은 다리부터 union 진행
            for(int i = 0; i < costs.length; i++){
                if(find(island, costs[i][0]) != find(island, costs[i][1])){
                    union(island, costs[i][0], costs[i][1]);
                    answer += costs[i][2];
                }
            }

            return answer;
        }

        static int find(int[] island, int x){
            if(island[x] == x){
                return x;
            }
            return find(island, island[x]);
        }

        static void union(int[] island, int x, int y){
            int a = find(island, x);
            int b = find(island, y );
            island[a] = b;
        }
    }
}
