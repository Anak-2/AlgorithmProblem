package bronze;

import java.util.*;
import java.io.*;

public class No2775 {
	public static void main(String args[]) throws Exception {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
//		i�� jȣ (i�� 0���� j�� 1���� ����)
		int[][] residents = new int[15][15];
//		0�� �ʱ�ȭ
		for(int j = 1; j < 15; j++) {
			residents[0][j] = j;
		}
//		residents�� ��� �� ���صα�
		for(int i = 1; i < 15; i++) {
			for(int j = 1; j < 15; j++) {
				residents[i][j] = residents[i-1][j] + residents[i][j-1];
			}
		}
		
		int k = 0;
		int n = 0;
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			System.out.println(residents[k][n]);
		}
	}
}
