package silver;

import java.util.*;
import java.io.*;

// 회전하는 큐
public class No1021 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Integer> list = new ArrayList<>();
		for(int i = 1; i <= N; i++) {
			list.add(i);
		}
		int cnt = 0;
		int frontPop = 0;
		int backPop = 0;
		int element = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			frontPop = list.indexOf(Integer.parseInt(st.nextToken()));
			backPop = list.size() - frontPop;
			if(frontPop < backPop) {
				cnt += frontPop;
				for(int j = 0; j < frontPop; j++) {
					element = list.remove(0);
					list.add(element);
				}
			}else {
				cnt += backPop;
				for(int j = 0; j < backPop; j++) {
					element = list.remove(list.size()-1);
					list.add(0, element);
				}
			}
			list.remove(0);
		}
		System.out.println(cnt);
	}

}
