package silver;

import java.util.*;
import java.io.*;

public class No3085 {
    static char[][] candy;
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        candy = new char[N][N];
        for(int i = 0; i < N; i++){
            char[] charArr = br.readLine().toCharArray();
            for(int j = 0; j < N; j++){
                candy[i][j] = charArr[j];
            }
        }


    }

//    isRow가 true면 r,c 와 r+1,c 교환
//    false면 r,c 와 r,c+1 교환
    public static char[][] rowSwapCandy(char[][] swapped, int r, int c, boolean isRow){
        char temp = candy[r][c];
        if(isRow){
            swapped[r][c] = swapped[r+1][c];
            swapped[r+1][c] = temp;
        }else{
            swapped[r][c] = swapped[r][c+1];
            swapped[r][c+1] = temp;
        }
        return swapped;
    }

    public static int checkLCS;
}
