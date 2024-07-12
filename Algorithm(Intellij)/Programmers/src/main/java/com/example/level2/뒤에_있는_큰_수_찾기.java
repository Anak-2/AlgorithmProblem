package com.example.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 뒤에_있는_큰_수_찾기 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(Solution.solution(new int[]{9,1,5,3,6,2})));
    }

    static class Solution {
        public static int[] solution(int[] numbers) {
            int[] answer = new int[numbers.length];
            List<int[]> intArrStack = new ArrayList<>();
            for (int i = 0; i < numbers.length; i++) {
                int[] element = new int[]{i, numbers[i]};
                while (!intArrStack.isEmpty()) {
                    int[] top = peek(intArrStack);
                    if (top[1] < element[1]) {
                        pop(intArrStack);
                        answer[top[0]] = element[1];
                    } else {
                        break;
                    }
                }
                intArrStack.add(element);
            }
            while (!intArrStack.isEmpty()) {
                int[] top = pop(intArrStack);
                answer[top[0]] = -1;
            }
            return answer;
        }

        private static int[] peek(List<int[]> object) {
            return object.get(object.size() - 1);
        }

        private static int[] pop(List<int[]> object) {
            return object.remove(object.size() - 1);
        }

        private void print(){
            System.out.println("hello");
        }
    }
}
