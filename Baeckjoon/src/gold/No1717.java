package gold;

import java.util.*;
import java.io.*;

// 집합의 표현 (Union, Find 기본)
public class No1717 {
    static int[] parents;
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        StringBuffer sb = new StringBuffer();
        parents = new int[N+1];
        Arrays.fill(parents, -1);
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int act = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            switch(act){
                case 0:
                    union(a, b);
                    break;
                case 1:
                    if(find(a) == find(b)){
                       sb.append("YES\n");
                    }else{
                        sb.append("NO\n");
                    }
                    break;
            }
        }
        System.out.println(sb);
    }

    public static void union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot == bRoot) return;
        if(aRoot < bRoot) parents[aRoot] = bRoot;
        else parents[bRoot] = aRoot;
    }
    public static int find(int a){
        if(parents[a] == -1) return a;
        a = find(parents[a]);
        return a;
    }
}
