package silver;

import java.awt.color.ICC_Profile;
import java.io.BufferedReader;
import java.util.Scanner;

// 수 이어 쓰기1
public class No1748 {
    public static void main(String[] args) throws  Exception{
        Scanner sc = new Scanner(System.in);
        char[] N = sc.nextLine().toCharArray();
        int size = N.length;
        int num = Integer.parseInt(String.valueOf(N));
        int ans = 0;
        for(int i = 1; i < size; i++){
            ans += i*9*Math.pow(10, i-1);
        }
        ans += (num - Math.pow(10, size-1) + 1)*size;
        System.out.println(ans);
    }
}
