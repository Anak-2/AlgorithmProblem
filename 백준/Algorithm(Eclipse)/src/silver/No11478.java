package silver;

import java.util.*;
import java.io.*;

// ���� �ٸ� �κ� ���ڿ��� ����
public class No11478 {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		HashSet<String> set = new HashSet<>();
		for(int i = 1; i <= str.length(); i++) {
			for(int s = 0; s <= str.length() - i; s++) {
//				substring�� start���� end-1���� ����
				System.out.println(str.substring(s, s+i));
				set.add(str.substring(s, s+i));
			}
		}
		
		System.out.println(set.size());
	}
}
