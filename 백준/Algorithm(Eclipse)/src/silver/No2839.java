package silver;

import java.util.*;
import java.io.*;

// ¼³ÅÁ ¹è´Þ
public class No2839 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int ans = 0;
		int quotient = N/5;
		int remainder = N%5;
		if(remainder == 0) {
			System.out.println(quotient);
		}else if(remainder == 1 && quotient >= 1) {
			System.out.println(quotient+1);
		}else if(remainder == 2 && quotient >= 2) {
			System.out.println(quotient+2);
		}else if(remainder == 3) {
			System.out.println(N/5+1);
		}else if(remainder == 4 && quotient >= 1){
			System.out.println(quotient+2);
		}else {
			System.out.println(-1);
		}
	}

}
