package silver;

import java.util.*;
import java.io.*;

// 게임
public class No1072 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
//		게임 한 횟수
		long X = Integer.parseInt(st.nextToken());
//		이긴 횟수
		int Y = Integer.parseInt(st.nextToken());
//		현재 승률
		int Z = (int)(Y * 100 / X);
		int ans = -1;
//		System.out.println(prevZ);
		int cnt = 0;
//		Z가 99일 때 아무리 이겨도 100이 안된다는 점...! 당연한게 1판이라도 지면 100%가 아니다
		if (Z < 99) {
            ans = (int) Math.ceil((100 * Y - X * (Z + 1)) / (double) (Z - 99));
        }
		System.out.println(ans);
	}

}
