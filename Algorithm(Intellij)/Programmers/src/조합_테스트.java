public class 조합_테스트 {

    static boolean[] visited;
    static int cnt;

    public static void main(String[] args) {

        Solution.solution(new int[] {1,2,3,4,5,6});
        System.out.println("total cnt : "+cnt);
    }

    class Solution{
        public static void solution(int[] arr){

            visited = new boolean[arr.length];

            permutation(arr, 0);
        }

        static void permutation(int[] arr, int curIdx){
            if(curIdx == arr.length){
                cnt++;
                int idx = 0;
                for(boolean b : visited){
                    if(b){
                        System.out.print(arr[idx]+" ");
                    }
                    idx++;
                }
                System.out.println("-----------");
                return;
            }

            visited[curIdx] = true;
            permutation(arr, curIdx+1);
            visited[curIdx] = false;
            permutation(arr, curIdx+1);
        }
    }
}
