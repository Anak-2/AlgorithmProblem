

import javax.xml.transform.sax.SAXSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] parents;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N, M;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        List<Integer> partyResult = new ArrayList<>();

        int answer = 0;

        parents = new int[N+1];
        for(int i = 0; i < N+1; i++) {
            parents[i] = i;
        }


        st = new StringTokenizer(br.readLine());
        // 진실을 아는 사람들끼리 통합
        int knowTruth = Integer.parseInt(st.nextToken());
        for(int i = 0; i < knowTruth; i++) {
            int k = Integer.parseInt(st.nextToken());
            parents[k] = 0;
        }

        // 파티마다 통합
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int partyJoin = Integer.parseInt(st.nextToken());

            int prev = Integer.parseInt(st.nextToken());
            for(int j = 1; j < partyJoin; j++) {
                int cur = Integer.parseInt(st.nextToken());
                union(prev, cur);
            }

            partyResult.add(find(prev));
        }

        for(int i = 0; i < M; i++) {
            if(find(partyResult.get(i)) != 0) answer++;
        }

        System.out.println(answer);
    }

    private static void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);

        if(parentA != parentB) {
            if(parentA > parentB) {
                parents[parentA] = parentB;
            }else{
                parents[parentB] = parentA;
            }
        }
    }

    private static int find(int a) {
        if(parents[a] == a) {
            return a;
        }
        return parents[a] = find(parents[a]);
    }
}