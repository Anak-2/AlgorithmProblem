package ch12;

import java.util.ArrayList;
import java.util.Arrays;

public class 키패드_누르기 {
    class Solution {
        public String solution(int[] numbers, String hand) {
            StringBuilder sb = new StringBuilder();
//         *은 10으로
            int curLeft = 10;
//         #은 11로
            int curRight = 11;
            ArrayList<Integer> left = new ArrayList<>();
            ArrayList<Integer> right = new ArrayList<>();
            ArrayList<Integer> middle = new ArrayList<>();
            left.addAll(Arrays.asList(new Integer[] {1,4,7,10}));
            right.addAll(Arrays.asList(new Integer[] {3,6,9,11}));
            middle.addAll(Arrays.asList(new Integer[] {2,5,8,0}));
            for(int i : numbers){
                if(left.contains(i)){
                    curLeft = i;
                    sb.append("L");
                }
                else if(right.contains(i)){
                    curRight = i;
                    sb.append("R");
                }
                else{
                    int leftDist = 20;
                    int rightDist = 20;
                    if(left.contains(curLeft)){
                        leftDist = Math.abs(left.indexOf(curLeft) - middle.indexOf(i)) + 1;
                    }else{
                        leftDist = Math.abs(middle.indexOf(curLeft) - middle.indexOf(i));
                    }
                    if(right.contains(curRight)){
                        rightDist = Math.abs(right.indexOf(curRight) - middle.indexOf(i)) + 1;
                    }else{
                        rightDist = Math.abs(middle.indexOf(curRight) - middle.indexOf(i));
                    }
                    if(leftDist > rightDist){
                        curRight = i;
                        sb.append("R");
                    }else if(rightDist > leftDist){
                        curLeft = i;
                        sb.append("L");
                    }else{
                        if(hand.equals("right")){
                            curRight = i;
                            sb.append("R");
                        }else{
                            curLeft = i;
                            sb.append("L");
                        }
                    }
                }
            }
            String answer = sb.toString();
            return answer;
        }
    }
}
