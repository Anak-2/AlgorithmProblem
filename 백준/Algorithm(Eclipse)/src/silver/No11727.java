package silver;

import java.util.*;
import java.io.*;

// 2xn ≈∏¿œ∏µ 2
public class No11727 {
	static int cnt = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] prev = new int[2];
		prev[0] = 1;
		prev[1] = 3;
		int current = 0;
		for (int i = 3; i <= n; i++) {
			current = (prev[0]*2 + prev[1]) % 10007;
			prev[0] = prev[1];
			prev[1] = current;
		}
		if (n == 1) {
			System.out.println(1);
		} else {
			System.out.println(prev[1] % 10007);
		}
	}

}
