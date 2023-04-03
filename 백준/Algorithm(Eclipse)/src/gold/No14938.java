package gold;

import java.io.*;
import java.util.*;

public class No14938 {
	static int INFINITY = 10000;
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
//		������ ����
		int n = Integer.parseInt(st.nextToken());
//		���� ����
		int m = Integer.parseInt(st.nextToken());
//		���� ����
		int r = Integer.parseInt(st.nextToken());		
		
		st = new StringTokenizer(br.readLine());
//		�� ������ ������ ����
		int[] v = new int[n+1];
//		�� ������ �湮 ����
		int[] isVisit = new int[n+1];
//		�� ������ �ִ�� ���� �� �ִ� ������, int[] �� primitive array�̱� ������ T[]�� �Ű�������
//		�۵����� �ʴ´�. �׷��� Integer[]�� ����!!!!
		Integer[] maxItem = new Integer[n+1];
//		Integer �迭�� ������ �� �ڵ����� 0���� �ʱ�ȭ ���� �ʱ� ������ �ʱ�ȭ�� ���� ���ش�
		Arrays.fill(maxItem, 0);
		for(int i = 1; i <= n; i++) {
			v[i] = Integer.parseInt(st.nextToken());
		}
		
//		���� ����
		int[][] e = new int[n+1][n+1];
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				e[i][j] = INFINITY;
				if(i==j) {
					e[i][j] = 0;
				}
			}
		}
		
		for(int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			e[start][end] = distance;
			e[end][start] = distance;
		}
	
		
//		�÷��̵� ����
		for(int i = 1; i < n+1; i++) {
			for(int j = 1; j < n+1; j++) {
				for(int k = 1; k < n+1; k++) {
					if(i==j || j==k || i==j) continue;
					if(e[j][i] + e[i][k] < e[j][k]) {
						e[j][k] = e[j][i] + e[i][k];
					}
				}
			}
		}
		
//		�� ������ ��������� ���� �� ������ ����
		for(int i = 1; i < n+1; i++) {
			for(int j = 1; j < n+1; j++) {
				if(e[i][j] <= m) {
					maxItem[i] += v[j];
				}
			}
		}
		
//		�������� ����
		Arrays.sort(maxItem, Collections.reverseOrder());
		System.out.println(maxItem[0]);
		
//		���� ���� ���
//		for(int i = 1; i <= n; i++) {
//			for(int j = 1; j <= n; j++) {
//				if(e[i][j] == INFINITY) {
//					System.out.print("INF ");
//				}
//				else {						
//					System.out.print(e[i][j]+" ");
//				}
//			}
//			System.out.println();
//		}
		
	}

//	Java MinHeap ���̺귯��
//	PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
}
