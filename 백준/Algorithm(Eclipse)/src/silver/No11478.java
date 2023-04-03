package silver;

import java.util.*;
import java.io.*;

// 서로 다른 부분 문자열의 개수
public class No11478 {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		HashSet<String> set = new HashSet<>();
		for(int i = 1; i <= str.length(); i++) {
			for(int s = 0; s <= str.length() - i; s++) {
//				substring은 start부터 end-1까지 저장
				System.out.println(str.substring(s, s+i));
				set.add(str.substring(s, s+i));
			}
		}
		
		System.out.println(set.size());
	}
}
