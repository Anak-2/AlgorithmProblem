package platinum;

import java.sql.Array;
import java.util.*;
import java.io.*;

public class No10217 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    //    공항의 수
    static int N;
    //    총 한계 비용
    static int M;
    //    티켓 정보의 수
    static int K;
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
//        테이스 케이스 개수
        int T = Integer.parseInt(st.nextToken());
        for(int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            solution();
        }
    }

    private static void solution() throws Exception{
        ArrayList<Airport>[] airportInfo = new ArrayList[N+1];
        for(int i = 0; i < N+1; i++){
            airportInfo[i] = new ArrayList<>();
        }
        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
//            출발 공항
            int u = Integer.parseInt(st.nextToken());
//            도착 공항
            int v = Integer.parseInt(st.nextToken());
//            비용
            int c = Integer.parseInt(st.nextToken());
//            소요 시간
            int d = Integer.parseInt(st.nextToken());
            airportInfo[u].add(new Airport(v,c,d));
        }
        dijkstra(airportInfo);
    }

    private static void dijkstra(ArrayList<Airport>[] airportInfo){
        PriorityQueue<Airport> stack = new PriorityQueue<>();
//        dp[도착한 공항][도착한 공항까지 소모 비용] = 도착까지 소요 시간
        int[][] dp = new int[N+1][M+1];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE/2);
        }
        stack.add(new Airport(1,0,0));
        while(!stack.isEmpty()) {
            Airport cur = stack.poll();
//            목적지가 최초로 pq 에서 꺼내진다면, 다른 경로보다 가장 적은 시간과 비용을 보장
//            왜냐하면 pq에 남은 경로들은 현재 목적지 경로보다 시간이 클 것이기 때문
            if (cur.arrive == N) {
                break;
            }
            for (Airport next : airportInfo[cur.arrive]) {
                int nextMoney = next.money + cur.money;
//                다음 공항까지 가는데 총 비용이 한계 비용보다 크면 스킵
                if (nextMoney > M) continue;
//                아니라면 다음 공항까지 가는 비용 (nextMoney) 일 때
//                이전 소요 시간과 cur 공항을 거쳐서 가는 소요 시간 중 더 작은 값 대입
                int nextTime = cur.time + next.time;
                if (dp[next.arrive][nextMoney] > nextTime) {
                    dp[next.arrive][nextMoney] = nextTime;
                    stack.add(new Airport(next.arrive, nextMoney, nextTime));
                }
            }
        }
        int ans = Integer.MAX_VALUE/2;
        for(int i = 0; i < M+1; i++){
            if(dp[N][i] != Integer.MAX_VALUE){
                ans = Math.min(ans, dp[N][i]);
            }
        }
        if(ans != Integer.MAX_VALUE/2){
            System.out.println(ans);
        }else{
            System.out.println("Poor KCM");
        }
    }

}
    class Airport implements Comparable<Airport> {
        int arrive;
        int money;
        int time;

        Airport(int arrive, int money, int time) {
            this.arrive = arrive;
            this.time = time;
            this.money = money;
        }

        @Override
        public int compareTo(Airport o) {
            if(this.time < o.time) {
                return -1;
            }
            else if(this.time == o.time) {
                if(this.money < o.money) {
                    return -1;
                }
                return 0;
            }
            return 1;
        }
    }
