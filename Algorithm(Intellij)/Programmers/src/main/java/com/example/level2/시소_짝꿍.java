package com.example.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 시소_짝꿍 {

    public static void main(String[] args) {
    }

    static class Solution {
        public long solution(int[] weights) {
            long answer = 0;

            Map<Double, Integer> map = new HashMap<>();

            for(int w : weights){
                double a = w * 1.0;
                double b = w * 2.0 / 3.0;
                double c = w * 1.0 / 2.0;
                double d = w * 3.0 / 4.0;

                if(map.containsKey(a)) answer += map.get(a);
                if(map.containsKey(b)) answer += map.get(b);
                if(map.containsKey(c)) answer += map.get(c);
                if(map.containsKey(d)) answer += map.get(d);

                map.put((double) w, map.getOrDefault((double) w, 0) + 1);
            }

            return answer;
        }

    }
}
