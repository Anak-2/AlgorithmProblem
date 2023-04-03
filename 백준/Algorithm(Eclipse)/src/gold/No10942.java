package gold;

import java.util.*;
import java.io.*;

// 팰린드롬?
public class No10942 {

//	처음 접근: 투 포인터를 써서 시작과 끝 점을 하나씩 줄여가며 팰린드롬 검사, 시작 != 끝이면 false
//	시간 초과난 이유: 모든 경우의 수를 보되 중간에 살펴보는 것을 탈출하는 것 만으로는 시간 초과가 났다 (컴퓨터 연산능력을 너무 학대한 안일함 ㅠ)
//	두 번째 접근: 길이가 n+2인 팰린드롬을 검사할 때 양 끝이 같은지 검사와 양 끝을 제외한 길이가 n인 배열이 팰린드롬인지 검사
//				처음 접근과 별 차이가 없을거라 생각했지만 길이가 n+2인 팰린드롬 검사하기 전 길이가 n인 팰린드롬인지 이미 저장해뒀기 때문에 훨씬 연산이 적다
//	세 번째 접근: System을 이용한 출력 느려터졌음... StringBuilder에 담아서 한 번에 출력하기
	static boolean[][] isPalindrome;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		isPalindrome = new boolean[N][N];
		checkPalindrome();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			if (isPalindrome[s - 1][e - 1]) {
				sb.append("1\n");
			}
			else {
				sb.append("0\n");
			}
		}
		System.out.println(sb);
	}

	static void checkPalindrome() {
		int len = arr.length;
//		길이가 1인 문자열의 팰린드롬
		for (int i = 0; i < len; i++) {
			isPalindrome[i][i] = true;
		}
//		길이가 2인 문자열의 팰린드롬
		for (int i = 0; i < len - 1; i++) {
			if (arr[i] == arr[i + 1]) {
				isPalindrome[i][i + 1] = true;
			}
		}
//		길이가 3 이상인 문자열의 팰린드롬
//		만약 길이가 5인 문자열의 팰린드롬을 구한다면 길이가 4인 팰린드롬의 결과값을 이용해서 금방 구할 수 있다
		for (int i = 2; i <= len-1; i++) {
			for (int j = 0; j < len-i; j++) {
				if(arr[j] == arr[j+i] && isPalindrome[j+1][j+i-1]) {
					isPalindrome[j][j+i] = true;
				}
			}
		}
	}
}
