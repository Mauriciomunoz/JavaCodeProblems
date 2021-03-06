package EasyProblems.LinkedList;

import Utils.ListNode;

/**
 *
 * LeetCode: https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/553/
 *
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 *
 * Given linked list -- head = [4,5,1,9], which looks like following:
 *
 *
 *    4 -> 5 -> 1 -> 9
 *
 *
 * Example 1:
 * Input: head = [4,5,1,9], node = 5
 * Output: [4,1,9]
 * Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.
 *
 * Example 2:
 * Input: head = [4,5,1,9], node = 1
 * Output: [4,5,9]
 * Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.
 *
 * Note:
 * The linked list will have at least two elements.
 * All of the nodes' values will be unique.
 * The given node will not be the tail and it will always be a valid node of the linked list.
 * Do not return anything from your function.
 *
 *
 * Definition for singly-linked list.
 * public class Utils.ListNode {
 *     int val;
 *     Utils.ListNode next;
 *     Utils.ListNode(int x) { val = x; }
 * }
 *
 */
public class DeleteNode {

    static ListNode head;

    public static void main(String[] args) {

        head = new ListNode(4);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(9);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;

        deleteNode(node2);

    }

    //TC: O(1)
    //SC: O(1)
    public static void deleteNode(ListNode node) {
        ListNode aux = node.next;

        node.val = node.next.val;
        node.next = node.next.next;

        aux = null;
    }

}