package EasyProblems.LinkedList;

import Utils.ListNode;

/**
 *
 * LeetCode: https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/603/
 *
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 *
 * Follow up:
 * Could you do this in one pass?
 *
 * Definition for singly-linked list.
 * public class Utils.ListNode {
 *     int val;
 *     Utils.ListNode next;
 *     Utils.ListNode() {}
 *     Utils.ListNode(int val) { this.val = val; }
 *     Utils.ListNode(int val, Utils.ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class RemoveNthNodeFromEnd {

    static ListNode head;

    public static void main(String[] args) {

        head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;


/*       head = new Utils.ListNode(1);
        Utils.ListNode node2 = new Utils.ListNode(2);
        head.next = node2;
*/
        head = removeNthFromEnd(head, 7);

    }

    //TC: O(N)
    //SC: O(1)
    public static ListNode removeNthFromEnd(ListNode head, int n) {

        if(head == null || head.next == null)
            return null;

        ListNode iterator = head;
        ListNode aux = head;
        int cont = 1;

        while(iterator != null){
            if(cont - n > 1){
                aux = aux.next;
                iterator = iterator.next;
                cont++;
            }else{
                iterator = iterator.next;
                cont++;
            }
        }

        if(cont - n  == 1)
            return head.next;

        aux.next = aux.next.next;
        return head;
    }

}
