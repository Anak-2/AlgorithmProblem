package silver;

import java.util.*;
import java.io.*;

/*
 * �� �������� ������� ��!
 * 
 * �ڹ��� int�� 4����Ʈ�� -2^31 ~ 2^31 ���� ��Ÿ�� �� �ִ� (10^9 �ڸ�)
 * int ������ �Ѿ�� ���� �����Ϸ��� �ϸ� ������ �߻��ϴ� ��� �����÷ο찡 �߻��Ͽ� ����� �ٸ� ����� ����ȴ�
 * (ex. ū ����� ������ int�� 2�踦 �� ��� ���̳ʽ��� �����÷ο� �߻�, �ݴ�� ����÷ο�)
 * 
 * 10^9 ������ int �ڷ��� �ȿ� �־ �ʰ��ϴ� ��� queue�� �� �ֵ��� �غ�����
 * int A = 10^9 * 10 + 1 �� �� ���
 * A�� 1410065409 �� ������ �����÷ο� �ż� �ʰ��Ǵ� ��츦 �Ÿ��� ����� -> �׳� long (8����Ʈ) ����!
 */
// A -> B
public class No16953 {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long start = Integer.parseInt(st.nextToken());
		long target = Integer.parseInt(st.nextToken());
		
		long ans = Integer.MAX_VALUE;
//		���� ���� value�� �� �ܰ����� stage�� �����ϴ� ť
		ArrayList<long[]> queue = new ArrayList<>();
		queue.add(new long[] {start, 1});
		
		while(!queue.isEmpty()){
			long[] cur = queue.remove(0);
//			System.out.println(cur[0]);
			if(cur[0] == target) {
				if(ans > cur[1]) {
					ans = cur[1];
				}
				continue;
			}
			if(cur[0] * 2 <= target) {
//				���� �� ���� ������ �̹� ���� ��� ť�� �߰� x
				if(cur[1] < ans) {					
					queue.add(new long[]{cur[0] * 2, cur[1] +1});
				}
			}
			if(cur[0] * 10 + 1 <= target) {
				if(cur[1] < ans) {					
					queue.add(new long[]{cur[0] * 10 + 1, cur[1] +1});
				}
			}
		}
		
		if(ans != Integer.MAX_VALUE) {
			System.out.println(ans);
		}else {
			System.out.println(-1);
		}
	}
}
