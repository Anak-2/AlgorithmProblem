

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static Deque<Integer> deque = new LinkedList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("push")) {
                int e = Integer.parseInt(st.nextToken());
                executePush(e);
            }else {
                executeStack(command);
            }
        }
    }

    private static void executeStack(String command) {
        switch (command) {
            case "pop":
                if(deque.isEmpty()) {
                    System.out.println(-1);
                    return;
                }
                int e = deque.removeLast();
                System.out.println(e);
                return;
            case "size":
                System.out.println(deque.size());
                return;
            case "empty":
                if(deque.isEmpty()) {
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
                return;
            case "top":
                if(deque.isEmpty()){
                    System.out.println(-1);
                    return;
                }
                System.out.println(deque.getLast());
        }
    }

    private static void executePush(int e) {
        deque.addLast(e);
    }
}
