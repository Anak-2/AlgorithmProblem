package com.example.level2;

import java.util.ArrayList;
import java.util.List;

public class 우박수열_정적분 {
    public double[] solution(int k, int[][] ranges) {

        List<Integer> calResults = new ArrayList<>();
        calResults.add(k);
        while(k > 1){
            k = cal(k);
            calResults.add(k);
        }

        double[] answer = new double[ranges.length];
        for(int i = 0; i < ranges.length; i++){
            int a = ranges[i][0];
            int b = ranges[i][1];
            answer[i] = calArea(calResults, a, b);
        }

        return answer;
    }

    private int cal(int k){
        if(k > 1){
            if(k % 2 == 0){
                k = k/2;
            }else{
                k = k * 3 + 1;
            }
        }
        return k;
    }

    private double calArea(List<Integer> calResults, int a, int b){
        int rangeB = calResults.size() + b;
        if(rangeB <= a) return -1;
        int totalSide = 0;
        for(int i = a; i < rangeB - 1; i++){
            totalSide = totalSide + calResults.get(i) + calResults.get(i+1);
        }
        return (double) totalSide / 2;
    }
}
