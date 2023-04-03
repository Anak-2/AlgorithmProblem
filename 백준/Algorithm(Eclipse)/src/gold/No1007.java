package gold;

import java.util.*;
import java.io.*;

// 벡터 매칭 (인터넷 참고한 문제)
public class No1007 {
	
	private static double result;
//	시작점으로 선택된 벡터 저장
	private static boolean[] isChecked;
//	좌표들 저장
	private static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 케이스 수
		int testCase = Integer.parseInt(br.readLine());

		for (int i = 0; i < testCase; i++) {
			// 점의 갯수
			int n = Integer.parseInt(br.readLine());
			result = Double.MAX_VALUE;

			isChecked = new boolean[n];

			arr = new int[n][2];

			for (int j = 0; j < n; j++) {
				String[] temp = br.readLine().split(" ");

				arr[j][0] = Integer.parseInt(temp[0]);
				arr[j][1] = Integer.parseInt(temp[1]);
			}

//			n개의 좌표 중 n/2개를 골라 시작점으로 만들기 위한 조합 함수
			combination(0, n / 2);

			System.out.println(result);
		}

	}
	
	private static void combination(int index, int count) {
		if(count == 0) {
			result = Math.min(result, getVector());
		}
		else {
			for(int i = index; i < isChecked.length; i++) {
				isChecked[i] = true;
				combination(i+1, count-1);
				isChecked[i] = false;
			}
		}
	}
	
//	벡터는 "끝점 - 시작점" 인데, 벡터들의 합은 x,y 좌표의 덧셈이므로 "(끝점 모두 더한 값) - (시작점 모두 더한 값)"을 하면
//	벡터들의 총합을 쉽게 구할 수 있다!
	private static double getVector()
    {
        int x = 0;
        int y = 0;
        
        for (int i = 0; i < arr.length; i++)
        {
            // 양수로 선택된 점일 경우
            if (isChecked[i])
            {
                x += arr[i][0];
                y += arr[i][1];
            }
            
            // 음수로 선택된 점일 경우
            else
            {
                x -= arr[i][0];
                y -= arr[i][1];
            }
        }
        
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

}
