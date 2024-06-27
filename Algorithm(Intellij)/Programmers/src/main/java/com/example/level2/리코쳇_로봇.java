package com.example.level2;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 리코쳇_로봇 {

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] board = new String[]{"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
        System.out.println(s.solution(board));
    }

    static class Solution {

        int min = Integer.MAX_VALUE / 2;
        String[][] myBoard;
        int[] rLoc;
        PriorityQueue<BFS> bfsQueue = new PriorityQueue<>(1, Comparator.comparingInt(d -> d.depth));

        public int solution(String[] board) {
            myBoard = new String[board.length][];
            for (int i = 0; i < board.length; i++) {
                myBoard[i] = board[i].split("");
            }

            boolean flag = false;
            for (int i = 0; i < myBoard.length; i++) {
                for (int j = 0; j < myBoard[i].length; j++) {
                    if (myBoard[i][j].equals("R")) {
                        flag = true;
                        rLoc = new int[]{i, j};
                        break;
                    }
                }
                if (flag) break;
            }

            boolean[][] visited = new boolean[myBoard.length][myBoard[0].length];
            bfs(rLoc, visited);

            if (min == Integer.MAX_VALUE / 2) {
                return -1;
            }
            return min;
        }

        private void bfs(int[] loc, boolean[][] visited) {
            BFS b = new BFS(0, loc);
            bfsQueue.add(b);
            while (!bfsQueue.isEmpty()) {
                BFS nextB = bfsQueue.poll();
                int r = nextB.loc[0];
                int c = nextB.loc[1];

                if (myBoard[r][c].equals("G")) {
                    min = Math.min(min, nextB.depth);
                    return;
                }

                int[] dr = new int[]{1, -1, 0, 0};
                int[] dc = new int[]{0, 0, 1, -1};
                int[] nextLoc;

                for (int i = 0; i < 4; i++) {
                    nextLoc = new int[]{r, c};
                    while (true) {
                        nextLoc[0] += dr[i];
                        nextLoc[1] += dc[i];
                        if (!isMovable(nextLoc)) {
                            nextLoc[0] -= dr[i];
                            nextLoc[1] -= dc[i];
                            break;
                        }
                    }
                    if (visited[nextLoc[0]][nextLoc[1]]) {
                        continue;
                    }
                    visited[nextLoc[0]][nextLoc[1]] = true;
                    bfsQueue.add(new BFS(nextB.depth+1,nextLoc));
                }
            }
        }

        private boolean isMovable(int[] loc) {
            return !(myBoard.length <= loc[0] || myBoard[0].length <= loc[1] || loc[0] < 0 || loc[1] < 0
                    || myBoard[loc[0]][loc[1]].equals("D"));
        }

        static class BFS {
            int depth;
            int[] loc;

            public BFS(int depth, int[] loc) {
                this.depth = depth;
                this.loc = loc;
            }
        }
    }
}
