package bronze;

import java.util.*;
import java.io.*;

// 거스름돈
public class No5585 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();
        int change = 1000 - money;
        int[] coinVal = new int[]{500,100,50,10,5,1};
//        500, 100, 50, 10, 5, 1 개수
        int coinCnt = 0;
        for(int i = 0; i < 6; i++){
            while(change >= coinVal[i]){
                change -= coinVal[i];
                coinCnt++;
//                System.out.println(change);
            }
        }
        System.out.println(coinCnt);
    }
}
