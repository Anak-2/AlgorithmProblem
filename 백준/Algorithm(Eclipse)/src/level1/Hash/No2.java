package level1.Hash;

import java.util.*;
import java.io.*;

// 완주하지 못한 선수
public class No2 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		HashSet<String> set = new HashSet<>();
		while(st.hasMoreTokens()) {
			set.add(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		String curStr = "";
		while(st.hasMoreTokens()) {
			curStr = st.nextToken();
			set.remove(curStr);
		}
		Iterator iter = set.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

}
