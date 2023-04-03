package gold;

import java.util.*;
import java.io.*;

// 여왕벌
public class No10836 {

	static int N;
	static int M;
	static int[][] arr;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 격자 크기
		M = Integer.parseInt(st.nextToken());
		// 날짜
		N = Integer.parseInt(st.nextToken());
		// 격자 정보 저장할 배열, 1,2 번째 칸에 위치 기록
		arr = new int[M][M];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = 1;
			}
		}
		// 제일 왼, 위칸 성장
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int zero = Integer.parseInt(st.nextToken());
			int one = Integer.parseInt(st.nextToken());
			int two = Integer.parseInt(st.nextToken());
			// 제일 왼쪽 열 애벌레 키우기
			for (int i = M - 1; i > 0; i--) {
				if (zero != 0) {
					zero--;
				} else if (one != 0) {
					one--;
					arr[i][0] += 1;
				} else if (two != 0) {
					two--;
					arr[i][0] += 2;
				}
			}

			// 제일 위쪽 행 애벌레 키우기
			for (int i = 0; i < M; i++) {
				if (zero != 0) {
					zero--;
				} else if (one != 0) {
					one--;
					arr[0][i] += 1;
				} else if (two != 0) {
					two--;
					arr[0][i] += 2;
				}
			}
		}
//			나머지 성장
		growthRest();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

//	나머지 애벌레들 성장시키는 함수
	public static void growthRest() {
		for (int i = 1; i < M; i++) {
			for (int j = 1; j < M; j++) {
//				위에 값이 가장 큰 성장
				arr[i][j] = arr[0][j];
			}
		}
	}
}
