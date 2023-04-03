package silver;

import java.io.*;
import java.util.*;

// 그룹 단어 체커
public class No1316 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			String word = br.readLine();
			if(isGroupWord(word.toCharArray())) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	
	private static boolean isGroupWord(char[] str) {
		int len = str.length;
		char prev = ' ';
		HashSet<Character> set = new HashSet<>();
		for(int i = 0; i < len; i++) {
			if(prev == str[i]) continue;
			else prev = str[i];
			if(!set.add(str[i])) {
				return false;
			}
		}
		return true;
	}
}
