package ch11;

import java.util.Arrays;

public class 길_찾기_게임 {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(Solution.solution(
                new int[][]{{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}}
        )));
    }

    static class Node {

        public int value;
        public int x;
        public int y;
        public Node right;
        public Node left;

        public Node(int value, int x, int y, Node right, Node left) {
            this.value = value;
            this.x = x;
            this.y = y;
            this.left = left;
            this.right = right;
        }

    }

    static class Solution {

        // 정답 [전위 순환, 후위 순환]
        static int[][] result;
        // 정답으로 넣을 위치
        static int idx = 0;

        public static int[][] solution(int[][] nodeinfo) {
            Node[] nodes = new Node[nodeinfo.length];

            // Node 클래스로 관리 (번호, x 좌표, y 좌표, 오른쪽 자식 노드 번호, 왼쪽 자식 노드 번호)
            for (int i = 0; i < nodeinfo.length; i++) {
                nodes[i] = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1], null, null);
            }

            //y는 내림차 x는 오름차순으로 정렬
            Arrays.sort(nodes, (a, b) -> {
                if (a.y == b.y) {
                    return a.x - b.x;
                }
                return b.y - a.y;
            });

            // y idx 0, 처음 레벨부터 시작
            Node parent = nodes[0];

            for (int i = 1; i < nodes.length; i++) {
                MakeTree(parent, nodes[i]);
            }

            result = new int[2][nodeinfo.length];

            preorder(parent);
            idx = 0;
            postorder(parent);

            return result;
        }

        // 현재 노드 왼쪽 자식인지 오른쪽 자식인지 결정
        public static void MakeTree(Node parent, Node child) {
            // 오른쪽 자식일 경우
            if (parent.x < child.x) {
                if (parent.right == null) {
                    parent.right = child;
                } else {
                    MakeTree(parent.right, child);
                }
            }
            // 왼쪽 자식일 경우
            else {
                if (parent.left == null) {
                    parent.left = child;
                } else {
                    MakeTree(parent.left, child);
                }
            }

        }

        // 부모 먼저 체크
        public static void preorder(Node root) {
            if (root != null) {
                result[0][idx++] = root.value;
                preorder(root.left);
                preorder(root.right);
            }
        }

        // 자식 먼저 체크 
        public static void postorder(Node root) {
            if (root != null) {
                postorder(root.left);
                postorder(root.right);
                result[1][idx++] = root.value;
            }
        }
    }

}
