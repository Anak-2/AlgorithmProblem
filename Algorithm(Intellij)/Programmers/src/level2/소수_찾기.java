package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 소수_찾기 {

    public static void main(String[] args) {
        System.out.println(Solution.solution("017"));
    }

    static class Solution {
        static String number;
        static Set<Integer> set = new HashSet<>();
        static boolean[] visited = new boolean[7];

        static void makeNumber(String temp, int m) {
            System.out.println(temp);
            if (temp.length() == m) {
                int num = Integer.parseInt(temp);
                set.add(num);
            }

            for (int i = 0; i < number.length(); i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    temp += number.charAt(i);

                    makeNumber(temp, m);

                    visited[i] = false;
                    temp = temp.substring(0, temp.length() - 1);
                }
            }

        }

        //소수 판단 함수
        static boolean prime(int n) {
            if (n < 2) return false;

            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) return false;
            }

            return true;
        }

        public static int solution(String numbers) {
            int answer = 0;
            number = numbers;
            for (int i = 0; i < numbers.length(); i++) {
                makeNumber("", i + 1);
            }

            for(Integer i : set){
                if (prime(i) )answer++;
            }

            return answer;

        }

    }
}
