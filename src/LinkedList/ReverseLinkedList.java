package LinkedList;

import java.util.List;

/**
 *
 * LeetCode: https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/560/
 *
 * Reverse a singly linked list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 *
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */


public class ReverseLinkedList {
    static ListNode head;

    public static void main(String[] args) {

        head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;


        ListNode h;
        head = reverseList2(head);

    }


    //TC: O(N)
    //SC: O(N)
    //Recursive mode
    public static ListNode reverseList(ListNode head) {

        if(head == null)
            return null;

        if(head.next == null){
            return head;
        }

        ListNode aux = reverseList(head.next);

        head.next.next = head;
        head.next = null;

        return aux;
    }

    //TC: O(N)
    //SC: O(1)
    //Loop mode
    public static ListNode reverseList2(ListNode head) {
        ListNode iterator = head;
        ListNode aux1 = null;
        ListNode aux2 = null;


        while(iterator != null){
            aux1 = iterator.next;
            iterator.next = aux2;
            aux2 = iterator;
            iterator = aux1;
        }



        return aux2;
    }

}
