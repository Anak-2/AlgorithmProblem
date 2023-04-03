package gold;

import java.util.*;
import java.io.*;

// 친구 네트워크
public class No4195 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		List<HashSet<String>> setList;
		while(T > 0) {
			int F = Integer.parseInt(br.readLine());
//			List는 인터페이스이기 때문에 list를 구현한 ArrayList 필요
			setList = new ArrayList<HashSet<String>>();
			HashSet<String> users = new HashSet<>();
			for(int i = 0; i < F; i++) {
				st = new StringTokenizer(br.readLine());
				String A = st.nextToken();
				String B = st.nextToken();
				HashSet<String> setA = null;
				HashSet<String> setB = null;
//				등록한 적 있는 user인지 체크하는 set, 있다면 속한 친구 관계 네트워크 찾고 없다면 user에 등록
				if(users.contains(A)) {
					for(HashSet<String> set : setList) {
						if(set.contains(A)) {
							setA = set;
						}
					}
				}else {
					users.add(A);
				}
				if(users.contains(B)) {
					for(HashSet<String> set : setList) {
						if(set.contains(B)) {
							setB = set;
						}
					}
				}else {
					users.add(B);
				}
				
				
				if(setA == null && setB == null) {
					HashSet<String> set = new HashSet<String>();
					set.add(A);
					set.add(B);
					setList.add(set);
					System.out.println(set.size());
				}else if(setA != null && setB == null) {
					setA.add(B);
					System.out.println(setA.size());
				}else if(setA == null && setB != null) {
					setB.add(A);
					System.out.println(setB.size());
				}else if(setA != null && setB != null && setA != setB) {
					setA.addAll(setB);
					setList.remove(setB);
					System.out.println(setA.size());
				}else {
					System.out.println(setA.size());
				}
			}
			T--;
		}
	}

}
