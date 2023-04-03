package gold;

import java.util.*;
import java.io.*;

// 타임머신, 벨만 포드 잘못 구현했다 -> 벨만포드는 시작점 -> 다른 노드만 궁금한 알고리즘이므로
// dist 배열 1개와 나머지 연결된 엣지만 알면된다
public class No11657 {

    public static class City{
        int end;
        int weight;

        public City(int end, int weight){
            this.end = end;
            this.weight = weight;
        }
    }

    static int N;
    static int M;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ArrayList<City>[] cityList = new ArrayList[N+1];
        for(int i = 1; i < N+1; i++){
            cityList[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            cityList[a].add(new City(b,c));
        }
        long[] dist = new long[N+1];
        for(int i = 0; i < N+1; i++){
            dist[i] = Integer.MAX_VALUE/2;
        }
        dist[1] = 0;
//        for(City city : cityList[1]){
//            dist[city.end] = city.weight;
//        }
        long[] ans = bellman(cityList, dist);
        if(ans == null){
            System.out.println(-1);
            return;
        }
        for(int i = 2; i < N+1; i++){
            if(ans[i] == Integer.MAX_VALUE/2){
                System.out.println(-1);
            }else{
                System.out.println(ans[i]);
            }
        }
    }

    public static long[] bellman(ArrayList<City>[] cityList, long[] dist){
        boolean changed;
        for(int t = 0; t < N-1; t++){
            changed = false;
            for(int k = 1; k < N+1; k++) {
                // i -> k -> j 와 i -> j 비교해서 더 작은 값!
                if(dist[k] == Integer.MAX_VALUE/2) continue;
                for(City city : cityList[k]){
                    if(dist[city.end] > dist[k] + city.weight){
                        dist[city.end] = dist[k] + city.weight;
                        changed = true;
                    }
                }
            }
            if(!changed) break;
        }
//        마지막 1바퀴 돌면서 음의 순환 루프 있는지 확인
        changed = false;
        firstFor:
        for(int k = 1; k < N+1; k++) {
            // i -> k -> j 와 i -> j 비교해서 더 작은 값!
            if(dist[k] == Integer.MAX_VALUE/2) continue;
            for(City city : cityList[k]){
                if(dist[city.end] > dist[k] + city.weight){
                    changed = true;
                    break firstFor;
                }
            }
        }
        if(changed) return null;
        return dist;
    }
}
