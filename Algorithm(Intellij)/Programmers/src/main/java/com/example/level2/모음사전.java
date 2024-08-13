package com.example.level2;

import java.util.ArrayList;
import java.util.List;

public class 모음사전 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("I"));
    }

    static class Solution {

        static int order = 1;
        static String answerWord;
        static List<Character> curList = new ArrayList<>();

        public int solution(String word) {
            answerWord = word;
            curList.add('A');
            stretchOrIncrease();

            return order;
        }

        private void stretchOrIncrease() {
            if(convertCharListToString(curList).equals(answerWord)){
                return;
            }

            if (!isLengthFive(curList)) {
                curList.add('A');
                order++;
                stretchOrIncrease();
            } else {
                increaseChar();
            }
        }

        private boolean isLengthFive(List<Character> curList){
            return curList.size() == 5;
        }

        private void increaseChar() {
            // 재귀함수의 끝나는 조건
            System.out.println(curList);
            if(convertCharListToString(curList).equals(answerWord)){
                return;
            }

            int lastIndex = curList.size() - 1;
            Character curChar = curList.get(lastIndex);

            switch (curChar) {
                case 'A':
                    curList.set(lastIndex, 'E');
                    order++;
                    stretchOrIncrease();
                    break;
                case 'E':
                    curList.set(lastIndex, 'I');
                    order++;
                    stretchOrIncrease();
                    break;
                case 'I':
                    curList.set(lastIndex, 'O');
                    order++;
                    stretchOrIncrease();
                    break;
                case 'O':
                    curList.set(lastIndex, 'U');
                    order++;
                    stretchOrIncrease();
                    break;
                case 'U':
                    shrinkAndIncrease();
                    break;
                default:
                    System.out.println("Error");
            }
        }

        private void shrinkAndIncrease() {
            if(convertCharListToString(curList).equals(answerWord)){
                return;
            }

            int lastIndex = curList.size() - 1;
            Character curChar = curList.get(lastIndex);

            if (curList.size() == 1) {
                if(curChar.equals('U')) {
                    return;
                }
            }

            curList.remove(lastIndex);
            increaseChar();
        }

        private String convertCharListToString(List<Character> charList) {
            StringBuilder stringBuilder = new StringBuilder(charList.size());

            for (char c : charList) {
                stringBuilder.append(c);
            }

            return stringBuilder.toString();
        }
    }
}
