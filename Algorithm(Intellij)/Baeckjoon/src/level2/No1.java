package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class No1{
    public static void main(String[] args) {

//       2차원 배열 정렬
        int[][] arr = {{1,4},{11,4},{21,4},{14,4},{11,4}};

        Arrays.sort(arr, new Comparator<>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                System.out.println("o1[0]: "+o1[0]+" o2[0]: "+o2[0]);
                if(o1[0] > o2[0]) return 1;
                else return -1;
            }
        });
        System.out.println(Arrays.deepToString(arr));

//        배열 깊은 복사
        int[] arr2 = {1,2,3,4,5};
        int[] arr3 = arr2.clone();
        arr3[2] = 4;
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));

//        Collections 정렬
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            arrayList.add(arr[i][0]);
        }
        Collections.sort(arrayList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        System.out.println(arrayList);

//        Collections 깊은 복사
        ArrayList<Integer> arrayListCopy = new ArrayList<>(arrayList);
        arrayListCopy.set(3,4);
        System.out.println(arrayList);
        System.out.println(arrayListCopy);
    }
}