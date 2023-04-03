package level1.Hash;

import java.util.*;
import java.io.*;

public class No1 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashSet<Integer> set = new HashSet<>();
		int N = 0;
		while(st.hasMoreTokens()) {
			set.add(Integer.parseInt(st.nextToken()));
			N++;
		}
		
		int answer = set.size() > N/2 ? N/2 : set.size();
//		System.out.println(answer);
	}

}
