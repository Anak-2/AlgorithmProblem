

import javax.xml.transform.sax.SAXSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 도시의 수
        int n = Integer.parseInt(st.nextToken());
        // 여행 도시의 수
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        for(int i = 0; i < n+1; i++) {
            arr[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                int node = Integer.parseInt(st.nextToken());
                if(node == 1) {
                    union(i, j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int prev = Integer.parseInt(st.nextToken());
        boolean isOk = true;
        for(int i = 1; i < m; i++) {
            int next = Integer.parseInt(st.nextToken());
            if(find(prev) != find(arr[next])){
                isOk = false;
                break;
            }
        }
        if(isOk){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }

    // 부모끼리 통일
    private static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot != bRoot) {
            // 대표 노드를 변경해한다
            arr[bRoot] = aRoot;
        }
    }

    // 부모 찾기
    private static int find(int a) {
        if(a == arr[a]){
            return a;
        }
        arr[a] = find(arr[a]);
        return arr[a];
    }
}