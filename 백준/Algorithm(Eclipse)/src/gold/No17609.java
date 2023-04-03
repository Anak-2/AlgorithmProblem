package gold;

import java.util.*;
import java.io.*;

// ȸ��
public class No17609 {

	static HashMap<Character, Integer> map;
	
//	������ �߸� ���� ġ������ �Ǽ�... ����ȸ������ ���� ���� ���ڸ� 1�� �ٲٴ� �͵� ������ �� �˰� �����ߴ�!!!!
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		char[] charArr;
		for(int i = 0; i < T; i++) {
			map = new HashMap<>();
			charArr = br.readLine().toCharArray();
			int middle = 0;
			
//			�� ���ĺ��� ���� ����
			for(int j = 0; j < charArr.length; j++) {
				if(map.containsKey(charArr[j])) {
					map.replace(charArr[j], map.get(charArr[j]) + 1);
				}else {
					map.put(charArr[j], 1);
				}
			}
			
////			���ڿ��� ���̰� ¦������ üũ�ؼ� ��� idx ����
//			boolean evenCheck = false;
//			if(charArr.length % 2 == 0) {
//				evenCheck = true;
//				middle = charArr.length/2;
//			}
//			else {
////				��� �ִ� ���ĺ��� ���� ���� �ϳ� ���ֱ�
//				middle = charArr.length/2;
//				map.replace(charArr[middle], map.get(charArr[middle]) - 1);
//			}
			
//			for(char key : map.keySet()) {
//				System.out.println(String.format("Ű : %s, �� : %s", key, map.get(key)));
//			}
			
//			�� �����ͷ� �����
//			left pointer
			int pl = 0;
//			right pointer
			int pr = charArr.length - 1;
//			chance�� 1�� �ְ� �縰��� �˻�
			int chance = 1;
			chance = twoPoint(pl, pr, charArr, chance);
			if(chance == 1) {
				System.out.println(0);
			}else if(chance == 0) {
				System.out.println(1);
			}else {
				System.out.println(2);
			}
		}
	}
	
//	�縰����� �˻��ϱ� ���� ������Ʈ �Լ�
	public static int twoPoint(int pl, int pr, char[] charArr, int chance) {
		while(pl < pr) {
//			System.out.println("pl: "+pl+" pr: "+pr);
			if(charArr[pl] != charArr[pr]) {
				if(chance > 0) {
					chance -= 1;
//					������ ����
					int a = twoPoint(pl+1, pr, charArr, chance);
//					�������� ����
					int b = twoPoint(pl, pr-1, charArr, chance);
//					�� �� �ϳ��� �縰����� �ƴ϶�� �Ϲݹ����� ǥ��
					if(a != 0 && b != 0){
						chance = -1;
					}
				}
				else {
//					���ڸ� ������ ������ �̹� �� ��ٸ� �Ϲݹ�
					chance = -1;
				}
				break;
			}
			pl++;
			pr--;
		}
		return chance;
	}
}
