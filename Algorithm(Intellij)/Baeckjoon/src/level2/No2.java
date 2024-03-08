package level2;

import java.util.*;
import java.io.*;

public class No2 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[][]{{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200},
                {32, 6900}}, new int[]{1300, 1500, 1600, 4900});
    }
}


class Solution {

    static int emoticon_plus = 0;
    static int total = 0;
    static int[][] users;
    static int[] emoticons;

    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        this.users = users;
        this.emoticons = emoticons;

        HashSet<Integer> s = new HashSet<>();
        for(int i = 0; i < users.length; i++){
            s.add(users[i][0]);
        }
        ArrayList<Integer> sales = new ArrayList<>(s);
        Collections.sort(sales);
        int[] salesArr = new int[emoticons.length];
        Arrays.fill(salesArr,0);
        permutation(salesArr, 0, sales);
        answer[0] = emoticon_plus;
        answer[1] = total;
        return answer;
    }

    //  유저가 이모티콘 플러스를 가입하는지, 가입 안한다면 총 얼마 지불하는지 계산
    public int cal_emoticon(int[] user_info, int[] emoticons, int[] salesArr){
        int emo_cnt = emoticons.length; //이모티콘 개수
        int total = 0;
        for(int i = 0; i < emo_cnt; i++){
//             할인율이 유저가 원하는 것 보다 크면 구입
            if(salesArr[i] >= user_info[0]){
                total += (emoticons[i] / 100) * (100 - salesArr[i]);
            }
        }
//         총 구매 가격이 한계를 넘으면 이모티콘 플러스 가입
        if(total >= user_info[1]){
            return -1;
        }else{
            return total;
        }
    }

    public void permutation(int[] salesArr, int index, ArrayList<Integer> sales){
        if(index >= salesArr.length) return;
//         sale 의 경우의 수 만큼 현재 emoticon 세일 바꿔보기
        for(int i = 0; i < sales.size(); i++){
            salesArr[index] = sales.get(i);
            System.out.println(Arrays.toString(salesArr));
            int user_total = 0;
            int emoticon_plus_total = 0;
            for(int j = 0; j < users.length; j++){
                int result = cal_emoticon(users[j], emoticons, salesArr);
                if(result == -1) emoticon_plus_total += 1;
                else user_total += result;
            }
            if(emoticon_plus < emoticon_plus_total){
                emoticon_plus = emoticon_plus_total;
                total = user_total;
            }else if(emoticon_plus == emoticon_plus_total && total < user_total){
                total = user_total;
            }
            if(emoticon_plus_total == 4){
                System.out.println(user_total+" "+emoticon_plus_total);
            }
            int[] newArr = salesArr.clone();
            permutation(newArr, index+1, sales);
        }
    }

}
