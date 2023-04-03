package silver;

import java.util.*;
import java.io.*;

// 프린터 큐
public class No1966 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
//		테스트 케이스
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
//	(궁금한 문서의 idx, 중요도 저장한 배열)
	public static int solution(int idx, int[] prio) {
		int answer = 0;
//		printPrio (프린트 원래 idx, 프린트 중요도)
		ArrayList<Integer[]> printPrio = new ArrayList<Integer[]>();
		for(int i = 0; i < prio.length; i++) {
			printPrio.add(new Integer[] {i, prio[i]});
		}
//		배열 중 프린트 중요도가 제일 큰 중요도 찾기
		int maxPrio = 0;
//		뽑는 순서
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
