
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static class Element {
        int index;
        int value;

        public Element(final int index, final int value) {
            this.index = index;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        LinkedList<Element> dq = new LinkedList<>();

        for(int i = 0; i < N; i++){
            int cur = Integer.parseInt(st.nextToken());

            while(!dq.isEmpty() && dq.getLast().value >= cur){
                dq.removeLast();
            }
            dq.addLast(new Element(i,cur));
            if(dq.getFirst().index <= i-L){
                dq.removeFirst();
            }
            sb.append(dq.getFirst().value).append(" ");
        }
        System.out.println(sb);
    }
}
