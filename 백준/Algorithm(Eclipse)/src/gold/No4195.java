package gold;

import java.util.*;
import java.io.*;

// ģ�� ��Ʈ��ũ
public class No4195 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		List<HashSet<String>> setList;
		while(T > 0) {
			int F = Integer.parseInt(br.readLine());
//			List�� �������̽��̱� ������ list�� ������ ArrayList �ʿ�
			setList = new ArrayList<HashSet<String>>();
			HashSet<String> users = new HashSet<>();
			for(int i = 0; i < F; i++) {
				st = new StringTokenizer(br.readLine());
				String A = st.nextToken();
				String B = st.nextToken();
				HashSet<String> setA = null;
				HashSet<String> setB = null;
//				����� �� �ִ� user���� üũ�ϴ� set, �ִٸ� ���� ģ�� ���� ��Ʈ��ũ ã�� ���ٸ� user�� ���
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
