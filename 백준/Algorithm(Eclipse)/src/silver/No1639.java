package silver;

import java.util.*;
import java.io.*;

public class No1639 {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String ticketStr = br.readLine();
		int[] ticket = new int[ticketStr.length()];
		for(int i = 0; i < ticketStr.length(); i++) {
			ticket[i] = (int)(ticketStr.charAt(i)-'0');
		}
		int ticketLen = ticket.length;
		int answer = 0;
		for(int i = 0; i < ticketLen/2; i++) {
			for(int start = 0; start < ticketLen; start++) {
				int check = compareSum(start, i, ticket);
				if(check == -1) {
					break;
				}
				else if(check == 0) {
					continue;
				}
				else if(check == 1) {
					answer = (i+1)*2;
				}
			}
		}
		System.out.println(answer);
	}
	
	private static int compareSum(int start, int i, int[] ticket) {
		int leftSum = 0;
		int rightSum = 0;
		for(int k = start; k < start+i-1; k++) {
			if(k < ticket.length) {				
				leftSum += ticket[k];
			}
			else {
				return -1;
			}
		}
		for(int k = start+i; k < start+i*2-1; k++) {
			if(k < ticket.length) {
				rightSum = ticket[k];
			}
			else {
				return -1;
			}
		}
		if(leftSum == rightSum) {
			return 1;
		}
		else {
			return 0;
		}
	}
}
