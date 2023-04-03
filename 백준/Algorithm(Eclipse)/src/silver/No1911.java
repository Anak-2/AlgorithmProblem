package silver;

import java.util.*;
import java.io.*;

public class No1911 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		LinkedList<int[]> road = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			road.add(new int[] { start, end });
		}
		Collections.sort(road, (a, b) -> a[0] - b[0]);
		int prevBridge = 0;
		int pondLength = 0;
		int requireBridge = 0;
		for (int[] pond : road) {
			if (prevBridge > pond[0]) {	
				if(prevBridge >= pond[1]) {
					continue;
				}
				pond[0] = prevBridge;
			}
			pondLength = pond[1] - pond[0];
			if (pondLength % L == 0) {
				requireBridge += pondLength / L;
			} else {
				requireBridge += pondLength / L + 1;
				prevBridge = pond[1] + (L - pondLength % L);
			}
		}
		System.out.println(requireBridge);
	}

}