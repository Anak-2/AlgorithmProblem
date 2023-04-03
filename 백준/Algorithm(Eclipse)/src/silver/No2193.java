package silver;

import java.util.*;
import java.io.*;

// 이친수
public class No2193 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
//		이전이 0일 때 경우의 수를 기억하는 배열
		long[] dpZero = new long[N+1];
//		이전이 1일 때 경우의 수를 기억하는 배열
		long[] dpOne = new long[N+1];
		dpOne[1] = 1;
		for(int i = 1; i < N; i++) {
			dpZero[i+1] = dpZero[i] + dpOne[i];
			dpOne[i+1] = dpZero[i];
		}
		System.out.println(dpZero[N] + dpOne[N]);
	}

}
