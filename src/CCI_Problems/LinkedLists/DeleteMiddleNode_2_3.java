package CCI_Problems.LinkedLists;

import Utils.ListNode;

/**
 *
 * CCI: 2.3
 *
 * Implement an algorithm to delete a node in the middle (i. e., Any node but the first and last node, not necessarily
 * the exact middle) of a singly linked list, given only access to that node.
 *
 * EXAMPLE:
 *
 * input: The node 'c' from the linked list a->b->c->d->e->f
 * output: Nothing to return but the linked list will look like: a->b->d->e->f
 *
 *
 * Hints: #72
 */

public class DeleteMiddleNode_2_3 {

    static ListNode head;

    public static void main(String[] args) {

        head = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(6);
        //Utils.ListNode node7 = new Utils.ListNode(7);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        ListNode node = node4;

        deleteMiddleNode(node);
        System.out.println("DONE");
    }

    //TC: O(1)
    //SC: O(1)
    public static void deleteMiddleNode(ListNode node){
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
