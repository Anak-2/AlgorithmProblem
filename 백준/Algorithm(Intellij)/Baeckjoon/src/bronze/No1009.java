package bronze;

import java.io.*;
import java.util.Scanner;

public class No1009 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int ans = 1;
            for(int j = 0; j < b; j++){
                ans = (ans * a) % 10;
            }
            if(ans == 0){
                System.out.println(10);
            }else{
                System.out.println(ans);
            }
        }
    }
}
