package silver;

import java.util.*;
import java.io.*;

// 부등호
public class No2529 {
    static long max = 0;
    static long min = Long.MAX_VALUE;
    static String maxStr = null;
    static String minStr = null;
    public static void main(String[] args) throws Exception{
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        char[] inequality = new char[k];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < k; i++){
            inequality[i] = st.nextToken().charAt(0);
        }
        boolean[] visited = new boolean[10];
        Stack<Integer> prevNum = new Stack<>();
        getPermutation(inequality, 0, visited, prevNum);
        System.out.println(maxStr);
        System.out.println(minStr);
    }

//    (부등호 배열, 현재 살펴 볼 부등호, 방문한 숫자 저장, 이전 숫자)
    private static void getPermutation(char[] inequality, int idx, boolean[] visited, Stack<Integer> prevNum){
        if(idx == 0){
            for(int i = 0; i < 10; i++){
                visited[i] = true;
                prevNum.add(i);
                getPermutation(inequality, idx+1, visited, prevNum);
                prevNum.pop();
                visited[i] = false;
            }
        }else if(idx == inequality.length+1){
            StringBuilder sb = new StringBuilder();
            for(int i : prevNum){
                sb.append(i);
            }
            long num = Long.parseLong(sb.toString());
//            System.out.println("num: "+sb);
            if(max < num){
                max = num;
                maxStr = sb.toString();
            }
            if(min > num){
                min = num;
                minStr = sb.toString();
            }
        }else{
            if(inequality[idx-1] == '<'){
                for(int i = 0; i < 10; i++){
                    if(!visited[i] && prevNum.peek() < i){
                        visited[i] = true;
                        prevNum.add(i);
                        getPermutation(inequality, idx+1, visited, prevNum);
                        prevNum.pop();
                        visited[i] = false;
                    }
                }
            }else if(inequality[idx-1] == '>'){
                for(int i = 0; i < 10; i++){
                    if(!visited[i] && prevNum.peek() > i){
                        visited[i] = true;
                        prevNum.add(i);
                        getPermutation(inequality, idx+1, visited, prevNum);
                        prevNum.pop();
                        visited[i] = false;
                    }
                }
            }
        }
    }
}
