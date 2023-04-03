package silver;

import java.io.*;
import java.util.*;


// 숫자 카드 2
public class No10816 {

	public static void main(String[] args) throws Exception{
		HashMap<Integer, Integer> map = new HashMap<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int key = Integer.parseInt(st.nextToken());
			Integer cnt = map.get(key);
//			if(map.containsKey(key)) {
//				map.replace(key, map.get(key)+1);
//			}
//			else {
//				map.put(key, 1);
//			}
			if(cnt != null) {
				map.put(key, cnt+1);
			}
			else {
				map.put(key, 1);
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i< M; i++) {
			int cur = Integer.parseInt(st.nextToken());
			if(map.containsKey(cur)) {
				System.out.print(map.get(cur)+" ");
			}
			else {
				System.out.print(0+" ");
			}
		}
	}

}
