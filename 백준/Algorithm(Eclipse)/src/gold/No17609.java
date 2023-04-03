package gold;

import java.util.*;
import java.io.*;

// 회문
public class No17609 {

	static HashMap<Character, Integer> map;
	
//	문제를 잘못 읽은 치명적인 실수... 유사회문에서 같지 않은 문자를 1번 바꾸는 것도 가능한 줄 알고 뻘짓했다!!!!
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		char[] charArr;
		for(int i = 0; i < T; i++) {
			map = new HashMap<>();
			charArr = br.readLine().toCharArray();
			int middle = 0;
			
//			각 알파벳의 출현 개수
			for(int j = 0; j < charArr.length; j++) {
				if(map.containsKey(charArr[j])) {
					map.replace(charArr[j], map.get(charArr[j]) + 1);
				}else {
					map.put(charArr[j], 1);
				}
			}
			
////			문자열의 길이가 짝수인지 체크해서 가운데 idx 저장
//			boolean evenCheck = false;
//			if(charArr.length % 2 == 0) {
//				evenCheck = true;
//				middle = charArr.length/2;
//			}
//			else {
////				가운데 있는 알파벳은 출현 개수 하나 빼주기
//				middle = charArr.length/2;
//				map.replace(charArr[middle], map.get(charArr[middle]) - 1);
//			}
			
//			for(char key : map.keySet()) {
//				System.out.println(String.format("키 : %s, 값 : %s", key, map.get(key)));
//			}
			
//			투 포인터로 만들기
//			left pointer
			int pl = 0;
//			right pointer
			int pr = charArr.length - 1;
//			chance는 1번 주고 펠린드롬 검사
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
	
//	펠린드롬을 검사하기 위한 투포인트 함수
	public static int twoPoint(int pl, int pr, char[] charArr, int chance) {
		while(pl < pr) {
//			System.out.println("pl: "+pl+" pr: "+pr);
			if(charArr[pl] != charArr[pr]) {
				if(chance > 0) {
					chance -= 1;
//					왼쪽을 삭제
					int a = twoPoint(pl+1, pr, charArr, chance);
//					오른쪽을 삭제
					int b = twoPoint(pl, pr-1, charArr, chance);
//					둘 중 하나도 펠린드롬이 아니라면 일반문으로 표시
					if(a != 0 && b != 0){
						chance = -1;
					}
				}
				else {
//					문자를 삭제할 찬스를 이미 다 썼다면 일반문
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
