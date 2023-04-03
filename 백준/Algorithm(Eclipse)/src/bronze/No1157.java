package bronze;

import java.io.*;
import java.util.*;

public class No1157 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] charArr = sc.nextLine().toUpperCase().toCharArray();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(char i : charArr) {
			if(map.containsKey(i)) {
				Integer cnt = map.get(i);
				map.replace(i, cnt+1);
			}else {
				map.put(i, 1);
			}
		}
		int max = 0;
		char c = ' ';
		for(Map.Entry<Character, Integer> entry : map.entrySet()) {
			if(max < entry.getValue()) {
				max = entry.getValue();
				c = entry.getKey();
			}else if(max == entry.getValue()) {
				c = '?';
			}
		}
		System.out.println(c);
	}

}
