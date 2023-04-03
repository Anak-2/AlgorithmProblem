package silver;

import java.util.*;
import java.io.*;

public class No2941 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] word = sc.nextLine().toCharArray();
		int length = 0;
		for(int i = 0; i < word.length; i++) {
			if(word[i] == '=') {
				if(i-1 >= 0) {
//					c= , s= 老 锭
					if(word[i-1] == 'c' || word[i-1] == 's') {
						continue;
//						dz= , z= 老 锭
					}else if(word[i-1] == 'z') {
						if(i-2 >= 0 && word[i-2] == 'd') {
							length--;
						}
						continue;
					}
				}
			}else if(word[i] == '-') {
				if(i-1 >= 0) {
//					c- , d- 老 锭
					if(word[i-1] == 'c' || word[i-1] == 'd') {
						continue;
					}
				}
			}else if(word[i] == 'j') {
				if(i-1 >= 0) {					
//				lj , nj 老 锭
					if(word[i-1] == 'n' || word[i-1] == 'l') {
						continue;
					}
				}
			}
			length++;
		}
		System.out.println(length);
	}

}
