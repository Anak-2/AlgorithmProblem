package com.example.ch13;

import java.util.*;

public class 양궁대회 {

    public static void main(String[] args) {
    }

    class Solution {

        static int[] apeach = new int[11];
        static int[] rion = new int[11];
        static int answer = 0;

        public int[] solution(int n, int[] info) {
            apeach = info.clone();
            dfs(rion, 0, n);

            if(answer == 0){
                return new int[] {-1};
            }

            return rion;
        }

        // 라이언과 어피치 점수 차이 구하기
        public void getDiff(int[] diffRion){
            int rionScore = 0;
            int apeachScore = 0;

            for(int i = 0; i < 10; i++){
                if(apeach[i] < diffRion[i]) {
                    rionScore += 10-i;
                }else if(apeach[i] != 0){
                    apeachScore += 10-i;
                }
            }

            // 가장 높은 차이의 점수 중 가장 낮은 점수에 화살이 많은 경우를 구하기
            if(answer < (rionScore - apeachScore)) {
                answer = rionScore - apeachScore;
                rion = diffRion.clone();
            }else if(answer == (rionScore - apeachScore)){
                for(int i = 10; i >= 0; i--){
                    if(rion[i] < diffRion[i]){
                        rion = diffRion.clone();
                    }else if(rion[i] > diffRion[i]){
                        break;
                    }
                }
            }
        }

        // 라이언이 점수를 먹을 경우, 아닐 경우로 DFS
        public void dfs(int[] curRion, int curIdx, int remainArrow){
            // 화살이 0개가 되거나, curIdx가 10일 경우 종료
            if(remainArrow == 0){
                getDiff(curRion);
                return;
            }
            if(curIdx == 10){
                curRion[10] = remainArrow;
                getDiff(curRion);
                return;
            }

            // 라이언이 점수를 먹을 때
            int needArrow = apeach[curIdx] + 1; // 점수를 먹기 위해 필요한 화살의 개수

            int[] nextRion = curRion.clone();

            if(remainArrow >= needArrow){
                nextRion[curIdx] = needArrow;
                dfs(nextRion, curIdx+1, remainArrow-needArrow);
            }

            // 라이언이 점수를 안 먹을 때
            dfs(curRion.clone(), curIdx+1, remainArrow);
        }
    }
}
