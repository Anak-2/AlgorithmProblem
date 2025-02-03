package silver;

import java.util.*;
import java.io.*;

public class No27649 {

    static HashSet<Character> delim = new HashSet<>(
            Arrays.asList('<','>','&','|','(',')')
    );
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<String> arrayList = new ArrayList<>();
        StringBuilder sb;
        StringBuilder ans = new StringBuilder();
        boolean findDelim;
        while(st.hasMoreTokens()){
            sb = new StringBuilder();
            String token = st.nextToken();
            char[] cur = token.toCharArray();
            for(int i = 0; i < cur.length; i++){
                findDelim = false;
                if(delim.contains(cur[i])){
                    if(cur[i] == '&' || cur[i] == '|'){
                        if(sb.length() > 0){
                            ans.append(sb+" ");
                        }
                        i++;
                        sb = new StringBuilder();
                        sb.append(cur[i]);
                        sb.append(cur[i]);
                        ans.append(sb+" ");
                        sb = new StringBuilder();
                        findDelim = true;
                    }
                    else{
                        if(sb.length() > 0){
                            ans.append(sb+" ");
                        }
                        ans.append(cur[i]+" ");
                        sb = new StringBuilder();
                        findDelim = true;
                    }
                }
                if(!findDelim){
                    sb.append(cur[i]);
                }
            }
            if(sb.length() > 0){
                ans.append(sb+" ");
            }
        }
        System.out.println(ans.toString());
    }
}
