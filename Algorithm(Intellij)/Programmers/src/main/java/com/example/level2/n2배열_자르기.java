package com.example.level2;

import java.util.ArrayList;
import java.util.List;

public class n2배열_자르기 {

    public static void main(String[] args) {

    }

    static class Solution {

        static int N;

        public int[] solution(int n, long left, long right) {
            N = n;
            List<Long> answerList = new ArrayList<>();
            for(long i = left; i <= right; i++){
                long[] rc = lineToRC(i);
                long val = rcToLong(rc[0], rc[1]);
                answerList.add(val);
            }
            return answerList.stream().mapToInt(Long::intValue).toArray();
        }

        private long rcToLong(long r, long c){
            if(r >= c) return r;
            return c;
        }

        private long[] lineToRC(long k){
            long r = k / N + 1;
            long c = k % N + 1;
            return new long[]{r, c};
        }
    }
}