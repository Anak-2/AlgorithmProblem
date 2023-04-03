package silver;

import java.io.*;
import java.util.*;

// ���� ����
public class No10972 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int a[] = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		if(next_Permutation(a)) {
			for(int val : a) {
				sb.append(val).append(" ");
			}
		}else {
			sb.append("-1");
		}
	
		System.out.println(sb);
	}

	public static boolean next_Permutation(int a[]) {
		int i = a.length-1;
		
		//1. A[i-1] < A[i] �� �����ϴ� ���� ū i�� ã�´�.
		while(i > 0 && a[i-1] >= a[i]) {
			i -= 1;
		}
		
		//i�� ��ġ�� 0�̸� ��������(������ ����)
		if(i<=0) return false; 
		
		int j = a.length - 1;
		
		//2. j >= i �̸鼭 A[j] > A[i-1] �� �����ϴ� ���� ū j�� ã�´�.
		while(a[i-1] >= a[j]) {
			j -= 1;
		}
		
		//3. A[i-1]�� A[j] �� swap �Ѵ�.
		int temp = a[j];
		a[j] = a[i-1];
		a[i-1] = temp;
		
		j = a.length-1;
		
		
		//4. A[i] ���� ������ �����´�.
		while(i < j) {
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i += 1;
			j -= 1;
		}
				
		return true;
	}
}