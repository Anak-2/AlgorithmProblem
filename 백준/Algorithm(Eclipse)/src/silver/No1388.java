package silver;

import java.io.*;
import java.util.*;

public class No1388 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		char[][] arr = new char[n][m];
		int answer = 0;

		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		int[][] visit = new int[n][m];
		for (int i = 0; i < n; i++) {
//			System.out.println();
			for (int j = 0; j < m; j++) {
//				System.out.print(arr[i][j]);
				if (visit[i][j] == 0 && arr[i][j] == '-') {
//					System.out.println("- 출력 i: " + i + " j: " + j);
					answer += 1;
					visit[i][j] = 1;
					int k = j + 1;
					while (k < m) {
						if (visit[i][k] == 0 && arr[i][k] == '-') {
							visit[i][k] = 1;
							k++;
						} else
							break;
					}
				} else if (visit[i][j] == 0 && arr[i][j] == '|') {
//					System.out.println("| 출력 i: " + i + " j: " + j);
					answer += 1;
					visit[i][j] = 1;
					int l = i + 1;
					while (l < n) {
						if (visit[l][j] == 0 && arr[l][j] == '|') {
							visit[l][j] = 1;
							l++;
						} else
							break;
					}
				}

			}
		}
		System.out.println(answer);
	}
}
