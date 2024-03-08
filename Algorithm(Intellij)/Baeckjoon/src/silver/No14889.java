package silver;

import java.io.*;
import java.util.*;

public class No14889 {
    static int[][] map;
    static int N;
    static int ans = Integer.MAX_VALUE/2;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        boolean[] visited = new boolean[N];
        getCombination(0,0,visited);
        System.out.println(ans);
    }

//    start 에서 n 개를 고르는 함수 (순서 상관 x)
    private static void getCombination(int start, int n, boolean[] visited){
        ArrayList<Integer> teamStart = new ArrayList<>();
        ArrayList<Integer> teamLink = new ArrayList<>();
        if(n == N/2){
            for(int i = 0; i < visited.length; i++){
                if(visited[i]){
                    teamStart.add(i);
                }else{
                    teamLink.add(i);
                }
            }
            ans = Math.min(ans, getSumDiff(teamStart, teamLink));
            return;
        }
        for(int i = start; i < N; i++){
            visited[i] = true;
            getCombination(i+1, n+1, visited);
            visited[i] = false;
        }
    }

    private static int getSumDiff(ArrayList<Integer> teamStart, ArrayList<Integer> teamLink){
        int teamStartSum = 0;
        int teamLinkSum = 0;
        for(int i = 0; i < teamStart.size(); i++){
            for(int j = i; j < teamStart.size(); j++){
                if(i != j){
                    int indexI = teamStart.get(i);
                    int indexJ = teamStart.get(j);
                    teamStartSum += map[indexI][indexJ];
                    teamStartSum += map[indexJ][indexI];
                }
            }
        }
        for(int i = 0; i < teamLink.size(); i++){
            for(int j = i; j < teamLink.size(); j++){
                if(i != j){
                    int indexI = teamLink.get(i);
                    int indexJ = teamLink.get(j);
                    teamLinkSum += map[indexI][indexJ];
                    teamLinkSum += map[indexJ][indexI];
                }
            }
        }
        return Math.abs(teamStartSum - teamLinkSum);
    }
}
