package com.example.level2;

import java.util.ArrayList;
import java.util.List;

public class 테이블_해시_함수 {

    class Solution {

        private static List<int[]> table = new ArrayList<>();

        public int solution(int[][] data, int col, int row_begin, int row_end) {
            int answer = 0;
            for(int i = 0; i < data.length; i++){
                addPk(data[i], i);
            }
            sortByColAndPk(col);
            answer = calSi(row_begin, row_end);
            return answer;
        }

        // data를 기반으로 List에 pk 포함해서 저장
        private void addPk(int[] data, int idx){
            int[] newArr = new int[data.length+1];
            newArr[0] = idx;
            for(int i = 1; i < data.length + 1; i++){
                newArr[i] = data[i-1];
            }
            table.add(newArr);
        }

        // table을 정렬
        private void sortByColAndPk(int col){
            table.sort((int[] a, int[] b) -> {
                if(a[col] != b[col]) return a[col] - b[col];
                return b[1] - a[1];
            });
        }

        // begin - end 의 S_i Xor연산 구하기
        private int calSi(int row_begin, int row_end){
            int answer = 0;
            for(int i = row_begin-1; i < row_end; i++){
                int[] data = table.get(i);
                int si = 0;
                for(int j = 1; j < data.length; j++){
                    si += data[j] % (i+1);
                }
                answer = answer ^ si;
            }
            return answer;
        }
    }
}
