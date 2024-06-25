package algorithm.sort;

import java.util.*;

public class 정렬_연습 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 6, 2, 9};
        Integer[] array = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        sortArray(array);
        System.out.println(Arrays.toString(array));
        sortArrayReverse(array);
        System.out.println(Arrays.toString(array));

        List<Integer> list = new ArrayList<>(Arrays.stream(arr).boxed().toList());
        sortList(list);
        printList(list);
        sortListReverse(list);
        printList(list);
    }

    // Array 정렬
    public static void sortArray(Integer[] arr) {
        Arrays.sort(arr);
    }

    // Array 정렬 역순
    public static void sortArrayReverse(Integer[] arr) {
        Arrays.sort(arr, Collections.reverseOrder());
    }

    // List 정렬
    public static void sortList(List<Integer> list) {
        Collections.sort(list);
    }

    // List 정렬 역순
    public static void sortListReverse(List<Integer> list) {
        list.sort(Collections.reverseOrder());
    }

    // Map 정렬
    public static <T extends Comparable<? super T>, V> List<T> sortMap(Map<T, V> map){
        List<T> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);
        return keySet;
    }
    // 객체 정렬

    public static <T> void printList(List<? super T> list){
        for(Object obj : list){
            System.out.print(obj+" ");
        }
        System.out.println();
    }
}
