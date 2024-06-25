public class 조합_테스트{

    static boolean[] visited;
    static int cnt;

    public static void main(String[] args) {

        Solution.solution(new int[] {1,2,3,4,5,6});
        System.out.println("total cnt : "+cnt);
    }

    class Solution{
        public static void solution(int[] arr){

            visited = new boolean[arr.length];

            // 6 P 3 구하기 (6개 중에 순서를 포함하여 3개 뽑기)
            permutation(arr, 0, 3);
        }

        static void permutation(int[] arr, int curIdx, int max){

        }
    }
}
