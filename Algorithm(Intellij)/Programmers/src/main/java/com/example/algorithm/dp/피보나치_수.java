package com.example.algorithm.dp;

public class 피보나치_수 {
    public static void main(String[] args) {
        System.out.println(Solution.solution(20));
    }

    static class Solution {
        public static int solution(int n) {
            return fibo(n);
        }
        public static int fibo(int n) {
            int[] prev = new int[n+1];

            prev[0] = 0;
            prev[1] = 1;

            for (int i=2; i<= n; i++){
                prev[i] = (prev[i-1] + prev[i-2]) % 1234567;
            }

            return prev[n] % 1234567;
        }
    }
}
