package gold;

import java.util.*;
import java.io.*;

// 컵라면
public class No1781 {
    static PriorityQueue<Integer> store = new PriorityQueue<>();
    static PriorityQueue<int[]> waitList = new PriorityQueue<>(
    		(int[] a, int[] b) -> {
    					if(a[0] > b[0]) return 1;
    					else if(a[0] == b[0]) {
    						return b[1] - a[1];
    					}else {
    						return -1;
    					}
    		});
    public static void main(String []args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int maxDead = 0;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int ramen = Integer.parseInt(st.nextToken());
            waitList.offer(new int[] {d, ramen});
        }
            int[] cur;
            while(!waitList.isEmpty()) {
            	cur = waitList.poll();
//            	System.out.println(Arrays.toString(cur));
//            	현재까지 푼 문제 수
            	int solvedNum = store.size();
            	if(cur[0] > solvedNum) {
            		store.add(cur[1]);
            	}else if(cur[0] == solvedNum){
            		if(cur[1] > store.peek()) {        			
            			store.poll();
            			store.add(cur[1]);
            		}
            	}
            }
        int sum = 0;
        while(!store.isEmpty()) {
        	 sum += store.poll();
        }
        System.out.println(sum);
    }
}
