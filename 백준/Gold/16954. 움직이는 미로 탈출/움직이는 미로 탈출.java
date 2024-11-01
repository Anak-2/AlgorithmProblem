import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int R = 8, C = 8;
    static char map[][];
    static boolean visited[][];
    static int dx[] = {-1, -1, 0, 1, 1, 1, 0, -1, 0}; // 상하좌우 & 대각선 & 제자리 9방향
    static int dy[] = {0, 1, 1, 1, 0, -1, -1, -1, 0};

    class Node {
        int x, y;
        Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    void moveWall() {
        for (int i=7; i>=0; i--) {
            for (int j=0; j<8; j++) {
                if (map[i][j] == '#') {
                    map[i][j] = '.';
                    if (i != 7) {
                        map[i+1][j] = '#';
                    }
                }
            }
        }
    }

    boolean foundWall() {
        for (int i=0; i<8; i++) {
            for (int j=0; j<8; j++) {
                if (map[i][j] == '#')
                    return true;
            }
        }
        return false;
    }

    void printMap() {
        for (int i=0; i<8; i++) {
            for (int j=0; j<8; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("---------------");
    }

    void BFS() {
        Queue<Node> Q = new LinkedList<>();
        Q.add(new Node(7, 0)); // 시작점 큐에 넣기
        while(!Q.isEmpty()) {
            // ★ 한 턴이 끝날 때마다 방문배열은 초기화한다.벽이 움직여서 새로운 경로가 생길 수 있기 때문
            visited = new boolean[8][8];
            // ★ 현재 큐에 있는 size 만큼만 꺼내서 탐색을 한다.(큐에 있던 경로 탐색완료 = 1초 경과)
            int size = Q.size();
            for (int t=0; t<size; t++) {
                Node now = Q.poll();
                //System.out.println("Queue: poll("+now.x+", "+now.y+") : count = "+count);
                // 그 위치에 벽이 있으면 탐색 패스
                if (map[now.x][now.y] == '#') continue;
                // 맵에 벽이 없으면 종료
                if (!foundWall()) {
                    System.out.println(1);
                    return;
                }
                //도착지 도착하면 종료
                if (now.x == 0 && now.y == 7) {
                    System.out.println(1);
                    return;
                }
                // 9개 방향으로 캐릭터 이동
                for (int i=0; i<9; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];
                    // 가지치기
                    if (nx<0 || nx>=8 || ny<0 || ny>=8) continue; // 맵 범위 벗어나면 패스
                    if (map[nx][ny] == '#') continue; // 벽을 만나면 패스
                    if (visited[nx][ny]) continue; // 방문한 곳이면 패스
                    // 큐에 넣기
                    Q.add(new Node(nx, ny));
                    visited[nx][ny] = true;
                    //System.out.println("Queue: add("+nx+", "+ny+")");
                }
            }
            // 벽을 아래로 이동
            moveWall();
            //printMap();
        }
        System.out.println(0);
    }

    void Solve() {
        visited = new boolean[8][8];
        BFS();
    }

    void inputData() throws Exception {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        map = new char[8][8];
        for (int i=0; i<8; i++) {
            String str = br.readLine();
            for (int j=0; j<8; j++) {
                map[i][j] = str.charAt(j);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Main m = new Main();
        m.inputData(); // 입력 받는 부분
        m.Solve();// 여기서부터 작성
    }
}