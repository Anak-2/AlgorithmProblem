import java.util.*;
class Solution {

        int todayInt;
        Map<String, Integer> termsMap = new HashMap<>();

        public int[] solution(String today, String[] terms, String[] privacies) {
            List<Integer> answerList = new LinkedList<>();
            // String today -> int[] today
            todayInt = stringDateToInt(today);

            for(String t : terms){
                String[] tSplit = t.split(" ");
                termsMap.put(tSplit[0], Integer.parseInt(tSplit[1]));
            }

            for(int i = 0; i < privacies.length; i++){
                String[] privacy = privacies[i].split(" ");
                if(checkTermIsPassed(privacy[0], privacy[1])){
                    answerList.add(i+1);
                }
            }
            return answerList.stream().mapToInt(Integer::intValue).toArray();
        }

        /*
        * 유효기간 지났는지 확인하는 함수
        * */
        private boolean checkTermIsPassed(String privacyDate, String term){
            int dateInt = stringDateToInt(privacyDate);
            dateInt += termsMap.get(term) * 28;

            return todayInt >= dateInt;
        }

        private int stringDateToInt(String date){
            int val = 0;
            int[] returnInt = new int[3];

            String[] todayArr = date.split("\\.");
            for(int i = 0; i < todayArr.length; i++){
                returnInt[i] = Integer.parseInt(todayArr[i]);
            }
            val += returnInt[0] * 12 * 28;
            val += returnInt[1] * 28;
            val += returnInt[2];

            return val;
        }
    }