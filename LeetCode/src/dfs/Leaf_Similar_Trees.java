package dfs;

import java.util.LinkedList;
import java.util.List;

class Leaf_Similar_Trees {

    class Solution {
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            List<Integer> root1Leaf = new LinkedList<>();
            List<Integer> root2Leaf = new LinkedList<>();
            findLeafList(root1, root1Leaf);
            findLeafList(root2, root2Leaf);

            int listSize = root1Leaf.size();
            if(root2Leaf.size() != listSize) return false;

            for(int i = 0; i < listSize; i++) {
                System.out.println(root1Leaf.get(i));
                System.out.println(root2Leaf.get(i));
                System.out.println(200 == 200);

                System.out.println(root1Leaf.get(i) != root2Leaf.get(i));

                if(root1Leaf.get(i) != root2Leaf.get(i)) return false;
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
