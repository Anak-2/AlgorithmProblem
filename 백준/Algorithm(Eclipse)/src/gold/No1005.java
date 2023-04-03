package gold;

import java.util.*;
import java.io.*;

public class No1005 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());

		for (int index = 0; index < testCase; index++) {
//			�ǹ� ����,�Ǽ� ���� ��Ģ
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

//			�Ǽ��ϴµ� �ɸ��� �ð�
			int[] takeTime = new int[n + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				takeTime[i] = Integer.parseInt(st.nextToken());
			}

//			List<Integer>[] buildingArr = new ArrayList<Integer>[n+1]; --> Cannot create a generic array ����
			List<Integer>[] buildingArr = new ArrayList[n + 1];
			for (int i = 1; i < n + 1; i++) {
				buildingArr[i] = new ArrayList<Integer>();
			}
//			�� ��忡 ������ ���� ������ ������ �迭
			int[] indegree = new int[n+1];
			
//			�ǹ����� ����� ���� ����
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
//				A -> B �� ����Ǿ��ִٸ� ArrayList�� B -> A �� ����. ��ǥ �ǹ����� �Ųٷ� ���캸�� ����!
				buildingArr[end].add(start);
			}

//			�Ǽ��ؾ��� �ǹ�
			st = new StringTokenizer(br.readLine());
			int target = Integer.parseInt(st.nextToken());
			
//			��ǥ �ǹ����� ������� �� �����ϴ� �ǹ��鸸 indegree ����ϱ�
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

//			�� �ǹ����� ������ �ð��� �ִ밪 ����
			int[] maxBuildTime = new int[n + 1];

//			**** [�ð� �ʰ� Ǯ��] �׳� BFS�� �� ��� ���캻 ��带 �� ���캸�� ��� �ʹ� ������!!! (�ִ밡 �ƴ� ��� �ٽ� �� ��带 ť�� ����ֱ� ����)
//			**** ���� ��� 4�� �̾��� 1,2,3�� �˻��� �� 1->2->3 �̷��� ����Ǿ� ������ 2,3�� �ٽ� ť�� �ְ� ���캸�Ե�
//			**** �ذ� ���: indegreeArr�� ����Ͽ� ����� ��� �� ������ ����(indegree)�� 0���� �ֵ鸸 ť�� �߰�
		
//			���캼 ������ ������ ����Ʈ {���� ��� ��ȣ, ��������� ���� ������ �ɸ� �ð�}
			List<Integer> nodeList = new ArrayList<>();
			nodeList.add(target);
//			���� ���캼 ���
			int curNode = 0;

			int max = 0;
			while (!nodeList.isEmpty()) {
				curNode = nodeList.remove(0);
//				System.out.println("curNode: " + curNode);
//				���� ��忡 �������� �� (ArrayList�� ����� ��尡 ���� �� ����)
				if (buildingArr[curNode].size() == 0) {
					if (max < maxBuildTime[curNode] + takeTime[curNode]) {
						max = maxBuildTime[curNode] + takeTime[curNode];
					}
				} else {
					int nextNode = -1;
					int timeTaken = 0;
					for (int j = 0; j < buildingArr[curNode].size(); j++) {
//					���� �湮�� ���
						nextNode = buildingArr[curNode].get(j);
						indegree[nextNode]--;
//					���� ��尡 �Ǽ��ϴµ� �ɸ��� �ð�
						timeTaken = takeTime[curNode];
//					���� ���� �����ϴ� �� �� ���� �����ɸ��� �͸� ����!!
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
