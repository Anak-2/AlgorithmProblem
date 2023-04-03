package level3.Hash;

import java.util.*;
import java.io.*;

// º£½ºÆ®¾Ù¹ü
public class No1 {
	
	public static void main(String[] args) {
		int[] answer = solution(new String[] {"classic", "pop", "classic", "classic", "pop"}, new int[] {500, 600, 150, 800, 2500});
	}
	
	public static int[] solution(String[] genres, int[] plays) {
        
        Map<String, PriorityQueue<Integer[]>> map = new HashMap<String, PriorityQueue<Integer[]>>();
        PriorityQueue pq;
        for(int i = 0; i < genres.length; i++) {
        	pq = map.get(genres[i]);
        	if(pq != null) {
        		pq.add(new Integer[] {plays[i],i});
        	}
        	else {
        		pq = new PriorityQueue<>((Integer[] i1, Integer[] i2) -> (i2[0]- i1[0]));
//        		pq = new PriorityQueue<>(new Comparator<Integer[]>() {
//					@Override
//					public int compare(Integer[] i1, Integer[] i2) {
//						return i2[0] - i1[0];
//					}
//        			
//        		});
        		pq.add(new Integer[] {plays[i],i});
        		map.put(genres[i], pq);
        	}
        }
        List<Integer[]> info = new ArrayList<Integer[]>();
        for(Map.Entry<String, PriorityQueue<Integer[]>> entry : map.entrySet()) {
        	int twoElement = 2;
        	Integer[] element = new Integer[] {0,0,0};
        	element[1] = -1;
        	element[2] = -1;
        	PriorityQueue<Integer[]> entryVal = entry.getValue();
        	while(!entryVal.isEmpty()) {
        		Integer[] e = entryVal.poll();
//        		System.out.println(e[0]);
        		if(twoElement == 2) {
//        			System.out.println("index: "+e[1]);
        			twoElement--;
        			element[1] = e[1];
        			element[0] += e[0];
        		}else if(twoElement == 1) {
//        			System.out.println("index: "+e[1]);
        			twoElement--;
        			element[2] = e[1];
        			element[0] += e[0];
        		}else {
        			element[0] += e[0];
        		}
        	}
        	info.add(element);
        }
        Collections.sort(info, (Integer[] a, Integer[] b) -> b[0] - a[0]);
        List<Integer> answer = new ArrayList<Integer>();
        for(Integer[] element : info) {
        	if(element[1] != -1) {
        		answer.add(element[1]);
        		if(element[2] != -1) {
        			answer.add(element[2]);
        		}
        	}
        }
        int[] realAnswer = new int[answer.size()];
        for(int i = 0; i < answer.size(); i++) {
        	realAnswer[i] = answer.get(i);
        }
        return realAnswer;
    }
}
