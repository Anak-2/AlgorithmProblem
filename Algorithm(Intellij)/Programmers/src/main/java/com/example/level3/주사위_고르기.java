package com.example.level3;

import java.util.*;

public class 주사위_고르기 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(
                s.solution(new int[][]{{1, 2, 3, 4, 5, 6}, {3, 3, 3, 3, 4, 4}, {1, 3, 3, 4, 4, 4}, {1, 1, 4, 4, 5, 5}}))
        );
    }

    static class Solution{

        int diceLength;
        List<List<Integer>> diceCases = new ArrayList<>();
        int[][] dice;

        public int[] solution(int[][] dice) {
            List<Integer> highWinRateDice = new ArrayList<>();
            int winCount = 0;
            this.dice = dice;
            diceLength = dice.length;
            List<Integer> arr = new ArrayList<>();
            getDiceCase(arr, 0);
            for(List<Integer> eachDiceCase : diceCases){
                // A의 Case
                List<Integer> aDiceSumCases = getDiceSumCases(eachDiceCase);
                // B의 Case
                List<Integer> bDice = getRestDice(eachDiceCase);
                List<Integer> bDiceSumCases = getDiceSumCases(bDice);
                // A또는 B의 승리 횟수 구한 후, 가장 높은 승리 횟수를 가진 diceCase를 업데이트
                int tmpWinCount = getWinCount(aDiceSumCases, bDiceSumCases);
                if(winCount < tmpWinCount) {
                    winCount = tmpWinCount;
                    highWinRateDice = eachDiceCase;
                }
            }
            int[] answer = highWinRateDice.stream().map(i -> i+1).mapToInt(Integer::intValue).toArray();
            Arrays.sort(answer);
            return answer;
        }

        // 모든 주사위 분배 경우의 수
        public void getDiceCase(List<Integer> diceCase, int idx){
            if(diceCase.size() == diceLength / 2){
                diceCases.add(diceCase);
            }

            for(int i = idx; i < diceLength; i++){
                List<Integer> copyDiceCase = new ArrayList<>(diceCase);
                copyDiceCase.add(i);
                getDiceCase(copyDiceCase, i+1);
            }
        }

        // A가 뽑은 주사위를 제외한 나머지 주사위 구하기
        public List<Integer> getRestDice(List<Integer> diceCase){
            Set<Integer> aDice = new HashSet<>(diceCase);
            List<Integer> bDice = new ArrayList<>();
            for(int i = 0; i < this.diceLength; i++){
                if(!aDice.contains(i)){
                    bDice.add(i);
                }
            }
            return bDice;
        }

        // 분배된 주사위로 구할 수 있는 모든 합
        public List<Integer> getDiceSumCases(List<Integer> diceCase){
            List<Integer> diceSum = new ArrayList<>();
            getSum(diceCase,diceSum,0,0);
            return diceSum;
        }

        public void getSum(List<Integer> diceCase, List<Integer> diceSum, int total, int curDiceIdx){
            if(curDiceIdx == diceCase.size()){
                diceSum.add(total);
                return;
            }
            int[] curDice = this.dice[diceCase.get(curDiceIdx)];
            for(int i = 0; i < curDice.length; i++){
                getSum(diceCase, diceSum,total+curDice[i], curDiceIdx+1);
            }
        }

        // A 주사위와 B 주사위 합을 비교해 A의 승리 횟수 구하기
        public int getWinCount(List<Integer> diceASum, List<Integer> diceBSum){
            int totalWin = 0;
            int totalLose = 0;
            Collections.sort(diceBSum);
            // 이분 탐색으로 A의 각 주사위 합이 B의 주사위 합 보다 큰게 몇 개인지 구하기
            for(int a : diceASum){
                int left = 0;
                int right = diceBSum.size() - 1;
                int index = -1;
                while(left <= right) {
                    int middle = (left + right) / 2;

                    if (diceBSum.get(middle) < a){
                        left = middle + 1;
                        index = Math.max(index, middle);
                    } else {
                        right = middle - 1;
                    }
                }
                if(index != -1){
                    totalWin += index + 1;
                }
            }
            return totalWin;
        }
    }
}

