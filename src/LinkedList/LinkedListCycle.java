package LinkedList;

/**
 *
 * LeetCode: https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/773/
 * CCI: 2.8
 *
 * Given a linked list, determine if it has a cycle in it.
 *
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 *
 * Example 1:
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 *
 *  3 -> 2 -> 0 -> -4 ¬
 *       ^------------|
 *
 *
 * Example 2:
 * Input: head = [1,2], pos = 0
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 *
 *   1 -> 2 ¬
 *   ^------|
 *
 *
 * Example 3:
 *
 * Input: head = [1], pos = -1
 * Output: false
 * Explanation: There is no cycle in the linked list.
 *
 *   1 -> NULL
 *
 *
 * Follow up:
 * Can you solve it using O(1) (i.e. constant) memory?
 *
 */

public class LinkedListCycle {

    private static ListNode head;

    public static void main(String[] args) {
        head = new ListNode(3);
        ListNode list1node1 = new ListNode(2);
        ListNode list1node2 = new ListNode(0);
        ListNode list1node3 = new ListNode(-4);
        ListNode list1node4 = new ListNode(5);
        ListNode list1node5 = new ListNode(6);
        ListNode list1node6 = new ListNode(8);

        head.next = list1node1;
        list1node1.next = list1node2;
        list1node2.next = list1node3;
        list1node3.next = list1node4;
        list1node4.next = list1node5;
        list1node5.next = list1node6;
        //list1node6.next = list1node6;

        ListNode head2 = new ListNode();

        boolean result = hasCycle(head);
        System.out.println(result);
    }

    //TC: O(N)
    //SC: O(1)
    public static boolean hasCycle(ListNode head) {

        if(head == null || head.next == null)
            return false;

        ListNode dummy = new ListNode(0, null);

        while(head.next != dummy && head.next !=null){
                dummy.next = head.next;
                head.next = dummy;
                head = dummy.next;
                dummy.next = null;
        }

        if(head.next == dummy)
            return true;
        else
            return false;
    }

    //INTERNET SOLUTION USING RUNNER METHOD
    public static boolean hasCycle2(ListNode head) {

        if(head == null || head.next == null){
            return false;
        }
        ListNode slower = head;
        ListNode faster = head.next;

        while(slower != faster){
            if(faster == null || faster.next == null){
                faster = null;
                return false;
            }
            slower = slower.next;
            faster = faster.next.next;

        }


        return true;
    }
}
