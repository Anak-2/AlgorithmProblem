package ch11;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 호텔_방_배정 {

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                        Solution.solution(10, new long[]{1,3,4,1,3,1})
                )
        );
    }
    //문제 아이디어: 방을 배정해준 뒤, 배정한 방의 가장 가까운 부모를 찾아서 연결
    class Solution {
        static Map<Long, Long> map = new HashMap<>();

        public static long[] solution(long k, long[] room_number) {
            int n = room_number.length;
            long[] answer = new long[n];

            for (int i = 0; i < n; i++) {
                answer[i] = findEmptyRoom(room_number[i]);
            }

            return answer;
        }

        static long findEmptyRoom(long room) {
            // 배정한 적이 없는 방 번호면, 다음 방 번호를 연결하도록 해놓고 이번 방 번호 반환
            if (!map.containsKey(room)) {
                map.put(room, room + 1);
                return room;
            }

            // 배정했던 방의 대체 번호 받고
            long nextRoom = map.get(room);
            // 다음 방 번호가 비어있는지 확인 (재귀로 반복)
            long emptyRoom = findEmptyRoom(nextRoom);
            // 배정했던 방의 대체 번호를 갱신
            map.put(room, emptyRoom);
            return emptyRoom;
        }
    }
}
