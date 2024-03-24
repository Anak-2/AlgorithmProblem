package ch13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 가사_검색 {

    class Solution {

        static Node preRoot = new Node('0', new ArrayList<>(), new HashMap<>());
        // 굳이 ??___ 로 시작하는 문자열을 위해 접두사 부터 시작하는 trie를 만드는 이유
        // 시간 초과 때문.. 중간에 ?? 가 들어가진 않으니, ??___ 또는 ___?? 이다.
        static Node postRoot = new Node('0', new ArrayList<>(), new HashMap<>());

        public int[] solution(String[] words, String[] queries) {
            int[] answer = new int[queries.length];

            for (String word : words) {
                insertNode(word);
            }

            int answerIdx = 0;

            for (String query : queries) {
                char[] queryArr = query.toCharArray();
                List<Node> stack = new ArrayList<>();

                Node curNode;
                boolean isPre = true;
                if (queryArr[0] == '?') {
                    isPre = false;
                    curNode = postRoot;
                } else {
                    curNode = preRoot;
                }

                if (isPre) {
                    int charIdx = 0;
                    while (queryArr[charIdx] != '?' && charIdx != queryArr.length) {
                        curNode = curNode.findNode(queryArr[charIdx]);
                        if(curNode == null){
                            break;
                        }
                        charIdx++;
                    }
                } else {
                    int charIdx = queryArr.length - 1;
                    while (queryArr[charIdx] != '?' && charIdx != -1) {
                        curNode = curNode.findNode(queryArr[charIdx]);
                        if(curNode == null){
                            break;
                        }
                        charIdx--;
                    }
                }

                if(curNode == null){
                    answer[answerIdx] = 0;
                }else{
                    answer[answerIdx] = curNode.lengthInfo.getOrDefault(queryArr.length, 0);
                }
                answerIdx++;
            }

            return answer;
        }

        static class Node {
            char c;
            List<Node> childNodes;
            // 찾고자 하는 문자열의 길이, 같은 문자열의 길이의 개수
            Map<Integer, Integer> lengthInfo;

            public Node(char c, List<Node> childNodes, Map<Integer, Integer> lengthInfo) {
                this.c = c;
                this.childNodes = childNodes;
                this.lengthInfo = lengthInfo;
            }

            public Node insertNode(char c, int length) {
                this.lengthInfo.put(length, this.lengthInfo.getOrDefault(length, 0) + 1);
                // 해당 char 를 가지는 자식 노드가 있다면 반환
                for (Node n : this.childNodes) {
                    if (n.c == c) {
                        return n;
                    }
                }

                // 없다면 새로 추가하고, 추가한 노드 반환
                Node newNode = new Node(c, new ArrayList<>(), new HashMap<>());
                this.childNodes.add(newNode);
                return newNode;
            }

            public Node findNode(char c) {
                for (Node n : this.childNodes) {
                    if (n.c == c) {
                        return n;
                    }
                }
                return null;
            }

            public void printInfo() {
                List<Node> stack = new ArrayList<>();
                stack.add(this);
                List<Node> nextStack = new ArrayList<>();
                int level = 1;
                do {
                    System.out.print("level " + level + ": ");
                    while (!stack.isEmpty()) {
                        Node n = stack.remove(0);
                        System.out.print(n.c + " ");
                        for (Node cn : n.childNodes) {
                            nextStack.add(cn);
                        }
                    }
                    stack = new ArrayList<>(nextStack);
                    nextStack = new ArrayList<>();
                    System.out.println();
                    level++;
                } while (!stack.isEmpty());

            }
        }

        public void insertNode(String word) {
            char[] chars = word.toCharArray();
            Node preStart = preRoot;
            Node postStart = postRoot;

            for (int i = 0; i < chars.length; i++) {
                preStart = preStart.insertNode(chars[i], chars.length);
                postStart = postStart.insertNode(chars[chars.length - i - 1], chars.length);
            }
        }

    }
}
