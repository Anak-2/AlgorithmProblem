package gold;

import java.util.*;
import java.io.*;

// 부분합, 처음에 세그먼트 트리로 접근
public class No1806 {

    static int N;
    static int S;
    static int ans;
    static boolean doesFind = false;

    static class Node{
        int start;
        int end;
        int item;
        Node left = null;
        Node right = null;

        public Node(int start, int end){
            this.start = start;
            this.end = end;
        }

        public void setItem(int item){
            this.item = item;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
//      N짜리 수열
        N = Integer.parseInt(st.nextToken());
//      합이 S 이상
        S = Integer.parseInt(st.nextToken());
        ans = Integer.MAX_VALUE/2;
        st = new StringTokenizer(br.readLine());
        int[] nums = new int[N+1];
        for(int i = 0; i < N; i++){
            nums[i+1] = Integer.parseInt(st.nextToken());
        }

        Node root = makeSegment(nums, 1, N);
        findShortestSum(root);
        System.out.println(ans);
    }

    public static Node makeSegment(int[] nums, int start, int end){
        Node node = new Node(start, end);
        if(start == end){
            node.setItem(nums[start]);
            return node;
        }else if(start < end){
            int mid = (start + end)/2;
            node.left = makeSegment(nums, start, mid);
            node.right = makeSegment(nums, mid+1, end);
            if(node.left != null && node.right != null){
                node.item = node.left.item + node.right.item;
            }else{
                System.out.println("child null!");
            }
            return node;
        }else{
            return null;
        }
    }

    public static void findShortestSum(Node node){
//        i는 길이
        for(int i = 1; i <= N; i++){
//            j는 시작 지점
            for(int j = 1; j <= N; j++){
                int sum = getSum(node, i, j);

            }
        }
    }

    public static int getSum(Node node, int start, int end){
        if(start == node.start && end == node.end){
            return node.item;
        }else if(start < end){
            int mid = (node.start+node.end)/2;
            if(start <= mid && mid < end){
                int a = getSum(node.left, start, mid);
                int b = getSum(node.right, mid+1, end);
                return a+b;
            }else if(start <= mid){
                return getSum(node.left, start, end);
            }else{
                return getSum(node.right, start, end);
            }
        }
//        System.out.println("something wrong in getSum()");
        return -1;
    }
}
