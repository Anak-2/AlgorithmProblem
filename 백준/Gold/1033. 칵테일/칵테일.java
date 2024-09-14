
import java.util.*;

class mat {
    int val;
    ArrayList<Integer> edge;

    mat() {
        this.val = 1;
        this.edge = new ArrayList<Integer>();

    }
}

public class Main {
    static mat[] arr = new mat[11];
    static int vis = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, a, b, p, q, gcdVal, amod, bmod;
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr[i] = new mat();
        }
        for (int i = 0; i < n - 1; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            p = sc.nextInt();
            q = sc.nextInt();
            gcdVal = gcd(p, q);
            amod = arr[b].val * p / gcdVal;
            bmod = arr[a].val * q / gcdVal;
            gcdVal = gcd(amod, bmod);
            // a : b 의 최대공약수를 구하고 연결된 모든 노드 비율 업데이트
            vis = 0;
            update(a, amod / gcdVal);
            update(b, bmod / gcdVal);

            arr[a].edge.add(b);
            arr[b].edge.add(a);
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i].val + " ");
        }
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }

    public static void update(int node, int mod) {
        arr[node].val *= mod;
        vis |= (1 << node);
        for (int e : arr[node].edge) {
            if ((vis & (1 << e)) == 0) {
                update(e, mod);
            }
        }
    }
}
