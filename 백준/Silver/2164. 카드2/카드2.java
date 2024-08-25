
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        LinkedList<Integer> list = new LinkedList<>();

        for(int i = 1; i <= N; i++){
            list.addFirst(i);
        }
        
        while(list.size() != 1){
            list.removeLast();
            int next = list.removeLast();
            list.addFirst(next);
        }

        System.out.println(list.get(0));
    }
}
