package binray_search_tree;

import dfs.TreeNode;

public class Search_in_a_Binary_Search_Tree {
    class Solution {
        public TreeNode searchBST(TreeNode root, int val) {
            return findNode(root, val);
        }

        private TreeNode findNode(TreeNode node, int val) {
            if(node.val == val) return node;

            if (node.val > val) {
                if(node.left == null) return null;
                return findNode(node.left, val);
            }

            if (node.val < val) {
                if(node.right == null) return null;
                return findNode(node.right, val);
            }

            return null;
        }
    }
}
