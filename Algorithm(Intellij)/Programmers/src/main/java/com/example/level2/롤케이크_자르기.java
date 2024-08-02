package com.example.level2;

import java.util.*;

class 롤케이크_자르기 {

    Map<Integer, Integer> left = new HashMap<>();
    Map<Integer, Integer> right = new HashMap<>();

    public int solution(int[] topping) {
        int answer = 0;

        for(int i = 0; i < topping.length; i++){
            right.put(topping[i], right.getOrDefault(topping[i],0) + 1);
        }
        for(int i = 0; i < topping.length - 1; i++){
            int cur = topping[i];
            left.put(cur, left.getOrDefault(cur,0) + 1);
            right.put(cur, right.get(cur) - 1);
            if(right.get(cur) == 0){
                right.remove(cur);
            }
            if(checkRollCake()){
                answer++;
            }
        }
        return answer;
    }

    private boolean checkRollCake(){
        return left.keySet().size() == right.keySet().size();
    }
}