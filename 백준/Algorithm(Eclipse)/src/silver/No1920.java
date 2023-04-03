package silver;

import java.io.*;
import java.util.*;

// 수 찾기
public class No1920 {

//	이진 탐색(이분 탐색)을 이용한 풀이
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
//		Comparator를 int형으로 했는데, b가 2^31 a가 2^31이 들어왔을 때 오버플로우가 일어나서 오류
		TreeSet<Long> A = new TreeSet<Long>(new Comparator<Long>() {
//			compare 함수는 항상 int를 반환하도록 설계돼있기 때문에 ClassType 예외에 매우 조심하도록 하자!!!!
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
