package level2;

import java.util.*;
import java.math.*;

public class No5 {

    public static void main(String[] args) {
        Solution5 s = new Solution5();
        int[] answer = s.solution(new int[]{180, 5000, 10, 600},
                new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN"
                        , "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"});
        System.out.println(Arrays.toString(answer));
    }
}

class Solution5 {
    static int[] fees;
    public int[] solution(int[] fees, String[] records) {
        int[] answer;
        this.fees = fees;
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> cost_map = new HashMap<>();

        for(String car : records){
            String[] car_info = car.split(" ");
            int time = cal_time(car_info[0]);
            int car_num = Integer.parseInt(car_info[1]);
            String in_out = car_info[2];

//             이전에 입차한 기록이 없으면 map에 넣기
            if(!map.containsKey(car_num)){
                map.put(car_num, time);
            }else{
//                 map 에서 제거
                int in_time = map.remove(car_num);
//                 이전에 입차한 시간에 더하기
                if(cost_map.containsKey(car_num)){
                    int prev_time = cost_map.get(car_num);
                    cost_map.replace(car_num, prev_time + (time - in_time));
                }else{
                    cost_map.put(car_num, (time - in_time));
                }
            }
        }

//         map에 남아있는 차가 있으면 23:59 출차로 계산해서 요금 맵 업데이트 해주기
        Set<Integer> keySet = map.keySet();
        for(Integer key : keySet){
            int in_time = map.get(key);
            if(cost_map.containsKey(key)){
                int prev_time = cost_map.get(key);
                cost_map.replace(key, prev_time + (1439 - in_time));
            }else{
                cost_map.put(key, (1439 - in_time));
            }
        }

        answer = new int[cost_map.size()];
//         차 번호 낮은 순으로 요금 정렬하기
        ArrayList<int[]> list = new ArrayList<>();
        keySet = cost_map.keySet();
        for(Integer key : keySet){
            int total_time = cost_map.get(key);
            int cost = cal_cost(total_time);
            list.add(new int[]{key, cost});
        }
        Collections.sort(list,
                (int[] a, int[] b) -> {return a[0] - b[0];});

        int i = 0;
        for(int[] e : list){
            System.out.println("car num: "+e[0]+" cost: "+e[1]);
            answer[i] = e[1];
            i++;
        }
        return answer;
    }

    public int cal_time(String strTime){
        int time = 0;
        String[] splitTime = strTime.split(":");
        time += Integer.parseInt(splitTime[0])*60;
        time += Integer.parseInt(splitTime[1]);
        return time;
    }

    public int cal_cost(int total_time){
        int over_time = total_time - fees[0];
        if(over_time <= 0) return fees[1];
        else{
            return (int) Math.ceil(over_time/(double)fees[2]) * fees[3] + fees[1];
        }
    }
}