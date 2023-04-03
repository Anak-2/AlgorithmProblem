package silver;

import java.io.*;
import java.util.*;

public class No15989 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int itr = Integer.parseInt(br.readLine());
		for(int i = 0; i < itr; i++) {
			System.out.println(getAnswer(Integer.parseInt(br.readLine())));
		}
	}
	
	private static int getAnswer(int i) {
		int answer = 0;
		int onlyOne = 1;
//		2+2+1+...
		int oneWithTwo = i/2; 
//		3+3+1+1+...
		int oneWithThree = i/3;
		int everyNum = 0;
		for(int j = 3; j < i; j+=3) {
			everyNum += (i-j)/2;
		}
		answer = onlyOne + oneWithTwo + oneWithThree + everyNum;
		return answer;
	}

}
