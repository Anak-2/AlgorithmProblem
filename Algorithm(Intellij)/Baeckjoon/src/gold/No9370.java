package gold;

import java.util.*;
import java.io.*;

// 미확인 도착지, 플로이드 워셜로 풀었다가 시간 초과 (3초라는 긴 시간에도 n^3은 안되나...)
// 만약 다익스트라로 목적지마다 dist 배열을 구하는 것이면 해결 가능했다!
public class No9370 {

    static int n;
    static int m;
    static int t;
    static int s;
    static int g;
    static int h;
    static int MAX = Integer.MAX_VALUE/2;

    public static void main(String[] args) throws Exception{
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine());
//            노드 개수
            n = Integer.parseInt(st.nextToken());
//            엣지 개수
            m = Integer.parseInt(st.nextToken());
//            목적지 후보 개수
            t = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
//            출발점
            s = Integer.parseInt(st.nextToken());
//            지나간 노드1
            g = Integer.parseInt(st.nextToken());
//            지나간 노드2
            h = Integer.parseInt(st.nextToken());

            int[][] map = new int[n+1][n+1];
            for(int[] arr : map){
                Arrays.fill(arr, MAX);
            }
            for(int j = 1; j < n+1; j++){
                map[j][j] = 0;
            }
//            Map 정보 초기화
            for(int j = 0; j < m; j++){
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                map[start][end] = weight;
                map[end][start] = weight;
            }
//            목적지 후보 리스트
            int[] targetList = new int[t];
            for(int j = 0; j < t; j++){
                st = new StringTokenizer(br.readLine());
                targetList[j] = Integer.parseInt(st.nextToken());
            }
            floydWarshall(map);
            ArrayList<Integer> ans = findTarget(map, targetList);
            for(int j : ans){
                sb.append(j+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    public static void floydWarshall(int[][] map){
        for(int i = 1; i < n+1; i++){
            for(int k = 1; k < n+1; k++){
                if(map[i][k] == MAX) continue;
                for(int j = 1; j < n+1; j++){
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }
    }

    public static ArrayList<Integer> findTarget(int[][] map, int[] targetList){
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < targetList.length; i++){
            if(map[s][g] + map[g][h] + map[h][targetList[i]] == map[s][targetList[i]]
                || map[s][h] + map[h][g] + map[g][targetList[i]] == map[s][targetList[i]]){
                ans.add(targetList[i]);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
