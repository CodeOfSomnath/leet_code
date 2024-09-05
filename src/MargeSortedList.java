import java.util.ArrayList;
import java.util.Collections;

/**
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 *
 * Example 2:
 *
 * Input: list1 = [], list2 = []
 * Output: []
 *
 * Example 3:
 *
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 *
 *
 *
 * Constraints:
 *
 *     The number of nodes in both lists is in the range [0, 50].
 *     -100 <= Node.val <= 100
 *     Both list1 and list2 are sorted in non-decreasing order.
 */


class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

public class MargeSortedList {
    ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode finalNode = null;
        ListNode tail = null;


        ArrayList<Integer> list = new ArrayList<>();
        
        if (list1 != null) {
            while (list1 != null) {
                list.add(list1.val);
                list1 = list1.next;
            }
        }

        if (list2 != null) {
            while (list2 != null) {
                list.add(list2.val);
                list2 = list2.next;
            }
        }

        Collections.sort(list);
        

        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                tail = new ListNode();
                finalNode = tail;
            }
            tail.val = list.get(i);
            if (i == list.size()-1) {
                continue;
            }
            tail.next = new ListNode();
            tail = tail.next;
        }
//        tail = null;
        return finalNode;

    }

    void insertNode(ListNode first, ListNode last, ListNode middle) {
//        ListNode temp = first.next;
        first.next = middle;
        middle.next = last;
    }

    static ListNode createNode(int[] arr) {
        ListNode list = new ListNode();
        ListNode temp = list;
        for (int i = 0; i < arr.length; i++) {
            list.val = arr[i];
            list.next = new ListNode();
            list = list.next;
        }
        list.next = null;
        return temp;
    }

    static void printNode(ListNode list) {
        while (list != null) {
            System.out.println(list.val);
            list = list.next;
        }
    }

    public static void main(String[] args) {
        MargeSortedList list = new MargeSortedList();

        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode finalNode = list.mergeTwoLists(list1, list2);
        printNode(finalNode);
    }
}
