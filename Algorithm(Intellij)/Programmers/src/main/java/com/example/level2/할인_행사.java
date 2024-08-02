package com.example.level2;
import java.util.*;

class 할인_행사 {

    Map<String, Integer> saleMap = new HashMap<>();
    int windowSize = 10;
    int answer = 0;

    public int solution(String[] want, int[] number, String[] discount) {
        try{
            // init saleMap
            for(int i = 0; i < windowSize; i++){
                saleMap.put(discount[i], saleMap.getOrDefault(discount[i], 0) + 1);
            }
            if(discount.length == windowSize){
                updateAnswer(want, number);
                return answer;
            }
            // check answer
            for(int i = 0; i < discount.length - windowSize; i++){
                updateAnswer(want, number);

                String removeItem = discount[i];
                String insertItem = discount[i+windowSize];
                // update saleMap
                saleMap.put(removeItem, saleMap.get(removeItem) - 1);
                saleMap.put(insertItem, saleMap.getOrDefault(insertItem, 0) + 1);
            }
            updateAnswer(want, number);
            return answer;
        }catch(Exception e){
            System.out.println("예외가 발생했습니다: " + e.getMessage());
            e.printStackTrace();
            return answer;
        }
    }

    private void updateAnswer(String[] want, int[] number){
        for(int i = 0; i < want.length; i++) {
            if(saleMap.get(want[i]) == null || saleMap.get(want[i]) < number[i]) {
                return;
            }
        }
        answer++;
    }
}