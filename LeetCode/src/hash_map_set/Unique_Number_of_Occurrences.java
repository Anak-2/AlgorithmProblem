package hash_map_set;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Unique_Number_of_Occurrences {

    class Solution {
        public boolean uniqueOccurrences(int[] arr) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            }

            Set<Integer> eachOccurrences = new HashSet<>();
            for(int value : map.values()) {
                if(eachOccurrences.contains(value)) {
                    return false;
                }
                eachOccurrences.add(value);
            }

            return true;
        }
    }
}
