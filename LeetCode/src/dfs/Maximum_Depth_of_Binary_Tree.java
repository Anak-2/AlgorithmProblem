package dfs;

import java.util.LinkedList;
import java.util.List;

public class Maximum_Depth_of_Binary_Tree {

    class Solution {
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            List<Integer> root1Leaf = new LinkedList<>();
            List<Integer> root2Leaf = new LinkedList<>();
            findLeafList(root1, root1Leaf);
            findLeafList(root2, root2Leaf);

            int listSize = root1Leaf.size();
            if(root2Leaf.size() != listSize) return false;

            for(int i = 0; i < listSize; i++) {
                if(!root1Leaf.get(i).equals(root2Leaf.get(i))) return false;
            }
            return true;
        }

        public void findLeafList(TreeNode root, List<Integer> leafList) {

            if(root.left == null && root.right == null) {
                leafList.add(root.val);
                return;
            }

            if(root.left != null) {
                findLeafList(root.left, leafList);
            }

            if(root.right != null) {
                findLeafList(root.right, leafList);
            }

        }
    }
}
