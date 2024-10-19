public class Solution {
    public String solution(String phone_number) {
        // 정규표현식을 사용하여 뒷 4자리를 제외한 모든 숫자를 *로 대체
        return phone_number.replaceAll(".(?=.{4})", "*");
    }
}