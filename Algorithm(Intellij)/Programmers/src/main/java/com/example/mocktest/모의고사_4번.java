package com.example.mocktest;

import java.util.PriorityQueue;

public class 모의고사_4번 {

    static class Solution {

        private static class Info {
            // 현재 위치
            int[] loc;
            // 소요된 시간
            int time;
            // 찬스 사용 가능 여부
            boolean chance;

            public Info(int[] loc, int time, boolean chance) {
                this.loc = loc;
                this.time = time;
                this.chance = chance;
            }
        }

        // 안 지나간 자리 0 , 점프권 없는 애가 지나간 자리 1 , 점프권 있는 애가 지나간 자리 2
        int[][] map;
        int n;
        int m;

        public int solution(int n, int m, int[][] hole) {
            int answer = Integer.MAX_VALUE / 2;
            this.n = n;
            this.m = m;
            // (1,1) ~ (n,m) 사용
            map = new int[n + 1][m + 1];
            int[] dr = new int[]{-1, 1, 0, 0};
            int[] dc = new int[]{0, 0, 1, -1};
            // map에 구멍 표시
            for (int[] h : hole) {
                map[h[0]][h[1]] = -1;
            }

            PriorityQueue<Info> pq = new PriorityQueue<>(
                    (Info a, Info b) -> {
                        // 소요된 시간
                        return a.time - b.time;
                    }
            );

            pq.add(new Info(new int[]{1, 1}, 0, true));

            while (!pq.isEmpty()) {
                Info curInfo = pq.poll();
                if (curInfo.loc[0] == n && curInfo.loc[1] == m) {
                    int temp = curInfo.time;
                    if (curInfo.chance) {
                        temp--;
                    }
                    answer = temp;
                    break;
                }
                for (int i = 0; i < 4; i++) {
                    int[] nextLoc = new int[]{curInfo.loc[0] + dr[i], curInfo.loc[1] + dc[i]};
                    int nextTime = curInfo.time + 1;
                    if (canMove(nextLoc, nextTime, curInfo.chance)) {
                        // 장애물 여부
                        if (map[nextLoc[0]][nextLoc[1]] == -1) {
                            if (curInfo.chance) {
                                // 장애물 점프
                                if (i == 0) {
                                    nextLoc[0]--;
                                } else if (i == 1) {
                                    nextLoc[0]++;
                                } else if (i == 2) {
                                    nextLoc[1]++;
                                } else {
                                    nextLoc[1]--;
                                }
                                if (!canMove(nextLoc, nextTime, false)) {
                                    continue;
                                }
                                // 점프해도 장애물이면 스킵
                                if (map[nextLoc[0]][nextLoc[1]] == -1) {
                                    continue;
                                }
                                map[nextLoc[0]][nextLoc[1]] = 1;
                                Info nextInfo = new Info(nextLoc, nextTime, false);
                                pq.add(nextInfo);
                            } else {
                                continue;
                            }
                        } else {
                            map[nextLoc[0]][nextLoc[1]] = curInfo.chance ? 2 : 1;
                            Info nextInfo = new Info(nextLoc, nextTime, curInfo.chance);
                            pq.add(nextInfo);
                        }
                    }
                }
            }

            if (answer == Integer.MAX_VALUE / 2) {
                return -1;
            }
            return answer;
        }

        private boolean canMove(int[] loc, int time, boolean chance) {
            // 바깥
            if (loc[0] < 1 || loc[1] < 1 || loc[0] > n || loc[1] > m) {
                return false;
            }
            // 점프권 없는 애는 누가 이미 지나간 자리 못 지나감
            if (!chance) {
                if (map[loc[0]][loc[1]] > 0) {
                    return false;
                }
            }
            // 점프권 있던 애가 지나간 자리면 못 지나감
            else if (chance) {
                if (map[loc[0]][loc[1]] == 2) {
                    return false;
                }
            }
            return true;
        }
    }
}
