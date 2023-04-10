package gold;

import java.util.*;
import java.io.*;

class Point{
    int x;
    int y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

public class No14499 {
    
    static int N,M; // map 크기
    static int x,y; // 주사위 위치
    static int k; // 명령의 개수
    static int[][] map;
    static Point point;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        st = new StringTokenizer(br.readLine());
        int[] dice = new int[6];
        int direction;
        point = new Point(x,y);
        for(int i = 0; i < k; i++){
            direction = Integer.parseInt(st.nextToken());
            if(roll(direction, dice)){
//                System.out.println(point);
//                System.out.println(Arrays.toString(dice));
                System.out.println(dice[5]);
            }
        }
    }
    
//    주사위를 굴리는 함수
//    @parameter : 굴리는 방향, 현재 주사위 바닥,동,서,남,북,천장 정보, 현재 위치
//    @return : 주사위 윗 면의 수, false 인 경우 못 가는 좌표
    public static boolean roll(int direction, int[] dice){
        int eastTemp = dice[1];
        int westTemp = dice[2];
        int southTemp = dice[3];
        int northTemp = dice[4];
        int floorTemp = dice[0];
        int ceilTemp = dice[5];
//        다음 위치가 이동 불가능할 때
        if(!isAvailable(direction)){
            return false;
        }
        switch(direction) {
//        동쪽 이동
            case 1:
//                동,서 -> 바닥,천장
                dice[0] = eastTemp;
                dice[5] = westTemp;
//                바닥,천장 -> 서,동
                dice[2] = floorTemp;
                dice[1] = ceilTemp;
                break;
//        서
            case 2:
//                서,동 -> 바닥,천장
                dice[0] = westTemp;
                dice[5] = eastTemp;
//                바닥,천장 -> 동,서
                dice[1] = floorTemp;
                dice[2] = ceilTemp;
                break;
//        북
            case 3:
//                북,남 -> 바닥,천장
                dice[0] = northTemp;
                dice[5] = southTemp;
//                바닥,천장 -> 남,북
                dice[3] = floorTemp;
                dice[4] = ceilTemp;
                break;
//        남
            case 4:
//                남,북 -> 바닥,천장
                dice[0] = southTemp;
                dice[5] = northTemp;
//                바닥,천장 -> 북,남
                dice[4] = floorTemp;
                dice[3] = ceilTemp;
                break;
        }
        // 이동한 바닥이 0일 때
        if(map[point.x][point.y] == 0){
            map[point.x][point.y] = dice[0];
        }else{
            dice[0] = map[point.x][point.y];
            map[point.x][point.y] = 0;
        }
        return true;
    }

    public static boolean isAvailable(int direction){
        int nextX = point.x;
        int nextY = point.y;
        switch(direction){
//          동
            case 1:
                nextY += 1;
                if(nextY < 0 || nextY >= M) return false;
                break;
//          서
            case 2:
                nextY -= 1;
                if(nextY < 0 || nextY >= M) return false;
                break;
//          북
            case 3:
                nextX -= 1;
                if(nextX < 0 || nextX >= N) return false;
                break;
//          남
            case 4:
                nextX += 1;
                if(nextX < 0 || nextX >= N) return false;
                break;
        }
//        System.out.println("nextX: "+nextX+" nextY: "+nextY);
        point.x = nextX;
        point.y = nextY;
        return true;
    }
}
