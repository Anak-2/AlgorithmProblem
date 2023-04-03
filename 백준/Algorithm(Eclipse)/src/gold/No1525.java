package gold;

import java.util.*;
import java.io.*;

// 퍼즐
public class No1525 {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String []args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) {
                sb.append(st.nextToken());
            }
        }
        Map<String, Integer> map = new HashMap<>();
        map.put(sb.toString(), 0);
        ArrayList<String> list = new ArrayList<>();
        list.add(sb.toString());
        while(!list.isEmpty()) {
            String cur = list.remove(0);
//            System.out.println(cur);
            int zeroLoc = cur.indexOf('0');
            for(int i = 0; i < 4; i++) {
            	int dx = zeroLoc/3 + dr[i];
            	int dy = zeroLoc%3 + dc[i];
                if(dx >= 0 && dx < 3 && dy >= 0 && dy < 3) {
                	int nextLoc = dx*3 + dy;
                    sb = new StringBuilder(cur);
                    char temp = sb.charAt(nextLoc);
//                    sb.insert는 그 자리에 요소를 넣는 함수!
                    sb.setCharAt(nextLoc, '0');
                    sb.setCharAt(zeroLoc, temp);
                    if(!map.containsKey(sb.toString())) {
                        map.put(sb.toString(), map.get(cur)+1);
                        list.add(sb.toString());
                    }
                }
            }
        }
        if(map.containsKey("123456780")) {
            System.out.println(map.get("123456780"));
        } else {
            System.out.println(-1);
        }
    }
}