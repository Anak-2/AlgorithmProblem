package silver;

import java.util.*;
import java.io.*;

/*
 * 이 문제에서 배워야할 점!
 * 
 * 자바의 int는 4바이트로 -2^31 ~ 2^31 까지 나타낼 수 있다 (10^9 자리)
 * int 범위를 넘어가는 수를 저장하려고 하면 에러가 발생하는 대신 오버플로우가 발생하여 예상과 다른 결과가 저장된다
 * (ex. 큰 양수를 저장한 int에 2배를 할 경우 마이너스로 오버플로우 발생, 반대는 언더플로우)
 * 
 * 10^9 까지라 int 자료형 안에 있어서 초과하는 경우 queue에 안 넣도록 해봤지만
 * int A = 10^9 * 10 + 1 을 할 경우
 * A는 1410065409 란 값으로 오버플로우 돼서 초과되는 경우를 거르기 힘들다 -> 그냥 long (8바이트) 쓰자!
 */
// A -> B
public class No16953 {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long start = Integer.parseInt(st.nextToken());
		long target = Integer.parseInt(st.nextToken());
		
		long ans = Integer.MAX_VALUE;
//		현재 값인 value와 몇 단계인지 stage를 저장하는 큐
		ArrayList<long[]> queue = new ArrayList<>();
		queue.add(new long[] {start, 1});
		
		while(!queue.isEmpty()){
			long[] cur = queue.remove(0);
//			System.out.println(cur[0]);
			if(cur[0] == target) {
				if(ans > cur[1]) {
					ans = cur[1];
				}
				continue;
			}
			if(cur[0] * 2 <= target) {
//				만약 더 작은 정답이 이미 있을 경우 큐에 추가 x
				if(cur[1] < ans) {					
					queue.add(new long[]{cur[0] * 2, cur[1] +1});
				}
			}
			if(cur[0] * 10 + 1 <= target) {
				if(cur[1] < ans) {					
					queue.add(new long[]{cur[0] * 10 + 1, cur[1] +1});
				}
			}
		}
		
		if(ans != Integer.MAX_VALUE) {
			System.out.println(ans);
		}else {
			System.out.println(-1);
		}
	}
}
