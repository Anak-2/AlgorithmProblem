package silver;

import java.util.*;
import java.io.*;

class No6550{
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String str;
        while((str = br.readLine()) != null && str != ""){
            st = new StringTokenizer(str);
           System.out.println(solution(st.nextToken(), st.nextToken()));
        }
    }
    
    public static String solution(String compare, String origin){
        int compareLen = compare.length();
        int comparePoint = 0;
        int originLen = origin.length();
        if(compareLen > originLen) return "No";
        for(int i = 0; i < originLen; i++){
            if(compare.charAt(comparePoint) == origin.charAt(i)){
                comparePoint++;
            }
            if(comparePoint == compareLen) return "Yes";
        }
        return "No";
    }
}