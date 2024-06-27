package com.example.level2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 광물_캐기 {

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] picks = new int[]{1,3,2};
        String[] minerals = new String[]{
                "diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"
        };
        System.out.println(solution.solution(picks, minerals));
    }
    static class Solution {

        static int[][] tired = {
                {1,1,1},
                {5,1,1},
                {25,5,1}
        };

        static int MIN = Integer.MAX_VALUE / 2;

        public int solution(int[] picks, String[] minerals) {
            bfs(picks, minerals, 0);

            return MIN;
        }

        public void bfs(int[] curPicks, String[] minerals, int curTired){
            if(minerals.length == 0){
                MIN = Math.min(MIN, curTired);
                return;
            }
            if(curPicks[0] == 0 && curPicks[1] == 0 && curPicks[2] == 0){
                MIN = Math.min(MIN, curTired);
                return;
            }
            if(curPicks[0] > 0){
                int[] copy = curPicks.clone();
                copy[0] = curPicks[0] - 1;
                String[] cm = minerals.clone();
                ReturnCalTired returnCalTired = calTired("dia",cm);
                int ct = curTired + returnCalTired.totalTired;
                cm = returnCalTired.minerals;;
                bfs(copy, cm, ct);
            }
            if(curPicks[1] > 0){
                int[] copy = curPicks.clone();
                copy[1] = curPicks[1] - 1;
                String[] cm = minerals.clone();
                ReturnCalTired returnCalTired = calTired("iron",cm);
                int ct = curTired + returnCalTired.totalTired;
                cm = returnCalTired.minerals;
                bfs(copy, cm, ct);
            }
            if(curPicks[2] > 0){
                int[] copy = curPicks.clone();
                copy[2] = curPicks[2] - 1;
                String[] cm = minerals.clone();
                ReturnCalTired returnCalTired = calTired("stone",cm);
                int ct = curTired + returnCalTired.totalTired;
                cm = returnCalTired.minerals;
                bfs(copy, cm, ct);
            }
        }

        public ReturnCalTired calTired(String picks, String[] minerals){
            int totalTired = 0;
            for(int i = 0; i < 5; i++){
                if(minerals.length == 0) break;
                String mineral = minerals[0];
                totalTired += getPicksTired(picks, mineral);
                minerals = cutArray(minerals);
            }
            return new ReturnCalTired(totalTired, minerals);
        }

        public int getPicksTired(String picks, String minerals){
            int firstIdx = matchPicks(picks);
            int secondIdx = matchMinerals(minerals);

            return tired[firstIdx][secondIdx];
        }

        public int matchPicks(String mine){
            switch (mine) {
                case "dia" -> {
                    return 0;
                }
                case "iron" -> {
                    return 1;
                }
                case "stone" -> {
                    return 2;
                }
            }
            System.out.println("wrong");
            return -1;
        }

        public int matchMinerals(String mine){
            switch (mine) {
                case "diamond" -> {
                    return 0;
                }
                case "iron" -> {
                    return 1;
                }
                case "stone" -> {
                    return 2;
                }
            }
            System.out.println("wrong");
            return -1;
        }

        public String[] cutArray(String[] originalArray){
            String[] newArray = new String[originalArray.length - 1];
            System.arraycopy(originalArray, 1, newArray, 0, originalArray.length - 1);
            return newArray;
        }

        public static class ReturnCalTired{
            int totalTired;
            String[] minerals;

            public ReturnCalTired(final int totalTired, final String[] minerals) {
                this.totalTired = totalTired;
                this.minerals = minerals;
            }
        }
    }

    static class Solution2 {

        int min = Integer.MAX_VALUE / 2;
        Map<String, List<Integer>> tiredInfo;

        public int solution(int[] picks, String[] minerals){
            tiredInfo = new HashMap<>();
            tiredInfo.put("diamond", List.of(1,5,25));
            tiredInfo.put("iron", List.of(1,1,5));
            tiredInfo.put("stone", List.of(1,1,1));

            bfs(0,0,picks, minerals);
            return min;
        }

        private void bfs(int depth, int totalTired, int[] picks, String[] minerals){
            if(depth == minerals.length || (picks[0] == 0 && picks[1] == 0 && picks[2] == 0)){
                min = Math.min(min, totalTired);
                return;
            }
            for(int i = 0; i < 3; i++){
                if(picks[i] > 0){
                    picks[i]--;
                    int nextDepth = Math.min(depth + 5, minerals.length);
                    int nextTired = totalTired;
                    for(int j = depth; j < nextDepth; j++){
                        nextTired += tiredInfo.get(minerals[j]).get(i);
                    }
                    bfs(nextDepth, nextTired, picks, minerals);
                    picks[i]++;
                }
            }
        }
    }
}
