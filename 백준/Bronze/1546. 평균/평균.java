import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int maxScore = 0;
        double sum = 0;
        List<Integer> scores = new ArrayList<>();
        for(int i = 0; i < N; i++){
            int score = sc.nextInt();
            maxScore = Math.max(maxScore, score);
            scores.add(score);
        }

        for(Integer score : scores){
            sum += (double) score;
        }
        double avg = sum / maxScore * 100 / N;
        System.out.println(avg);
    }
}
