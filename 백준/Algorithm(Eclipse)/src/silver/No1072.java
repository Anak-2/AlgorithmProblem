package silver;

import java.util.*;
import java.io.*;

// ����
public class No1072 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
//		���� �� Ƚ��
		long X = Integer.parseInt(st.nextToken());
//		�̱� Ƚ��
		int Y = Integer.parseInt(st.nextToken());
//		���� �·�
		int Z = (int)(Y * 100 / X);
		int ans = -1;
//		System.out.println(prevZ);
		int cnt = 0;
//		Z�� 99�� �� �ƹ��� �̰ܵ� 100�� �ȵȴٴ� ��...! �翬�Ѱ� 1���̶� ���� 100%�� �ƴϴ�
		if (Z < 99) {
            ans = (int) Math.ceil((100 * Y - X * (Z + 1)) / (double) (Z - 99));
        }
		System.out.println(ans);
	}

}
