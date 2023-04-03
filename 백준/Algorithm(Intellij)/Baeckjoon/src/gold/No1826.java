package gold;

import java.util.*;
import java.io.*;

class Truck {
    int fuel = 0;
    //    트럭의 주유소 index
    int oilLoc = 0;
    //    트럭의 주유소 들린 횟수
    int visitOil = 0;

    Truck(int fuel, int oilLoc, int visitOil) {
        this.fuel = fuel;
        this.oilLoc = oilLoc;
        this.visitOil = visitOil;
    }

}

// 연료 채우기
public class No1826 {
    static int[][] oilArr;
    static int target;
    static PriorityQueue<Integer> possibleOil = new PriorityQueue<>(Collections.reverseOrder());
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
//        위치, 연료 저장하는 arr
        oilArr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            oilArr[i][0] = Integer.parseInt(st.nextToken());
            oilArr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(oilArr, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
//        for(int[] i : oilArr){
//            for(int j : i){
//                System.out.printf("%d ",j);
//            }
//            System.out.println();
//        }
        st = new StringTokenizer(br.readLine());
        target = Integer.parseInt(st.nextToken());
        Truck truck = new Truck(Integer.parseInt(st.nextToken()), 0, 0);
        if(findOil(truck)){
            System.out.println(truck.visitOil);
        }else{
            System.out.println(-1);
        }
    }

    public static boolean findOil(Truck truck) {
//        트럭이 남은 연료로 목표 지점에 도달하지 못 할때
        if (target > truck.fuel) {
//            방문할 수 있는 주유소가 있을 때
            for(int i = truck.oilLoc; i < oilArr.length; i++){
                if(truck.fuel >= oilArr[i][0]){
                    possibleOil.add(oilArr[i][1]);
                    truck.oilLoc = i+1;
                }else break;
            }
            while(!possibleOil.isEmpty()){
                truck.fuel += possibleOil.poll();
                truck.visitOil++;
                if(findOil(truck)){
                    return true;
                }
            }
            return false;
        } else {
            return true;
        }
    }
}
