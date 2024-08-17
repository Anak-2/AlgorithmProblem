
import java.util.*;

public class Main {

    private static class Element {
        int repeat;
        int len;

        public Element(int repeat, int len){
            this.repeat = repeat;
            this.len = len;
        }

        public int plusLength(){
            return repeat * len;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] charArr = s.toCharArray();

        Stack<Element> e = new Stack<>();
        char prevC = '0';
        for(char c : charArr){
            if(c == '('){
                Element newE = new Element(Character.getNumericValue(prevC),0);
                if(!e.isEmpty()){
                    Element topE = e.peek();
                    topE.len--;
                }
                e.push(newE);
            }else if(c == ')'){
                Element popE = e.pop();
                Element topE = e.peek();
                topE.len += popE.plusLength();
            }else {
                if(e.isEmpty()){
                    Element cur = new Element(1,1);
                    e.push(cur);
                }else{
                    Element topE = e.peek();
                    topE.len++;
                }
            }
            prevC = c;
        }
        System.out.println(e.peek().len);
    }
}
