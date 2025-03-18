package dfs;

import java.util.ArrayList;
import java.util.List;

public class Path_Sum_3 {

    class Solution {

        int TARGET_SUM = 0;
        int VAL = 0;

        public int pathSum(TreeNode root, int targetSum) {
            TARGET_SUM = targetSum;
            List<Long> valList = new ArrayList<>();
            if(root == null) return 0;
            dfs(root, valList);
            return VAL;
        }

        public void dfs(TreeNode node, List<Long> valList) {
            valList.add(0L);

            // 현재 도착한 노드 처리
            int valSize = valList.size();
            for(int i = 0; i < valSize; i++) {
                long sum = valList.get(i) + node.val;
                if(sum == TARGET_SUM) VAL++;
                valList.set(i, sum);
            }

            // 만약 자식 노드가 없으면 끝
            if(node.left == null && node.right == null) {
                valList.remove(valList.size() - 1);
                return;
            }

            if(node.left != null) {
                List<Long> nextList = new ArrayList<Long>(valList);
                dfs(node.left, nextList);
            }

            if(node.right != null) {
                List<Long> nextList = new ArrayList<Long>(valList);
                dfs(node.right, nextList);
            }

            valList.remove(valList.size() - 1);
        }
    }
}
