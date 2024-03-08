package level2;

import java.util.LinkedList;

public class No3 {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        solution2.solution(new int[] {3, 2, 7, 2}, new int[] {4, 6, 5, 1});
    }
}
class Solution2 {
    static long total = 0;
    static int cnt = 0;

    public int solution(int[] queue1, int[] queue2) {
        int answer = -2;
        LinkedList<Integer> list1 = new LinkedList<>();
        long sum1 = 0;
        for(int i = 0; i < queue1.length; i++){
            list1.add(queue1[i]);
            sum1 += queue1[i];
        }

        long sum2 = 0;
        LinkedList<Integer> list2 = new LinkedList<>();
        for(int i = 0; i < queue2.length; i++){
            list2.add(queue2[i]);
            sum2 += queue2[i];
        }

        MyList myList1 = new MyList(list1, sum1);
        MyList myList2 = new MyList(list2, sum2);
        this.total = sum1 + sum2;

        bfs(myList1, myList2, 1);
        return answer;
    }

    public void bfs(MyList myList1, MyList myList2, int cnt){
        MyList myList3 = new MyList(myList1);
        MyList myList4 = new MyList(myList2);

        // 위에서 pop
        if(!myList3.list.isEmpty()){
            int r = myList3.myPop();
            myList4.myInsert(r);
            if(myList3.sum == total / 2){
                if(this.cnt > cnt) this.cnt = cnt;
            }else{
                bfs(myList3, myList4, cnt+1);
            }
        }

        // 아래서 pop
        if(!myList2.list.isEmpty()){
            int r = myList2.myPop();
            myList1.myInsert(r);
            if(myList1.sum == total / 2){
                if(this.cnt > cnt) this.cnt = cnt;
            }else{
                bfs(myList1, myList2, cnt+1);
            }
        }
    }
}

class MyList{
    public LinkedList<Integer> list;
    public long sum;

    public MyList(LinkedList<Integer> list, long sum){
        this.list = list;
        this.sum = sum;
    }

    public MyList(MyList myList){
        LinkedList<Integer> cloneList = new LinkedList<>();
        for(int i = 0; i < myList.list.size(); i++){
            cloneList.add(myList.list.get(i));
        }
        this.list = cloneList;
        this.sum = myList.sum;
    }

    public int myPop(){
        int r = list.pop();
        sum -= r;
        return r;
    }

    public void myInsert(int element){
        list.add(element);
        sum += element;
    }

}