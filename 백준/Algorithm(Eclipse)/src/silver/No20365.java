package silver;

import java.util.*;
import java.io.*;

public class No20365 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String len = br.readLine();
		String arr = br.readLine();
		
		int answer = 0;
		
		char nextToken;
		char prevToken = 0;
		
		List<Character> newArr = new ArrayList<>();
		for(int i = 0; i < arr.length(); i++) {
			nextToken = arr.charAt(i);
			if(prevToken == 'B') {
				if(nextToken == 'B') {
					continue;
				}
				else {
					prevToken = 'R';
					newArr.add('R');
				}
			}
			else if(prevToken == 'R') {
				if(nextToken == 'R') {
					continue;
				}
				else {
					prevToken = 'B';
					newArr.add('B');
				}
			}
			else {
				prevToken = nextToken;
				newArr.add(nextToken);
			}
		}
		int bCount = 0;
		int rCount = 0;
		for(char c : newArr) {
			if(c == 'R') {
				rCount++;
			}
			else {
				bCount++;
			}
		}
		if(rCount <= bCount) {
			answer = 1+rCount;
		}
		else {
			answer = 1+bCount;
		}
		System.out.println(answer);
	}
}
