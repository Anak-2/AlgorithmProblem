

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 정수 배열 크기
        N = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> plusList = new PriorityQueue<>((a,b) -> b-a);
        PriorityQueue<Integer> minusList = new PriorityQueue<>();
        Deque<Integer> oneList = new LinkedList<>();
        Deque<Integer> zeroList = new LinkedList<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cur = Integer.parseInt((st.nextToken()));
            if(cur > 1) {
                plusList.add(cur);
            }else if (cur < 0) {
                minusList.add(cur);
            }else if (cur == 1) {
                oneList.add(cur);
            }else {
                zeroList.add(cur);
            }
        }

        int ans = 0;

        while(minusList.size() > 1) {
            int a = minusList.poll();
            int b = minusList.poll();

            ans += a * b;
        }
        while(plusList.size() > 1) {
            int a = plusList.poll();
            int b = plusList.poll();

            ans += a * b;
        }
        if(!plusList.isEmpty()) {
            ans += plusList.poll();
        }

        if(minusList.size() == 1) {
            if(!zeroList.isEmpty()){
                int a = minusList.poll();
                int b = zeroList.poll();
                ans += a*b;
            } else {
                ans += minusList.poll();
            }
        }

        ans += oneList.size();

        System.out.println(ans);
    }
}
