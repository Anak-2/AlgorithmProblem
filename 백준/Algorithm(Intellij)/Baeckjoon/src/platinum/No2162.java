package platinum;

import java.util.*;
import java.io.*;

public class No2162 {

//    선분의 정보를 저장
    static class Segment{
//        기울기
        double inclination;
//        상수
        double constant;
//        x 상수 함수인지 y 상수 함수인지
        boolean xConstant = false;
        double x1;
        double x2;
        double y1;
        double y2;

        public Segment(double inclination, double constant, double x1, double y1, double x2, double y2){
            this.inclination = inclination;
            this.constant = constant;
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }

    static int N;
    static ArrayList<Segment> segmentList = new ArrayList<>();
    static int[] parents;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        parents = new int[N];
        for(int i = 0; i < N; i++){
            parents[i] = i;
        }
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            double x1 = Double.parseDouble(st.nextToken());
            double y1 = Double.parseDouble(st.nextToken());
            double x2 = Double.parseDouble(st.nextToken());
            double y2 = Double.parseDouble(st.nextToken());
            double incline = 0;
            double constant = 0;
            Segment cur;
            if((x2 - x1) != 0){
                incline = (y2 - y1 ) / (x2 - x1);
                constant = y1 - incline*x1;
                cur = new Segment(incline, constant, x1, y1, x2, y2);
            }
//            x 증가율이 0이면 x 상수
            else{
                cur = new Segment(incline, constant, x1, y1, x2, y2);
                cur.xConstant = true;
                constant = x1;
            }
            segmentList.add(cur);
        }

        for(int i = 0; i < N; i++){
            for(int j = i+1; j < N; j++){
                if(isCross(segmentList.get(i), segmentList.get(j))){
                    union(i,j);
                }
            }
        }

        System.out.println(Arrays.toString(parents));

        HashSet<Integer> set = new HashSet<>();
        int[] cnt = new int[N];
        int maxGroup = 0;
        for(int i = 0; i < N; i++){
            set.add(parents[i]);
            cnt[parents[i]]++;
        }
        for(int i = 0; i < N; i++){
            maxGroup = Math.max(maxGroup, cnt[i]);
        }
        System.out.println(set.size());
        System.out.println(maxGroup);
    }

    public static boolean isCross(Segment seg1, Segment seg2){
        double crossX = 0;
        double crossY = 0;
//        기울기가 다를 때
        if(seg2.inclination != seg1.inclination){
//            seg1 이 x = a 꼴인 x 상수일 때
            if(seg1.xConstant){
                crossX = seg1.constant;
                crossY = seg2.inclination*crossX + seg2.constant;
//            seg2 가 x = a 꼴인 x 상수일 때
            }else if(seg2.xConstant){
                crossX = seg2.constant;
                crossY = seg1.inclination*crossX + seg1.constant;
            }else{
                crossX = (seg2.constant - seg1.constant) / (seg2.inclination - seg1.inclination);
                crossY = seg2.constant * crossX + seg2.constant;
            }
        }else{
//            기울기가 같을 때 상수도 같으면 일치
            if(seg1.constant == seg2.constant){
//                기울기가 0으로 같을 때
                if(seg1.inclination == 0){
                    if(seg1.xConstant && seg2.xConstant){
                        crossX = seg1.x1;
                        crossY = Double.MAX_VALUE/2;
                    }
//                    seg1만 x 상수일 때
                    else if(seg1.xConstant){
                        crossX = seg1.x1;
                        crossY = seg2.y1;
                    }
//                    seg2만 x 상수일 때
                    else if(seg2.xConstant){
                        crossX = seg2.x1;
                        crossY = seg1.y1;
                    }
//                    seg1, seg2 모두 y = a 꼴인 상수함수 일 때
                    else{
                        crossX = Double.MAX_VALUE/2;
                        crossY = seg1.y1;
                    }
                }
//                두 직선이 일치하는 경우
                else if(seg1.constant == seg2.constant){
                    crossX = Double.MAX_VALUE/2;
                    crossY = Double.MAX_VALUE/2;
                }
            }
        }
        System.out.println("x: "+crossX+" y: "+crossY);
        if(isBetween(seg1, seg2, crossX, crossY)){
           return true;
        }
        return false;
    }

    public static boolean isBetween(Segment seg1, Segment seg2, double targetX, double targetY){
        if(targetX == Double.MAX_VALUE/2 || targetY == Double.MAX_VALUE/2){
            // seg 선분과 seg2 선분이 만나지 않음.
            if ((seg1.y1 > seg2.y1 && seg1.y1 > seg2.y2 && seg1.y2 > seg2.y1 && seg1.y2 > seg2.y2)
                    || (seg2.y1 > seg1.y1 && seg2.y1 > seg1.y2 && seg2.y2 > seg1.y1 && seg2.y2 > seg1.y2)) {
                return false;
            }else{
                return true;
            }
        }
        if(seg1.x1 > seg1.x2){
            if(targetX > seg1.x1 || targetX < seg1.x2){
                return false;
            }
        }else{
            if(targetX > seg1.x2 || targetX < seg1.x1){
               return false;
            }
        }
        if(seg2.x1 > seg2.x2){
            if(targetX > seg2.x1 || targetX < seg2.x2){
                return false;
            }
        }else{
            if(targetX > seg2.x2 || targetX < seg2.x1){
                return false;
            }
        }
        if(seg1.y1 > seg1.y2){
            if(targetY > seg1.y1 || targetY < seg1.y2){
                return false;
            }
        }else{
            if(targetY < seg1.y1 || targetY > seg1.y2){
                return false;
            }
        }
        if(seg2.y1 > seg2.y2){
            if(targetY > seg2.y1 || targetY < seg2.y2){
                return false;
            }
        }else{
            if(targetY < seg2.y1 || targetY > seg2.y2){
                return false;
            }
        }
        return true;
    }

//    자기가 포함된 그룹의 root 반환
    public static int find(int idx){
        if(parents[idx] == idx){
            return idx;
        }
        return parents[idx] = find(parents[idx]);
    }

//    두 그룹을 합치기
    public static void union(int idx1, int idx2){
        int parent1 = find(idx1);
        int parent2 = find(idx2);
        if(parent1 != parent2){
            if(parent1 < parent2){
                parents[idx2] = parent1;
            }else{
                parents[idx1] = parent2;
            }
        }
    }
}
