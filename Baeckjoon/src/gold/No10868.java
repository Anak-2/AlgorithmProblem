package gold;

import java.util.*;
import java.io.*;

// 최솟값 (세그먼트 트리를 이용한 구간의 최솟값 찾기)
public class No10868 {

    static class Node{
        Node left = null;
        Node right = null;
        int start;
        int end;
        int min;
        Node(int start, int end){
            this.start = start;
            this.end = end;
        }
        private void setMin(){
            this.min = Math.min(left.min, right.min);
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        for(int i = 1; i < N+1; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Node root = makeMinSegmentTree(arr, 1, arr.length-1);
//        ArrayList<Node> stack = new ArrayList<>();
//        stack.add(root);
//        while(!stack.isEmpty()){
//            Node cur = stack.remove(0);
//            if(cur.left != null){
//                stack.add(cur.left);
//            }
//            if(cur.right != null){
//                stack.add(cur.right);
//            }
//        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            System.out.println(findMin(root, start, end));
        }
    }

    public static Node makeMinSegmentTree(int[] arr, int left, int right){
        Node node = new Node(left, right);
//        leaf node
        if(left == right){
            node.min = arr[left];
        }
        int mid = -1;
        if(left < right){
            mid = (left + right) / 2;
            node.left = makeMinSegmentTree(arr, left, mid);
            node.right = makeMinSegmentTree(arr, mid+1, right);
            node.setMin();
        }
        return node;
    }

    public static int findMin(Node node, int start, int end){
        if(node.left == null && node.right == null){
            return node.min;
        }
        if(node.start == start && node.end == end){
            return node.min;
        }
        int mid = (node.start + node.end) / 2;
        if(end <= mid){
            return findMin(node.left, start, end);
        }else if(mid < start){
            return findMin(node.right, start, end);
        }else{
            int min1 = findMin(node.left, start, mid);
            int min2 = findMin(node.right, mid+1, end);
            return Math.min(min1, min2);
        }
    }
}
