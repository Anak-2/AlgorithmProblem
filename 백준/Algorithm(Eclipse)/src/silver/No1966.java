package silver;

import java.util.*;
import java.io.*;

// ������ ť
public class No1966 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
//		�׽�Ʈ ���̽�
		int T = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int[] prio = new int[N];
			for(int j = 0; j < N; j++) {
				prio[j] = Integer.parseInt(st.nextToken());
			}
			System.out.println(solution(M, prio));
		}
	}
//	(�ñ��� ������ idx, �߿䵵 ������ �迭)
	public static int solution(int idx, int[] prio) {
		int answer = 0;
//		printPrio (����Ʈ ���� idx, ����Ʈ �߿䵵)
		ArrayList<Integer[]> printPrio = new ArrayList<Integer[]>();
		for(int i = 0; i < prio.length; i++) {
			printPrio.add(new Integer[] {i, prio[i]});
		}
//		�迭 �� ����Ʈ �߿䵵�� ���� ū �߿䵵 ã��
		int maxPrio = 0;
//		�̴� ����
		int select = 1;
		Integer[] element;
		while(!printPrio.isEmpty()) {
			maxPrio = findMaxPrio(printPrio);
			while(true) {
				if(printPrio.get(0)[1] == maxPrio) {
					element = printPrio.remove(0);
					if(element[0] == idx) return select;
					else {
						select++;
						break;
					}
				}else {
					element = printPrio.remove(0);
					printPrio.add(element);
				}
			}
		}
		return answer;
	}
	
	public static int findMaxPrio(ArrayList<Integer[]> printPrio) {
		int max = 0;
		for(int i = 0; i < printPrio.size(); i++) {
			if(printPrio.get(i)[1] > max) {
				max = printPrio.get(i)[1];
			}
		}
		return max;
	}
}
