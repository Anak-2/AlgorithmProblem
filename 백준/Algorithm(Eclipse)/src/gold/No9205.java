package gold;

import java.util.*;
import java.io.*;

class Conv{
    int r;
    int c;
    boolean visited = false;
    Conv(int r, int c){
        this.r = r;
        this.c = c;
    }
}

public class No9205 {
	
	static Integer[] home;
	static Integer[] target;

    static int n;
    public static void main(String []args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        int r;
        int c;
        for(int i = 0; i < t; i++) {	
        	// 편의점 개수
        	n = Integer.parseInt(br.readLine());
        	// home loc
        	st = new StringTokenizer(br.readLine());
        	r = Integer.parseInt(st.nextToken());
        	c = Integer.parseInt(st.nextToken());
        	home = new Integer[2];
        	home[0] = r;
        	home[1] = c;
        	// 편의점 저장한 list
        	LinkedList<Conv> convList = new LinkedList<>();
        	for(int j = 0; j < n; j++) {
        		st = new StringTokenizer(br.readLine());
        		r = Integer.parseInt(st.nextToken());
        		c = Integer.parseInt(st.nextToken());
        		convList.add(new Conv(r,c));
        	}
        	// 도착 위치
        	st = new StringTokenizer(br.readLine());
        	r = Integer.parseInt(st.nextToken());
        	c = Integer.parseInt(st.nextToken());
        	target = new Integer[2];
        	target[0] = r;
        	target[1] = c;
        	
        	int result = DFS(home[0], home[1], convList, 0);
        	if(result == -1){
        		System.out.println("sad");
        	}else{
        		System.out.println("happy");
        	}
        }
    }
    
    public static int DFS(int r, int c, LinkedList<Conv> convList, int cnt){
        if(dist(r,c,target[0],target[1]) <= 1000){
            return cnt;
        }
        cnt++;
        int check = -1;
        for(Conv conv : convList){
            if(dist(r,c,conv.r,conv.c) <= 1000 && !conv.visited){
//            	System.out.println("r: "+r+" c: "+c);
            	conv.visited = true;
                check = DFS(conv.r, conv.c, convList, cnt);
                if(check != -1) {
                	return check;
                }
            }
        }
        return -1;
    }
    
    public static int dist(int r1, int c1, int r2, int c2){
    	int cal = Math.abs(r1-r2) + Math.abs(c1-c2);
//    	System.out.println(cal);
        return cal;
    }
}
