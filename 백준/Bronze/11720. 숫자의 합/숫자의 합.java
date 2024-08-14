import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int answer = 0;

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        String sNum = sc.next();
        for(char c : sNum.toCharArray()){
            int v = Character.digit(c,10);
            answer += v;
        }

        System.out.println(answer);
    }
}
