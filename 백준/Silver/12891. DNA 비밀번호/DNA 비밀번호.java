
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        Map<String, Integer> cur = new HashMap<>();
        cur.put("A",0);
        cur.put("C",0);
        cur.put("G",0);
        cur.put("T",0);
        char[] dna = br.readLine().toCharArray();
        Map<String, Integer> require = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
            int num = Integer.parseInt(st.nextToken());
            if(i == 0){
                require.put("A",num);
            }else if(i == 1){
                require.put("C",num);
            }else if(i == 2){
                require.put("G",num);
            }else{
                require.put("T",num);
            }
        }

        for(int i = 0; i < P; i++){
            increaseOne(cur, dna[i]);
        }

        int answer = 0;
        if(compareMap(cur, require)) {
            answer++;
        }
        // 슬라이딩
        for(int i = P; i < S; i++){
            increaseOne(cur,dna[i]);
            decreaseOne(cur,dna[i-P]);
            if(compareMap(cur, require)){
                answer++;
            }
        }

        System.out.println(answer);
    }

    // 부분 문자열 검사
    private static boolean compareMap(Map<String, Integer> acgt, Map<String, Integer> require){
        for(Map.Entry<String, Integer> entry : require.entrySet()){
            if(entry.getValue() > acgt.get(entry.getKey())){
                return false;
            }
        }
        return true;
    }

    private static void increaseOne(Map<String, Integer> cur, char c){
        String curChar = String.valueOf(c);
        cur.put(curChar, cur.get(curChar) + 1);
    }

    private static void decreaseOne(Map<String, Integer> cur, char c){
        String curChar = String.valueOf(c);
        cur.put(curChar, cur.get(curChar) - 1);
    }
}
