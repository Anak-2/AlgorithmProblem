package level2.Hash;

import java.io.*;
import java.util.*;

// ¿ß¿Â
public class No2 {
	
	public static void main(String[] args) {
		
	}
	
	public static int solution(String[][] clothes) {
		int answer = 1;
		
		Map<String, Integer> map = new HashMap<>();
		for(int i = 0; i < clothes.length; i++) {
			Integer cnt = map.get(clothes[i][1]);
			if(cnt != null) {
				map.put(clothes[i][1], cnt+1);
			}
			else {
				map.put(clothes[i][1], 1);
			}
		}
		
		Iterator<Integer> iter = map.values().iterator();
		while(iter.hasNext()) {
			answer = answer*(iter.next()+1);
		}
//		ø ¿ª 1∞≥µµ æ» ∞Ò∂˙¿ª ∂ß ¡¶ø‹
		answer -= 1;
		return answer;
	}
}
