package gold;

import java.util.*;
import java.io.*;

//암호 만들기
public class No1759 {
    public static int L, C;
    public static char[]inputs;
    public static char[] pwd;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken()); //만들어야하는 암호의 자릿수
        C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        inputs = new char[C]; //입력받은 알파벳을 저장
        pwd = new char[L];

        for (int i = 0; i < C; i++) {
            inputs[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(inputs); //순서대로 만들어야하기 때문에 미리 정렬하기
        combination(0, 0); //조합 시작
    }

    private static void combination(int cnt, int start) {
        if(cnt ==L) {
            if(check(pwd)) { //조합이 완성되면 가능성있는지 확인
                for (char c : pwd) {  //가능성있으면 출력
                    System.out.print(c);
                }
                System.out.println();
            };
            return;
        }

        for (int i = start; i < C; i++) {
            pwd[cnt] = inputs[i];
            combination(cnt+1, i+1);
        }
    }

    private static boolean check(char[] pwd) {
        int j =0; //자음 개수
        int m =0; //모음 개수
        for (int i = 0; i < pwd.length; i++) {
            //모음이면 m에 추가 자음이면 j변수에 추가
            if( pwd[i] =='a' ||pwd[i] =='e'||pwd[i] =='i'||pwd[i] =='o'||pwd[i] =='u') m++;
            else j++;
        }
        if(j >=2 && m>=1) return true; //모음이 1개이상 자음 2개 이상이면 true
        else return false; //아니면 false
    }
}
