package com.example.algorithm.data_structure;

import java.util.ArrayList;
import java.util.List;

public class AutoCasting {

    public static void main(String[] args) {
        List<Integer> sample = new ArrayList<>(List.of(1,2,3,4,5));
        List<Integer> copy = new ArrayList<>(sample);
        copy.remove(3);
        List<Integer> copy2 = new ArrayList<>(sample);
        copy2.remove((Integer) 3);
        System.out.println(copy);
        System.out.println(copy2);
        JavaAuto javaAuto = new JavaAuto();
        javaAuto.compareAutoBoxing();
        javaAuto.compareExplicit();
    }

    private static class JavaAuto{

        protected void compareAutoBoxing(){
            long t = System.currentTimeMillis();
            Long sum = 0L;
            for (long i = 0; i < 1000000; i++) {
                sum += i;
            }
            System.out.println("실행 시간: " + (System.currentTimeMillis() - t) + " ms");
        }

        protected void compareExplicit(){
            long t = System.currentTimeMillis();
            Long sum = 0L;
            long primitiveSum = sum.longValue();
            for (long i = 0; i < 1000000; i++) {
                primitiveSum += i;
            }
            sum = (Long) primitiveSum;
            System.out.println("실행 시간: " + (System.currentTimeMillis() - t) + " ms");
        }
    }
}
