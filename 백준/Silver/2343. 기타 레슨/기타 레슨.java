
import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] intArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 정수 배열 크기
        N = Integer.parseInt(st.nextToken());
        int blueRayNum = Integer.parseInt(st.nextToken());
        // 정수 배열
        intArr = new int[N];

        st = new StringTokenizer(br.readLine());
        int maxValue = 0;
        int sum = 0;

        for (int i = 0; i < N; i++) {
            intArr[i] = Integer.parseInt(st.nextToken());
            maxValue = Math.max(maxValue, intArr[i]);
            sum += intArr[i];
        }

        int best = binSearch(maxValue, sum, blueRayNum);
        System.out.println(best);
    }

    // 블루레이 크기에 대해 이진 탐색
    private static int binSearch(int min, int max, int blueRayNum) {
        int mid;

        while (min <= max) {
            mid = (min + max) / 2;
            if (blueRayCount(mid) <= blueRayNum) {
                max = mid - 1;
            }
            else {
                min = mid + 1;
            }
        }
        return min;
    }

    private static int blueRayCount(int blueRaySize) {
        int sum = 0;
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            if (sum + intArr[i] > blueRaySize) {
               cnt++;
               sum = 0;
            }
            sum += intArr[i];
        }

        if(sum > 0) cnt++;
        return cnt;
    }
}
