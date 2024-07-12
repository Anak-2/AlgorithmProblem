package com.example.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 당구_연습 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(Solution.solution(10, 10, 3, 7, new int[][]{
                {7, 7}, {2, 7}, {7, 3}
        })));
    }

    private static class Solution{

        private static int M;
        private static int N;

        public static int[] solution(int m, int n, int startX, int startY, int[][] balls) {
            List<Integer> answerList = new ArrayList<>();

            M = m;
            N = n;
            String xAxis1 = "x="+M;
            String xAxis2 = "x="+0;
            String yAxis1 = "y="+N;
            String yAxis2 = "y="+0;

            String[] cases = new String[]{xAxis1, xAxis2, yAxis1, yAxis2};

            Point startP = new Point(startX, startY);
            for(int[] ball : balls){
                int min = Integer.MAX_VALUE / 2;
                Point p = new Point(ball[0], ball[1]);
                for(String eachCase : cases){
                    Point flipedPoint = flipPoint(startP, new Point(p), eachCase);
                    min = Math.min(min, (int) flipedPoint.getDistance(startP));
                    System.out.println(min);
                }
                answerList.add(min);
            }

            return answerList.stream().mapToInt(Integer::intValue).toArray();
        }

        // x=0, y=0, x=m, y=n 으로 flip
        public static Point flipPoint(Point startP, Point p, String baseLine){
            Point copyP = new Point(p);
            String[] arr = baseLine.split("=");
            String axis = arr[0];
            int val = Integer.parseInt(arr[1]);
            if(axis.equals("x")){
                if(val > 0){
                    p.x += M - p.x;
                }else{
                    p.x += M;
                }
                if(calSlope(startP, copyP) == calSlope(startP, p)){
                    return copyP;
                }
            }else if(axis.equals("y")){
                if(val > 0){
                    p.y += N - p.y;
                }else{
                    p.y += N;
                }
                if(calSlope(startP, copyP) == calSlope(startP, p)){
                    System.out.println("기울기 같음");
                    return copyP;
                }
            }else{
                System.out.println("axis는 x 또는 y");
            }
            return p;
        }

        public static double calSlope(Point a, Point b){
            return (double) (b.y - a.y) / (b.x - a.x);
        }
    }

    private static class Point{
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        public Point(Point p){
            this.x = p.x;
            this.y = p.y;
        }

        public double getDistance(Point anotherPoint){
            double distance = Math.pow(this.x - anotherPoint.x,2) + Math.pow(this.y - anotherPoint.y,2);
            return distance;
        }
    }
}
