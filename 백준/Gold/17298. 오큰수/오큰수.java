
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static class Element {
        int val;
        int nge;
        int index;

        public Element(int index, int val){
            this.index = index;
            this.val = val;
            this.nge = -1;
        }

        public boolean isGreater(int a){
            return a > this.val;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        // 값과 오큰수를 저정하는 리스트
        Element[] nge = new Element[N];
        // 아직 자신의 오큰수를 몾 찾은 애들
        // 알아야 할 것 -> 지금까지 오큰수를 못 찾은 애들 중에 가장 최신에 들어온 값 (top) 이 가장 작은 값 (왜냐하면 이전 애들의 오큰수가 되지 못했기 때문)
        List<Element> notFoundNgeYet = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            int cur = Integer.parseInt(st.nextToken());
            while (!notFoundNgeYet.isEmpty()) {
                Element e = notFoundNgeYet.get(notFoundNgeYet.size() - 1);
                // 지금까지 오큰수 못 찾은 애들 비교해주기
                if(e.isGreater(cur)){
                    e.nge = cur;
                    notFoundNgeYet.remove(notFoundNgeYet.size() - 1);
                }else{
                    break;
                }
            }
            Element newElement = new Element(i, cur);
            notFoundNgeYet.add(newElement);
            nge[i] = newElement;
        }

        StringBuffer sb = new StringBuffer();
        for(Element e : nge){
            sb.append(e.nge).append(" ");
        }
        System.out.println(sb);
    }
}
