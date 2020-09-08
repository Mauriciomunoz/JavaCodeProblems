package LinkedList;

import java.util.Stack;

/**
 *
 * LeetCode: https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/772/
 *
 *
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Example 1:
 * Input: 1->2
 * Output: false
 *
 * Example 2:
 * Input: 1->2->2->1
 * Output: true
 *
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 *
 */

public class PalindromeLinkedList {

    private static ListNode head;

    public static void main(String[] args) {
        head = new ListNode(1);
        ListNode list1node1 = new ListNode(2);
        ListNode list1node2 = new ListNode(3);
        ListNode list1node3 = new ListNode(3);
        ListNode list1node4 = new ListNode(1);

        head.next = list1node1;
        list1node1.next = list1node2;
        list1node2.next = list1node3;
        list1node3.next = list1node4;

        ListNode head2 = new ListNode();

        boolean result = isPalindrome(head2);
        System.out.println(result);
    }


    //TC: O(N)
    //SC: O(1)
    //Can be improved using the Runner technique.
    public static boolean isPalindrome(ListNode head) {

        if(head == null)
            return true;

        ListNode headAux = head;
        ListNode tail = head.next;

        while(head.next != null){
            if(tail.next == null){
                if(head.val != tail.val) {
                    return false;
                }else{
                    head = head.next;
                    headAux.next = tail.next;
                    tail = head.next;
                    headAux = head;
                }
            }else{
                headAux = headAux.next;
                tail = tail.next;
            }

        }

        return true;
    }
}
