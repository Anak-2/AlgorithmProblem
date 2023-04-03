package gold;

import java.util.*;
import java.io.*;

public class No1005 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());

		for (int index = 0; index < testCase; index++) {
//			건물 개수,건설 순서 규칙
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

//			건설하는데 걸리는 시간
			int[] takeTime = new int[n + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				takeTime[i] = Integer.parseInt(st.nextToken());
			}

//			List<Integer>[] buildingArr = new ArrayList<Integer>[n+1]; --> Cannot create a generic array 오류
			List<Integer>[] buildingArr = new ArrayList[n + 1];
			for (int i = 1; i < n + 1; i++) {
				buildingArr[i] = new ArrayList<Integer>();
			}
//			각 노드에 들어오는 엣지 개수를 저장할 배열
			int[] indegree = new int[n+1];
			
//			건물끼리 연결된 정보 저장
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
//				A -> B 로 연결되어있다면 ArrayList에 B -> A 로 저장. 목표 건물에서 거꾸로 살펴보기 위해!
				buildingArr[end].add(start);
			}

//			건설해야할 건물
			st = new StringTokenizer(br.readLine());
			int target = Integer.parseInt(st.nextToken());
			
//			목표 건물에서 출발했을 때 도착하는 건물들만 indegree 고려하기
			Stack<Integer> stack = new Stack<>();
			int[] visited = new int[n+1];
			visited[target] = 1;
			stack.push(target);
			while(!stack.isEmpty()) {
				int curNode = stack.pop();
				for(int nextNode : buildingArr[curNode]) {
//					System.out.println("arriveNode: "+curNode);
//					System.out.println("nextNode: "+nextNode);
					indegree[nextNode]++;
					if(visited[nextNode] == 0) {
						visited[nextNode] = 1;
						stack.push(nextNode);
					}
				}
			}
//			System.out.println("indegree: "+Arrays.toString(indegree));

//			각 건물마다 도달한 시간의 최대값 저장
			int[] maxBuildTime = new int[n + 1];

//			**** [시간 초과 풀이] 그냥 BFS로 할 경우 살펴본 노드를 또 살펴보는 경우 너무 많아짐!!! (최대가 아닐 경우 다시 그 노드를 큐에 집어넣기 때문)
//			**** 예를 들어 4와 이어진 1,2,3을 검사한 뒤 1->2->3 이렇게 연결되어 있으면 2,3을 다시 큐에 넣고 살펴보게됨
//			**** 해결 방안: indegreeArr를 사용하여 연결된 노드 중 들어오는 엣지(indegree)가 0개인 애들만 큐에 추가
		
//			살펴볼 노드들을 저장할 리스트 {현재 노드 번호, 출발점부터 현재 노드까지 걸린 시간}
			List<Integer> nodeList = new ArrayList<>();
			nodeList.add(target);
//			현재 살펴볼 노드
			int curNode = 0;

			int max = 0;
			while (!nodeList.isEmpty()) {
				curNode = nodeList.remove(0);
//				System.out.println("curNode: " + curNode);
//				시작 노드에 도달했을 때 (ArrayList에 연결된 노드가 없을 때 종료)
				if (buildingArr[curNode].size() == 0) {
					if (max < maxBuildTime[curNode] + takeTime[curNode]) {
						max = maxBuildTime[curNode] + takeTime[curNode];
					}
				} else {
					int nextNode = -1;
					int timeTaken = 0;
					for (int j = 0; j < buildingArr[curNode].size(); j++) {
//					다음 방문할 노드
						nextNode = buildingArr[curNode].get(j);
						indegree[nextNode]--;
//					현재 노드가 건설하는데 걸리는 시간
						timeTaken = takeTime[curNode];
//					다음 노드로 도착하는 길 중 가장 오래걸리는 것만 저장!!
						if (maxBuildTime[nextNode] < maxBuildTime[curNode] + timeTaken) {
							maxBuildTime[nextNode] = maxBuildTime[curNode] + timeTaken;
						}
						if (indegree[nextNode] == 0) {
							nodeList.add(nextNode);
						}
					}
				}
			}
			System.out.println(max);
		}
	}
}
