package silver;

import java.util.*;
import java.io.*;

public class No2164 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= n; i++){
            q.add(i);
        }

        int tmp = -1;
        while(!q.isEmpty()){
            tmp = q.poll();
            if(!q.isEmpty()){
                q.add(q.poll());
            }
        }
        System.out.println(tmp);
    }

}
