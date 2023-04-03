package gold;

import java.util.*;
import java.io.*;

// 보석 도둑
public class No1202 {
//	처음 접근은 싼 보석들부터 시작해서 가방에 들어갈 수 있으면 넣고 이후 보석이 들어왔을 때 넣을 수 있는 가방에
//	들어온 보석보다 가격이 낮은 보석이 있다면 쫓아내고 쫓겨난 보석은 뒤에 가방을 살펴보면서 자기보다 가격이 낮은 보석을 찾는 것이었다
//	그런데 이러면 최악의 경우 한 보석마다 가방 크기만큼의 for문을 도는 경우 N*K이고  N, K는 30만까지 가능하므로 (3*10^5)^2 경우의 수다

//	만약 허용 무게 순으로 오름차순 정렬된 가방을 for문을 돌면서 현재 가방에 들어갈 수 있는 보석들을 미리 뽑아둔다면
//	가방을 순회할 때 이전 가방에 들어갈 수 있던 보석은 현재 가방에도 들어갈 수 있으므로 중복해서 살펴보는 경우를 대폭 줄여준다
//	또한 보석도 무게 오름차순으로 정렬하면 가방 for문을 돌 때 들어갈 수 있는 보석 중 최대 무게의 보석부터 다시 살펴보므로 경우를 줄여준다
//	최악의 경우의 수도 (가방 개수 * 보석 개수) 이므로 처음 접근보다 루트를 씌운만큼 시간복잡도가 줄어든다

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
//		보석 개수
		int N = Integer.parseInt(st.nextToken());
//		가방 개수
		int K = Integer.parseInt(st.nextToken());
//		보석 정보 저장 배열 (무게, 가격)
		int[][] jewerly = new int[N][2];
//		가방 정보 저장 배열 (허용 무게, 가격, 보석 무게)
		int[][] bag = new int[K][3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			jewerly[i][0] = a;
			jewerly[i][1] = b;
		}
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			bag[i][0] = a;
		}
		

//		가방 허용 무게 순으로 정렬 (a > b 이면 1 반환, a = b 이면 0 반환, a < b 이면 -1 반환)
//		compare가 1이면 스왑 0또는 -1이면 유지
//		sort의 Cmparator클래스 매개변수의 compare를 람다 함수로 구현
//		**람다함수는 functional interface(함수형 인터페이스)를 반환하므로 미구현 함수가 1개만 있는 클래스에만 람다 함수 사용 가능

//		가방 오름차순 정렬
		Arrays.sort(bag, (a, b) -> Integer.compare(a[0], b[0]));
		Arrays.sort(jewerly, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				if (a[0] == b[0]) {
//					무게 같으면 가격 내림차순
					return b[1] - a[1];
				}
//				무게 오름차순
				return a[0] - b[0];
			}
		});

//		for(int[] arr : jewerly) {
//			System.out.println(Arrays.toString(arr));
//		}
//		for(int[] arr : bag) {
//			System.out.println(Arrays.toString(arr));
//		}
		
//		long을 안 쓰면 ans가 오버플로우 돼서 예상과 다른 값 나옴
		long ans = 0;
//		가방에 들어갈 수 있는 보석들의 가격을 넣어두는 MaxHeap
		PriorityQueue<Integer> pQueue = new PriorityQueue<>(Comparator.reverseOrder());
//			살펴본 보석의 index
		int jewerlIndex = 0;
		for (int i = 0; i < K; i++) {
//				가방 허용 무게
			int bagWeight = bag[i][0];
			for (int j = jewerlIndex; j < N; j++) {
//				보석 무게
				int M = jewerly[j][0];
//				보석 가격
				int V = jewerly[j][1];
				
				if(M <= bagWeight) {
					pQueue.add(V);
					jewerlIndex += 1;
				}
				else {
					break;
				}
			}
			if(!pQueue.isEmpty()) {
				int putVal = pQueue.poll();
				System.out.println(putVal);
				ans += putVal;
			}
		}

		System.out.println(ans);
	}

}
