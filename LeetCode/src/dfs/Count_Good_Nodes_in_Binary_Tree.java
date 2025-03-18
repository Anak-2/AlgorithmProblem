package dfs;

public class Count_Good_Nodes_in_Binary_Tree {
    class Solution {

        int cnt = 0;

        public int goodNodes(TreeNode root) {
            dfs(root, root.val);
            return cnt;
        }

        public void dfs(TreeNode node, int prevMax) {
            if(node.val >= prevMax) {
                cnt++;
                prevMax = node.val;
            }

            if(node.left != null) {
                dfs(node.left, prevMax);
            }
            if(node.right != null) {
                dfs(node.right, prevMax);
            }
        }
    }
}
