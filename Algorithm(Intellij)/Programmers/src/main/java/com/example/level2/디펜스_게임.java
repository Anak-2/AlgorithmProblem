package com.example.level2;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class 디펜스_게임 {

    public static void main(String[] args) {
        System.out.println(Solution.solution(7, 3, new int[]{4, 2, 4, 5, 3, 3, 1}));
    }

    class Solution {
        public static int solution(int n, int k, int[] enemy) {
            int answer = enemy.length;
            Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            int my = n;
            int card = k;
            for (int i = 0; i < enemy.length; i++) {
                my -= enemy[i];
                pq.add(enemy[i]);

                if (my < 0) {
                    if (card > 0 && !pq.isEmpty()) {
                        my += pq.poll();
                        card--;
                    } else {
                        answer = i;
                        break;
                    }
                }
            }

            return answer;
        }
    }
}
