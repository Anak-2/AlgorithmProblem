package com.example.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class 불량사용자 {

    public static void main(String[] args) {
        System.out.println(Solution.solution(
                new String[]{"aaaaaaaa", "bbbbbbbb", "cccccccc",
                        "dddddddd", "eeeeeeee", "ffffffff", "gggggggg", "hhhhhhhh"},
                new String[]{"********", "********","********",
                        "********","********","********","********","********"})
        );
    }

    static class Solution {
        static String[] userIds;
        static String[] bannedIds;
        static HashSet<HashSet<String>> result = new HashSet<>(); // 정답

        public static int solution(String[] user_id, String[] banned_id) {
            userIds = user_id;
            bannedIds = banned_id;

            dfs(new HashSet<>(), 0);

            return result.size();
        }

        static void dfs(HashSet<String> set, int depth) {
            if (depth == bannedIds.length) {
                result.add(set);
                return;
            }

            for (int i = 0; i < userIds.length; i++) {
                if (set.contains(userIds[i])) {
                    continue;
                }

                if (check(userIds[i], bannedIds[depth])) {
                    set.add(userIds[i]);
                    dfs(new HashSet<>(set), depth + 1);
                    set.remove(userIds[i]);
                }
            }
        }

        // 문자열 동일한지 비교
        static boolean check(String userId, String bannedId) {
            if (userId.length() != bannedId.length()) {
                return false;
            }

            boolean match = true;
            for (int i = 0; i < userId.length(); i++) {
                if (bannedId.charAt(i) != '*' && userId.charAt(i) != bannedId.charAt(i)) {
                    match = false;
                    break;
                }
            }

            return match;
        }
    }
}
