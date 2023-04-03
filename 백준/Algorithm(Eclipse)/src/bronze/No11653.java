package bronze;

import java.util.*;
import java.io.*;

// 소인수분해
public class No11653 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
				
		while(N > 1) {
			for(int i = 2; i <= N; i++) {
				if(N%i == 0) {
					System.out.println(i);
					N /= i;
					break;
				}
			}
		}
	}

}
