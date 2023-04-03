package gold;

import java.util.*;

// 교환, 다시 풀어보기
// 이 문제 답을 보니 시간초과가 날 것 같았지만 숫자 최대 크기가 작기 때문에
// 시간 복잡도는 크지만 N이 작기 때문에 괜찮은가보다
public class No1039 {
    static boolean [][] visited;
    static int len = 0;
    static int ans = -1;

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        len = String.valueOf(N).toCharArray().length;
        int K = sc.nextInt();
//        N은 100만보다 작거나 같기 때문에 방문표시 할 정도의 메모리 사용 가능
        visited = new boolean[1000001][K+1];
        ArrayList<int[]> stack = new ArrayList<>();
//        현재 살펴볼 숫자, 몇 번 바꿨는지 체크
        stack.add(new int[]{N,0});
        visited[N][0] = true;
        while(!stack.isEmpty()){
            int[] entry = stack.remove(0);
            char[] num = String.valueOf(entry[0]).toCharArray();
            for(int i = 0; i < len-1; i++){
                for(int j = i+1; j < len; j++){
                    if(i == 0 && num[j] == '0') continue;
                    char[] numCopy = num.clone();
                    char temp = numCopy[i];
                    numCopy[i] = numCopy[j];
                    numCopy[j] = temp;
                    int numInt = Integer.parseInt(String.valueOf(numCopy));
                    if(visited[numInt][entry[1]+1]) continue;
//                    System.out.println(numInt);

                    if(entry[1] == K-1){
                        ans = Math.max(ans, numInt);
                        continue;
                    }
                    stack.add(new int[]{numInt, entry[1]+1});
                    visited[numInt][entry[1]+1] = true;

                }
            }
        }
        System.out.println(ans);
    }
}
