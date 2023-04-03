package silver;

import java.io.*;
import java.util.*;

// �� ã��
public class No1920 {

//	���� Ž��(�̺� Ž��)�� �̿��� Ǯ��
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
//		Comparator�� int������ �ߴµ�, b�� 2^31 a�� 2^31�� ������ �� �����÷ο찡 �Ͼ�� ����
		TreeSet<Long> A = new TreeSet<Long>(new Comparator<Long>() {
//			compare �Լ��� �׻� int�� ��ȯ�ϵ��� ������ֱ� ������ ClassType ���ܿ� �ſ� �����ϵ��� ����!!!!
			@Override
			public int compare(Long a, Long b) {
				int compareResult = (int) (a - b);
				return compareResult;
			}
		});
//		TreeSet<Long> B = new TreeSet<Long>((a,b) -> (int)(a-b));
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			A.add(Long.parseLong(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int question = 0;
		for(int i = 0; i < M; i++) {
			question = Integer.parseInt(st.nextToken());
			long convertedQuestion = question;
			if(A.contains(convertedQuestion)) {
				System.out.println(1);
			}
			else {
				System.out.println(0);
			}
		}
		
		
	}

}
