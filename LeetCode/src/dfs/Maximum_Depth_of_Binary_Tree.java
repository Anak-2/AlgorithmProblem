package dfs;

import javax.swing.tree.TreeNode;

public class Maximum_Depth_of_Binary_Tree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {

        int max = 0;

        public int maxDepth(TreeNode root) {
            if (root == null) return max;

            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }
    }
}
