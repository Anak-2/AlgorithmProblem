package com.example.pccp_1;

public class 싸피_톡방_문제 {

    static int GLOBAL_N;
    static int GLOBAL_K;
    static int K_TH = 1;
    static String K_TH_STRING;

    public static void main(String[] args) {
        // 사전 순 배열 , A와 B로만 이루어진 문자열
        Solution solution = new Solution();
        solution.solution(10, 24);
    }

    static class Solution{
        public void solution(int N, int K){
            GLOBAL_N = N;
            GLOBAL_K = K;

            backTrack(new StringBuilder(), 2);
            int secondB = getSecondB(K_TH_STRING);
            System.out.println(Integer.toString(secondB, 2));
        }

        public void backTrack(StringBuilder sb, int remainB){
            if(sb.length() == GLOBAL_N){
                if(remainB == 0){
                    if(K_TH == GLOBAL_K){
                        System.out.println(sb.toString());
                        K_TH_STRING = sb.toString();
                    }
                    K_TH++;
                }
                return;
            }

            StringBuilder sb1 = new StringBuilder(sb);
            sb1.append('A');
            backTrack(sb1, remainB);
            StringBuilder sb2 = new StringBuilder(sb);
            if(remainB > 0){
                sb2.append('B');
                remainB--;
                backTrack(sb2, remainB);
            }
        }

        public int getSecondB(String s){
            int bCnt = 0;
            int bIdx = 1;
            for(char c : s.toCharArray()){
                if(c == 'B'){
                    bCnt++;
                }
                if(bCnt == 2){
                    return bIdx;
                }
                bIdx++;
            }
            return -1;
        }
    }
}
