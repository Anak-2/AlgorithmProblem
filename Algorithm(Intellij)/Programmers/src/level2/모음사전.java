package level2;

import java.util.ArrayList;
import java.util.List;

public class 모음사전 {
    public static void main(String[] args) {
        System.out.println(Solution.solution("I"));
    }

    static class Solution {

        static int order = 0;
        static String answerWord;
        static List<Character> curList = new ArrayList<>();

        public static int solution(String word) {
            answerWord = word;
            curList.add('A');
            stretch();

            return order;
        }

        public static void stretch() {
            System.out.println(curList);
            if(convertCharListToString(curList).equals(answerWord)){
                return;
            }

            if (curList.size() < 5) {
                curList.add('A');
                order++;
                stretch();
            } else {
                increaseChar();
            }
        }

        public static void increaseChar() {
            if(convertCharListToString(curList).equals(answerWord)){
                return;
            }

            int lastIndex = curList.size() - 1;
            Character curChar = curList.get(lastIndex);
            switch (curChar) {
                case 'A':
                    curList.set(lastIndex, 'E');
                    order++;
                    increaseChar();
                    break;
                case 'E':
                    curList.set(lastIndex, 'I');
                    order++;
                    increaseChar();
                    break;
                case 'I':
                    curList.set(lastIndex, 'O');
                    order++;
                    increaseChar();
                    break;
                case 'O':
                    curList.set(lastIndex, 'U');
                    order++;
                    increaseChar();
                    break;
                case 'U':
                    shrinkAndIncrease();
                    break;
                default:
                    System.out.println("Error");
            }
        }

        public static void shrinkAndIncrease() {
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
            lastIndex -= 1;

            switch (curChar) {
                case 'A':
                    curList.set(lastIndex, 'E');
                    order++;
                    stretch();
                    return;
                case 'E':
                    curList.set(lastIndex, 'I');
                    order++;
                    stretch();
                    return;
                case 'I':
                    curList.set(lastIndex, 'O');
                    order++;
                    stretch();
                    return;
                case 'O':
                    curList.set(lastIndex, 'U');
                    order++;
                    stretch();
                    return;
                case 'U':
                    shrinkAndIncrease();
                    return;
                default:
                    System.out.println("Error");
            }
        }

        public static String convertCharListToString(List<Character> charList) {
            StringBuilder stringBuilder = new StringBuilder(charList.size());

            // ArrayList의 각 문자를 StringBuilder에 추가
            for (char c : charList) {
                stringBuilder.append(c);
            }

            // StringBuilder를 문자열로 변환하여 반환
            return stringBuilder.toString();
        }
    }
}
