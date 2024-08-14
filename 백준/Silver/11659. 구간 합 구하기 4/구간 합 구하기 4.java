import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }
        int[] parseSum = new int[N];
        parseSum[0] = arr[0];
        for(int i = 1; i < N; i++){
            parseSum[i] += parseSum[i-1] + arr[i];
        }

        for(int i = 0; i < M; i++){
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            if(a != 0){
                System.out.println(parseSum[b] - parseSum[a - 1]);
            }else{
                System.out.println(parseSum[b]);
            }
        }
    }
}
