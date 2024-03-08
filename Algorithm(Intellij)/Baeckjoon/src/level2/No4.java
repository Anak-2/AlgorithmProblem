package level2;

import java.util.*;
import java.math.*;

public class No4 {
    public static void main(String[] args) {
        Solution4 s = new Solution4();
        s.solution(5, new int[]{2,1,1,1,0,0,0,0,0,0,0});

        ArrayList<int[]> arr = new ArrayList<>();
        Collections.sort(arr, (int[] o1, int[] o2) -> {
            return o1[0] - o2[0];
        }
        );
    }
}

class Solution4 {
    //     n: 쏜 화살의 개수
//     info[]: 10~0 점 맞춘 화살의 개수
    static int len = 0;
    static int[] answer = null;
    static int[] apeach = new int[11];
    static int score = 0;


    public int[] solution(int n, int[] info) {
//         라이언이 어피치보다 더 많은 화살을 과녁에 맞춰야 점수 획득
        len = n;
        apeach = info;
        int[] rion = new int[11];
        Arrays.fill(rion, 0);
        divide(rion, 0, n);
        System.out.println(score);
        System.out.println(Arrays.toString(answer));
        if(answer == null){
            return new int[]{-1};
        }
        return answer;
    }

    public void getDiffScore(int[] apeach, int[] rion){
        int rionScore = 0;
        int apeachScore = 0;

        for(int i = 0; i < 11; i++){
            if(rion[i] > apeach[i]){
                rionScore += (10 - i);
            }else if(apeach[i] != 0){
                apeachScore += (10 - i);
            }
        }

        int diff = rionScore - apeachScore;
        if(diff > score){
            score = diff;
            answer = rion.clone();
        }else if(diff == score){
            for(int i = 10; i >= 0; i--){
                if(answer[i] < rion[i]){
                    answer = rion.clone();
                    break;
                }
            }
        }
    }

    //     이전 rion 배열을 s 부터 끝까지 a개의 화살을 배치
    public void divide(int[] rion, int s, int a){
//         화살이 다 떨어졌을 때
        if(a == 0) {
//            System.out.println(Arrays.toString(rion));
            getDiffScore(apeach, rion);
            return;
        }
//         마지막 index 일 때
        if(s == 10){
            rion[s] = a;
//            System.out.println(Arrays.toString(rion));
            getDiffScore(apeach, rion);
            return;
        }
        for(int i = 0; i <= a; i++){
            rion[s] = a - i;
            if(i == 0) {
//                System.out.println(Arrays.toString(rion));
                getDiffScore(apeach, rion);
                continue;
            }
            divide(rion.clone(), s+1, i);
        }
    }
}