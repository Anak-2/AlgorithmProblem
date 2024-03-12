package ch12;

import java.util.ArrayList;
import java.util.List;

public class 큰_수_만들기 {

    public static void main(String[] args) {
        System.out.println(Solution.solution("4177252841", 9));
    }

    // 재귀로 터짐
    static class Solution2 {

        static String staticNumber;
        static int staticK;
        static int combiLength;
        static List<Integer> makeNumbers = new ArrayList<>();

        public static String solution(String number, int k) {
            staticNumber = number;
            staticK = k;
            combiLength = number.length() - k;

            List<Character> combiNumber = new ArrayList<>();
            combination(0, combiNumber);

            int max = 0;
            for (int curInt : makeNumbers) {
                if (max < curInt) {
                    max = curInt;
                }
            }
            return Integer.toString(max);
        }

        public static void combination(int curIdx, List<Character> combiNumber) {
            // k개를 제외한 수가 완성되면 만들어진 숫자 리스트에 추가하고 끝
            if (combiNumber.size() == combiLength) {
                StringBuilder s = new StringBuilder();
                for (char c : combiNumber) {
                    s.append(c);
                }
                makeNumbers.add(Integer.valueOf(s.toString()));
                return;
            }

            // 숫자의 끝에 도달했으면 끝
            if (curIdx == staticNumber.length()) {
                return;
            }

            char c = staticNumber.charAt(curIdx);
            combiNumber.add(c);
            curIdx++;
            combination(curIdx, combiNumber);
            combiNumber.remove(combiNumber.size() - 1);
            combination(curIdx, combiNumber);
        }
    }

    static class Solution {
        public static String solution(String number, int k) {

            String answer = "";
            StringBuilder answerBuilder = new StringBuilder();

            char[] array = number.toCharArray();

            int len = array.length - k;

            int start = 0;

            for (int i = 0; i < len; i++) {
                char max = '0';
                for (int j = start; j <= i + k; j++) {
                    // 가장 큰 수를 고르고, 고른 숫자 다음 인덱스를 시작 인덱스로 설정하기
                    if (array[j] > max) {
                        max = array[j];
                        start = j + 1;
                    }
                }
                // 가장 큰 문자를 String에 넣어주기
                answerBuilder.append(max);
            }
            answer = answerBuilder.toString();
            return answer;
        }

    }
}
