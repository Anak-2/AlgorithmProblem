package com.example.level2;

import java.util.ArrayList;
import java.util.Arrays;

public class 수식최대화 {
    public static void main(String[] args) {
        System.out.println(Solution.solution("100-200*300-500+20"));
    }

    static class Solution {
        static char[] top = {'-', '*', '+'}; // 연산자 우선순위
        static long answer;

        public static long solution(String expression) {
            ArrayList<Long> numbers = new ArrayList<>(); // 숫자 배열
            ArrayList<Character> operators = new ArrayList<>(); // 연산자 배열

            int i;
            String num = "";

            for (i = 0; i < expression.length(); i++) {
                if (expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
                    num += expression.charAt(i);
                } else {
                    numbers.add(Long.parseLong(num));
                    num = "";
                    operators.add(expression.charAt(i));
                }
            }
            numbers.add(Long.parseLong(num));

            perm(numbers, operators, 0);
            return answer;
        }

        public static void swap(int a, int b) {
            char k = top[a];
            top[a] = top[b];
            top[b] = k;
        }

        public static long calculate(ArrayList<Long> numbers, ArrayList<Character> operators) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < operators.size(); j++) {
                    if (operators.get(j) == top[i]) {
                        switch (top[i]) {
                            case '-':
                                numbers.add(j, numbers.remove(j) - numbers.remove(j));
                                break;
                            case '*':
                                numbers.add(j, numbers.remove(j) * numbers.remove(j));
                                break;
                            case '+':
                                numbers.add(j, numbers.remove(j) + numbers.remove(j));
                                break;
                        }
                        operators.remove(j--);
                    }
                }
            }
            return Math.abs(numbers.get(0));
        }

        public static void perm(ArrayList<Long> numbers, ArrayList<Character> operators, int depth) {
            if (depth == 3) { // 종료 조건
                long temp = calculate((ArrayList<Long>) numbers.clone(), (ArrayList<Character>) operators.clone());
                if (temp > answer)
                    answer = temp;
                return;
            }
            for (int i = depth; i < 3; i++) {
                swap(i, depth);
//                System.out.println(top);
                perm(numbers, operators, depth + 1);
                swap(i, depth);
            }
        }
    }
}
