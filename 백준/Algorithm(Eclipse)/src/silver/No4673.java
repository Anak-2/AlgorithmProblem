package silver;

import java.util.*;
import java.io.*;

// ¼¿ÇÁ ³Ñ¹ö
public class No4673 {

	public static void main(String[] args) {
		boolean[] n = new boolean[15000];
		for(int i = 1; i < 10; i++) {
			n[i+i] = true;
		}
		for(int i = 10; i < 100; i++) {
			n[i + i / 10 + i % 10] = true;
		}
		for(int i = 100; i < 1000; i++) {
			n[i + i / 100 + ((i / 10)  % 10) + i % 10] = true;
		}
		for(int i = 1000; i <= 10000; i++) {
			n[i + (i / 1000) + ((i / 100) % 10) + ((i / 10) % 10 ) + (i % 10)] = true;
		}
		for(int i = 1; i <= 10000; i++) {
			if(!n[i]) System.out.println(i);
		}
		ArrayList<Character[]> left = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		HashMap<Integer, String> map = new HashMap<>();
		String h = "hello";
		char[] charArr = new char[4];

	}

}
