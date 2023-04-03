package gold;

import java.util.*;
import java.io.*;

// 감소하는 수
public class No1038 {
    static List<Long> list = new ArrayList<>();
    static int count = 0;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (N <= 10) {
            System.out.print(N);
            return;
        } else if (N >= 1023) {
            System.out.print(-1);
            return;
        }
        for (int i = 0; i < 10; i++) {
            DFS(i);
        }
        Collections.sort(list);
        System.out.print(list.get(N));
    } // End of main

    private static void DFS(long num) {
        list.add(num);
        long modValue = num % 10;
        if (modValue == 0) {
            return;
        }

//        만약 num이 98이 들어오면
//        modValue = 8
//        i = 7 ~ 0
//        newValue는 987 ~ 980
//        최대 9876543210이 끝이므로 무한 루프에 안 빠짐
        for (long i = modValue - 1; i >= 0; i--) {
            long newValue = num * 10 + i;
//            System.out.println(newValue);
            DFS(newValue);
        }
    } // End of DFS
} // End of Main class