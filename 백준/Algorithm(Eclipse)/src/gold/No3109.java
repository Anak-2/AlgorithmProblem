package gold;

import java.util.*;
import java.io.*;

public class No3109 {
    static char[][] arr;
    static int n;
    static int m;
    static int[] dr = {-1,0,1};
    static int[] dc = {1,1,1};
    static int answer = 0;
    public static void main(String []args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new char[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = st.nextToken().toCharArray();
        }
        boolean[][] visited = new boolean[n][m];
       for(int i = 0; i < n; i++) {
    	   if(dfs(i,0,visited)) answer++;
       }
       System.out.println(answer);
    }
    
    public static boolean dfs(int r, int c, boolean[][] visited){
    	visited[r][c] = true;
        if(c == m-1){
          return true;
        }
        int nextR;
        int nextC;
        for(int i = 0; i < 3; i++){
            nextR = r+dr[i];
            nextC = c+dc[i];
            if(nextR >= 0 && nextR < n && nextC < m){
                if(!visited[nextR][nextC] && arr[nextR][nextC] == '.') {
//                	System.out.println("visit");
                	if(dfs(nextR, nextC, visited)) return true;
                }
            }
        }
        return false;
    }
}
