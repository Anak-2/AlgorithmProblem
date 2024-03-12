package ch12;

import java.util.LinkedList;

public class 단어_변환 {
    public static void main(String[] args) {
        System.out.println(Solution.solution("hit", "cog",
                new String[]{"hot", "dot", "dog", "lot", "log", "cog"})
        );
    }

    static class Solution {
        static boolean[] visited;

        public static int solution(String begin, String target, String[] words) {
            int answer = 0;
            visited = new boolean[words.length];
//          stack에 (words의 idx, 변환 cnt) 저장
            LinkedList<Integer[]> stack = new LinkedList<>();
            for (int i = 0; i < words.length; i++) {
                if (getDiffChar(begin, words[i]).size() == 1) {
                    stack.add(new Integer[]{i, 1});
                }
            }
            while (!stack.isEmpty()) {
                Integer[] element = stack.remove(0);
                visited[element[0]] = true;
                if (words[element[0]].equals(target)) {
                    answer = element[1];
                    break;
                } else {
                    element[1]++;
                    for (int i = 0; i < words.length; i++) {
                        if (!visited[i]) {
                            // 글자 차이가 1인 words 저장
                            if (getDiffChar(words[element[0]], words[i]).size() == 1) {
                                stack.add(new Integer[]{i, element[1]});
                            }
                        }
                    }
                }
            }
            return answer;
        }

        //     두 단어에서 다른 char의 idx를 뽑아주는 함수
        public static LinkedList<Integer> getDiffChar(String a, String b) {
            LinkedList<Integer> charDiffIdx = new LinkedList<>();
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    charDiffIdx.add(i);
                }
            }
            return charDiffIdx;
        }

    }
}
