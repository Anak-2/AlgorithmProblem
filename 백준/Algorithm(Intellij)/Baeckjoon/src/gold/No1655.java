package gold;

import java.util.*;
import java.io.*;

// 가운데를 말해요
public class No1655 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
                (a, b) -> {return b - a;}
        );
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
//            Insert item
            st = new StringTokenizer(br.readLine());
            int item = Integer.parseInt(st.nextToken());
            int leftSize = maxHeap.size();
            int rightSize = minHeap.size();
            if(leftSize > rightSize){
                minHeap.add(item);
                compareAndSwap(maxHeap, minHeap);
            }else{
                maxHeap.add(item);
                compareAndSwap(maxHeap, minHeap);
            }
//          find middle item
            sb.append(findMiddle(maxHeap, minHeap)+"\n");
        }
        System.out.println(sb.toString());
    }

    public static void compareAndSwap(PriorityQueue<Integer> pq1, PriorityQueue<Integer> pq2){
        if(pq1.isEmpty() || pq2.isEmpty()) return;
        if(pq1.peek() > pq2.peek()){
            int temp = pq1.poll();
            pq1.add(pq2.poll());
            pq2.add(temp);
        }
    }

    public static int findMiddle(PriorityQueue<Integer> pq1, PriorityQueue<Integer> pq2){
        int returnVal = 0;
        int leftSize = pq1.size();
        int rightSize = pq2.size();
        if(leftSize == rightSize){
            int leftMax = pq1.peek();
            int rightMin = pq2.peek();
            if(leftMax < rightMin){
                returnVal = leftMax;
            }else{
                returnVal = rightMin;
            }
        }else{
            returnVal = (leftSize > rightSize) ? pq1.peek() : pq2.peek();
        }
        return returnVal;
    }
}
