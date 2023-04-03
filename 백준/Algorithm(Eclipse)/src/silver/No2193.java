package silver;

import java.util.*;
import java.io.*;

// ��ģ��
public class No2193 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
//		������ 0�� �� ����� ���� ����ϴ� �迭
		long[] dpZero = new long[N+1];
//		������ 1�� �� ����� ���� ����ϴ� �迭
		long[] dpOne = new long[N+1];
		dpOne[1] = 1;
		for(int i = 1; i < N; i++) {
			dpZero[i+1] = dpZero[i] + dpOne[i];
			dpOne[i+1] = dpZero[i];
		}
		System.out.println(dpZero[N] + dpOne[N]);
	}

}
