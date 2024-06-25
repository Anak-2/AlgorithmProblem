package com.example.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 모의고사 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(Solution.solution(new int[]{1, 3, 2, 4, 2})));
    }

    static class Solution {

        static int maxScore = 0;
        static List<Integer> problemAnswer = new ArrayList<>();

        public static int[] solution(int[] answers) {
            int[] p1 = new int[]{1,2,3,4,5};
            int[] p2 = new int[]{2,1,2,3,2,4,2,5};
            int[] p3 = new int[]{3,3,1,1,2,2,4,4,5,5};

            int p1Score = 0;
            int p2Score = 0;
            int p3Score = 0;

            for(int i = 0; i < answers.length; i++){
                if(p1[i%p1.length] == answers[i]){
                    p1Score++;
                }
            }

            for(int i = 0; i < answers.length; i++){
                if(p2[i%p2.length] == answers[i]){
                    p2Score++;
                }
            }

            for(int i = 0; i < answers.length; i++){
                if(p3[i%p3.length] == answers[i]){
                    p3Score++;
                }
            }

            int[] scores = new int[]{p1Score, p2Score, p3Score};
            Arrays.stream(scores).forEach(value -> {
                if(value > maxScore){ // 람다 함수에서 지역 변수일 경우 AtomicInteger 나 final 이어야 한다??
                    maxScore = value;
                }
            });

            for(int i = 0; i < 3; i++){
                if(maxScore == scores[i]){
                    problemAnswer.add(i+1);
                }
            }

            return problemAnswer.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
