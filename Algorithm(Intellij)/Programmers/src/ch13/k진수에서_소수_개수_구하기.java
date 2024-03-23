package ch13;

public class k진수에서_소수_개수_구하기 {

    public static void main(String[] args) {
        int answer = Solution.solution(
                1000000,10
        );
        System.out.println(answer);
    }

    class Solution {
        public static int solution(int n, int k) {
            int answer = 0;

            // k진수로 변환
            String baseNum = convertToBase(n,k);

            // 0을 기준으로 나누기
            String[] nums = baseNum.split("0");

            for(String s : nums){
                // 빈 문자열 처리
                if(s.equals("")) continue;

                // 소수인지 검사
                if(isPrime(Long.parseLong(s))){
                    answer++;
                }
            }

            return answer;
        }

        public static String convertToBase(long n, int k) {
            StringBuilder result = new StringBuilder();

            // 10진수를 k진수로 변환
            while (n > 0) {
                long remainder = n % k;
                result.insert(0, remainder);
                n /= k;
            }

            return result.toString();
        }

        public static boolean isPrime(long n) {
            if(n == 1) return false;

            // 에라토스테네스의 체를 안 쓰니 시간 초과
            for(long i = 2; i*i <= n; i++){
                if(n % i == 0){
                    return false;
                }
            }
            return true;
        }
    }
}
