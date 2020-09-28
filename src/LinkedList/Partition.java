package LinkedList;

import java.util.List;

/**
 *
 * CCI: 2.4
 *
 * Write code to partition a linked list around a value x, such that all nodes less than x come before
 * all nodes greater than or equal to x. If x is contained within the list, the values of x only need to be after the
 * elements less than x (see below) the partition x can appear anywhere in the 'right partition'; it doesn't need to
 * appear between the left and right partitions.
 *
 * EXAMPLE:
 *
 * input: 3->5->8->5->10->2->1 [partition = 5]
 * output: 3->1->2->10->5->5->8
 *
 *
 * Hints: #3, #24
 */

public class Partition {
    static ListNode head;

    public static void main(String[] args) {

        head = new ListNode(3);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(8);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(10);
        ListNode node6 = new ListNode(2);
        ListNode node7 = new ListNode(1);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        partitionList(head, 10);
        System.out.println("DONE");
    }

    //TC: O(N)
    //SC: O(N)
    private static void partitionList(ListNode head, int partition){

        if(head == null)
            return;

        ListNode leftHead = null;
        ListNode leftTail = null;

        ListNode rightHead = null;
        ListNode rightTail = null;

        while(head != null){
            if(head.val < partition){
                if(leftHead == null) {
                    leftHead = new ListNode(head.val, head.next);
                    leftTail = leftHead;
                }else{
                    leftTail.next = new ListNode(head.val, head.next);
                    leftTail = leftTail.next;
                }

            }else{
                if(rightHead == null) {
                    ListNode aux = new ListNode(head.val, head.next);
                    rightHead = aux;
                    rightTail = aux;
                }else{
                    ListNode aux = new ListNode(head.val, head.next);
                    rightTail.next = aux;
                    rightTail = aux;
                }
            }
            head = head.next;
        }

        rightTail.next = null;
        leftTail.next = rightHead;
        System.out.println("DONE");

    }

}
