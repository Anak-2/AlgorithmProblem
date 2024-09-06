

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String s = st.nextToken();
        char[] math = s.toCharArray();


        List<Integer> nums = new ArrayList<>();

        int prevNum = 0;

        StringBuilder sb = new StringBuilder();
        for (char c : math) {
            if (c == '+') {
                prevNum += Integer.parseInt(sb.toString());
                sb = new StringBuilder();
            }
            else if (c == '-') {
                prevNum += Integer.parseInt(sb.toString());
                nums.add(prevNum);
                prevNum = 0;
                sb = new StringBuilder();
            }
            else {
                sb.append(c);
            }
        }

        nums.add(prevNum + Integer.parseInt(sb.toString()));

        int cur = nums.remove(0);
        for(int i : nums) {
            cur -= i;
        }

        System.out.println(cur);
    }
}
