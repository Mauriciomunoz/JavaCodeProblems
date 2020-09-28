package LinkedList;

import java.util.List;

/**
 *
 * CCI: 2.2
 *
 * Implement an algorithm to find the kth to last element of a singly linked list.
 *
 * Hints: #8, #25, #41, #67, #126
 */

public class ReturnKthToLast {

    static ListNode head;

    public static void main(String[] args) {

        head = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(6);
        //ListNode node7 = new ListNode(7);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        //node6.next = node7;


/*       head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        head.next = node2;
*/
        head = returnkthNode(head, 2 );

    }

    private static ListNode returnkthNode2(ListNode head, int kth, int count) {

        if(head.next == null) {
            return head;
        }

        count++;
        ListNode node = returnkthNode2(head, kth, count);

        if(count == kth ){
            return node;
        }else{
            return null;
        }

    }

    //TC: O(N)
    //SC O(1)
    private static ListNode returnkthNode(ListNode head, int kth) {
        if(head == null || head.next == null)
            return null;

        ListNode iterator = head;
        int cont = 0;

        while(iterator != null){
            iterator = iterator.next;
            cont++;
        }

        if(cont < kth)
            return null;

        int newCont = 0;
        iterator = head;

        while(cont - kth != newCont){
            iterator = iterator.next;
            newCont++;
        }

        return iterator;
    }
}
