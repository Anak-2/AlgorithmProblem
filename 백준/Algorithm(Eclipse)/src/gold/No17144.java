package gold;

import java.util.*;
import java.io.*;

public class No17144 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[r][c];
//		���� û���� ��ġ
		int[] airClean = new int[2];
		int a = 0;
		
		for(int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < c; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == -1) {
					airClean[a] = i;
					a++;
				}
			}
		}
		
		int ans = 0;
		
		for(int i = 0; i < t; i++) {
			dustDiffusion(arr);
			airBlow(arr, airClean);
		}
		for(int[] j : arr) {
			for(int k : j) {
//				System.out.printf("%3d|",k);
				if(k > 0) {
					ans += k;
				}
			}
//			System.out.println();
		}
		System.out.println(ans);
	}
	
//	�̼����� Ȯ��
	private static void dustDiffusion(int[][] arr) {
		int r = arr.length;
		int c = arr[0].length;
		
//		arr�� ��������� �ݿ��ϱ� ���� tempArr
		int[][] tempArr = new int[r][c];
		for(int i = 0; i < arr.length; i++) {
			tempArr[i] = Arrays.copyOf(arr[i], arr[i].length);
		}
		
		int[] dr = {0, 0, -1, 1};
		int[] dc = {-1, 1, 0, 0};
		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
//				������ ���� ���
				if(tempArr[i][j] > 0) {
//					System.out.println("����: "+tempArr[i][j]);
//					4�������� Ȯ��, cnt�� Ȯ��� ĭ
					int cnt = 0;
//					Ȯ�� �Ǳ� �� �̼����� ��
					int prevDustAmount = tempArr[i][j];
					for(int k = 0; k < dr.length; k++) {
						if(0 <= i + dr[k] && i + dr[k] < r && 0 <= j + dc[k] && j + dc[k] < c) {
//							System.out.println("("+(i+dr[k])+","+(j+dc[k])+")�� Ȯ��!");
//							Ȯ��� ���� ����û���Ⱑ �ƴ� ��
							if(tempArr[i+dr[k]][j+dc[k]] != -1) {
								arr[i+dr[k]][j+dc[k]] += prevDustAmount/5;
								cnt += 1;
							}
						}
					}
					arr[i][j] -= prevDustAmount/5*cnt;
				}
			}
		}
	}
	
//	����û���� �ٶ�
	private static void airBlow(int[][] arr, int[] airClean) {
		int r = arr.length;
		int c = arr[0].length;
		
//		����û���� ��, �Ʒ��κ��� row
		int top = airClean[0];
		int bottom = airClean[1];
		
		int prevDist = 0;
		int[] topAirLoc = new int[] {top, 0};
		int[] bottomAirLoc = new int[] {bottom, 0};
		
//		����û���� ���κ� �̵�
		prevDist = pushRight(arr, topAirLoc, prevDist);
		prevDist = pushUp(arr, topAirLoc, prevDist);
		prevDist = pushLeft(arr, topAirLoc, prevDist);
		prevDist = pushDown(arr, topAirLoc, prevDist);
		
		prevDist = 0;
//		����û���� �Ʒ��κ� �̵�
		prevDist = pushRight(arr, bottomAirLoc, prevDist);
		prevDist = pushDown(arr, bottomAirLoc, prevDist);
		prevDist = pushLeft(arr, bottomAirLoc, prevDist);
		prevDist = pushUp(arr, bottomAirLoc, prevDist);
	}
	
//	arr ��� �б� (�̼����� ��, �ٶ� ��ġ, ���� �̼����� ��)
	private static int pushRight(int[][] arr, int[] airLoc, int prevDist) {
		int c = arr[0].length;
		int temp = 0;
		for(airLoc[1] = 1; airLoc[1] < c; airLoc[1]++) {
			temp = arr[airLoc[0]][airLoc[1]];
			arr[airLoc[0]][airLoc[1]] = prevDist;
			prevDist = temp;
		}
		airLoc[1]--;
		return prevDist;
	}
	
//	arr ���� �б�
	private static int pushUp(int[][] arr, int[] airLoc, int prevDist) {
		int r = arr.length;
		int temp = 0;
		for(airLoc[0] = airLoc[0] - 1; airLoc[0] >= 0; airLoc[0]--) {
			temp = arr[airLoc[0]][airLoc[1]];
			if(temp == -1) {
				break;
			}
			arr[airLoc[0]][airLoc[1]] = prevDist;
			prevDist = temp;
		}
		airLoc[0]++;
		return prevDist;
	}
	
//	arr �������� �б�
	private static int pushLeft(int[][] arr, int[] airLoc, int prevDist) {
		int c = arr[0].length;
		int temp = 0;
		for(airLoc[1] = c-2; airLoc[1] >= 0; airLoc[1]--) {
			temp = arr[airLoc[0]][airLoc[1]];
			arr[airLoc[0]][airLoc[1]] = prevDist;
			prevDist = temp;
		}
		airLoc[1]++;
		return prevDist;
	}
	
//	arr �Ʒ��� �б�
	private static int pushDown(int[][] arr, int[] airLoc, int prevDist) {
		int r = arr.length;
		int temp = 0;
		for(airLoc[0] = airLoc[0] + 1; airLoc[0] < r; airLoc[0]++) {
			temp = arr[airLoc[0]][airLoc[1]];
			if(temp == -1) {
				break;
			}
			arr[airLoc[0]][airLoc[1]] = prevDist;
			prevDist = temp;
		}
		airLoc[0]--;
		return prevDist;
	}
}
