package linked_list;

public class Delete_the_Middle_Node_of_a_Linked_List_2095 {

    static class Solution {


        public ListNode deleteMiddle(ListNode head) {
            int headLength = 0;

            ListNode dummy = new ListNode(head.val, head.next);

            while (head != null) {
                head = head.next;
                headLength++;
            }

            if (headLength == 1) return null;

            head = dummy;
            int middle = headLength / 2;
            for (int i = 0; i < middle; i++) {
                if (i == (middle - 1)) {
                    head.next = head.next.next;
                } else {
                    head = head.next;
                }
            }

            return dummy;
        }

        public class ListNode {
            int val;
            ListNode next;

            ListNode() {
            }

            ListNode(int val) {
                this.val = val;
            }

            ListNode(int val, ListNode next) {
                this.val = val;
                this.next = next;
            }
        }
    }
}
