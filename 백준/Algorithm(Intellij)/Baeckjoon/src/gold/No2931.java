package gold;

import java.util.*;
import java.io.*;

// 가스관, DFS + 구현
public class No2931 {
    static int R;
    static int C;
    static char[][] map;

    public static class needPipe{
//        필요한 파이브 위치 저장
        int r;
        int c;

//        0 1 2 3 , 동 서 남 북 필요한 파이프 방향 저장
        boolean[] direction = new boolean[4];
    }

//    m에서 z까지 갔는지 검사
//    static boolean visitTarget;

    static needPipe ans = new needPipe();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
//        z,m 위치 저장
        int[][] start = new int[2][2];
        for(int i = 0; i < R; i++){
            char[] charArr = br.readLine().toCharArray();
            for(int j = 0; j < C; j++){
                map[i][j] = charArr[j];
                if(map[i][j] == 'M'){
                    start[0][0] = i;
                    start[0][1] = j;
                }else if(map[i][j] == 'Z'){
                    start[1][0] = i;
                    start[1][1] = j;
                }
            }
        }
        boolean[][] visited = new boolean[R][C];
        visited[start[0][0]][start[0][1]] = true;
        visited[start[1][0]][start[1][1]] = true;
//        M에서 출발
        bfs(start[0][0], start[0][1], visited);
        bfs(start[1][0], start[1][1], visited);
        ans.r += 1;
        ans.c += 1;
        System.out.print(ans.r+" "+ans.c+" ");
        if(ans.direction[0] && ans.direction[1] && ans.direction[2] && ans.direction[3]){
            System.out.println('+');
        }else if(ans.direction[0] && ans.direction[1]){
            System.out.println('-');
        }else if(ans.direction[2] && ans.direction[3]){
            System.out.println('|');
        }else if(ans.direction[0] && ans.direction[2]){
            System.out.println('1');
        }else if(ans.direction[0] && ans.direction[3]){
            System.out.println('2');
        }else if(ans.direction[1] && ans.direction[3]){
            System.out.println('3');
        }else if(ans.direction[1] && ans.direction[2]){
            System.out.println('4');
        }
    }

//    현재 좌표 파이프에 따라 이동할 다음 칸 stack에 저장
    public static void move(int r, int c, int d, ArrayList<int[]> stack, boolean[][] visited){
        visited[r][c] = true;
        if(map[r][c] == '.'){
            ans.r = r;
            ans.c = c;
            ans.direction[d] = true;
            visited[r][c] = false;
        }else if(map[r][c] == '1'){
//            동, 남 이동
            if(isAvailable(r+1,c,visited))stack.add(new int[]{r+1,c,3});
            if(isAvailable(r,c+1,visited))stack.add(new int[]{r,c+1,1});
        }else if(map[r][c] == '2'){
//            북, 동 이동
            if(isAvailable(r-1,c,visited))stack.add(new int[]{r-1,c,2});
            if(isAvailable(r,c+1,visited))stack.add(new int[]{r,c+1,1});
        }else if(map[r][c] == '3'){
//            서, 북 이동
            if(isAvailable(r-1,c,visited))stack.add(new int[]{r-1,c,2});
            if(isAvailable(r,c-1,visited))stack.add(new int[]{r,c-1,0});
        }else if(map[r][c] == '4'){
//            서, 남 이동
            if(isAvailable(r+1,c,visited))stack.add(new int[]{r+1,c,3});
            if(isAvailable(r,c-1,visited))stack.add(new int[]{r,c-1,0});
        }else if(map[r][c] == '|'){
//            남, 북 이동
            if(isAvailable(r+1,c,visited))stack.add(new int[]{r+1,c,3});
            if(isAvailable(r-1,c,visited))stack.add(new int[]{r-1,c,2});
        }else if(map[r][c] == '-'){
//            동, 서 이동
            if(isAvailable(r,c+1,visited))stack.add(new int[]{r,c+1,1});
            if(isAvailable(r,c-1,visited))stack.add(new int[]{r,c-1,0});
        }else if(map[r][c] == '+'){
//            동, 서, 남, 북 이동
//            동쪽으로 이동하는데 빈칸을 만나면 서쪽으로 연결된 파이프가 필요한 것이므로 r,c 다음 d값엔 1 넣기
            if(isAvailable(r,c+1,visited))stack.add(new int[]{r,c+1,1});
            if(isAvailable(r,c-1,visited))stack.add(new int[]{r,c-1,0});
            if(isAvailable(r+1,c,visited))stack.add(new int[]{r+1,c,3});
            if(isAvailable(r-1,c,visited))stack.add(new int[]{r-1,c,2});
        }
    }

//    다음 이동할 칸이 이동 가능한지 검사
    public static boolean isAvailable(int r, int c, boolean[][] visited){
        if(0 > r || r > R-1 || 0 > c || c > C-1 || visited[r][c]) return false;
        return true;
    }

    public static void bfs(int r, int c, boolean[][] visited){
        ArrayList<int[]> stack = new ArrayList<>();
        if(isAvailable(r,c+1,visited) && map[r][c+1] != '.')stack.add(new int[]{r,c+1,1});
        if(isAvailable(r,c-1,visited) && map[r][c-1] != '.')stack.add(new int[]{r,c-1,0});
        if(isAvailable(r+1,c,visited) && map[r+1][c] != '.')stack.add(new int[]{r+1,c,3});
        if(isAvailable(r-1,c,visited) && map[r-1][c] != '.')stack.add(new int[]{r-1,c,2});
        while(!stack.isEmpty()){
            int[] cur = stack.remove(0);
            move(cur[0], cur[1], cur[2], stack, visited);
        }
    }
}
