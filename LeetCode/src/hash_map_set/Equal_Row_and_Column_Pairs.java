package hash_map_set;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Equal_Row_and_Column_Pairs {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.equalPairs(new int[][]{
                {3, 2, 1}, {1, 7, 6}, {2, 7, 7}
        }));
    }

    static class Solution {
        public int equalPairs(int[][] grid) {
            HashMap<List<Integer>, Integer> map = new HashMap<>();
            int res = 0;

            for (int i = 0; i < grid.length; i++) {
                List<Integer> arr = new ArrayList<Integer>();
                for (int j = 0; j < grid.length; j++) {
                    arr.add(grid[i][j]);
                }
                map.put(arr, map.getOrDefault(arr, 0) + 1);
            }

            for (int i = 0; i < grid.length; i++) {
                List<Integer> arr = new ArrayList<Integer>();
                for (int j = 0; j < grid.length; j++) {
                    arr.add(grid[j][i]);
                }

                if (map.containsKey(arr)) {
                    res += map.get(arr);
                }
            }

            return res;
        }
    }
}
