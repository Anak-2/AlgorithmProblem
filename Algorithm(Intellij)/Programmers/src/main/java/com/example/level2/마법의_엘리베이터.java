package com.example.level2;

public class 마법의_엘리베이터 {

    public static void main(String[] args) {
        System.out.println(Solution.solution(16));
    }

    static class Solution {
        public static int solution(int storey){
            int answer = 0;

            while(storey > 0){
                int one = storey % 10;
                storey = storey / 10;

                if(one == 5){
                    if(storey % 10 >= 5){
                        storey++;
                    }
                    answer += 5;
                }else if(one > 5){
                    answer += (10 - one);
                    storey++;
                }else{
                    answer += one;
                }
            }

            return answer;
        }
    }
}
