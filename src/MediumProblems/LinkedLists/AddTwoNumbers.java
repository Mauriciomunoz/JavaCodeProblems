package MediumProblems.LinkedLists;


import Utils.ListNode;

/**
 *
 * LeetCode: https://leetcode.com/explore/interview/card/top-interview-questions-medium/107/linked-list/783/
 * CCI = SumLists 2.5
 *
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 * Input:
 * l1 = 2->4->3
 * l2 = 5->6->4
 * Output: 7->0->8
 * Explanation: 342 + 465 = 807.
 *
 * Example 2:
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 *
 * Example 3:
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 *
 *
 */

public class AddTwoNumbers {

    static ListNode head;

    public static void main(String[] args) {

        //int[] l1 = {1,0,9,1,1};
        int[] l1 = {2,5,3};
        //int[] l1 = {9,9,9,9,9,9,9};
        ListNode headL1 = ListNode.createListFromArray(l1);

        //int[] l2 = {5,6,4};
        int[] l2 = {8,4,3,1,2,1};
        //int[] l2 = {9,9,9,9};
        ListNode headL2 = ListNode.createListFromArray(l2);

        ListNode result;
        result = addTwoNumbers(headL1, headL2);
    }

    static public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode itSum = new ListNode();
        result = itSum;
        int aux = 0;

        while(l1 != null || l2 != null){
            ListNode sum = new ListNode();
            int sumVal = 0;
            if(l1 != null && l2 != null) {
                sumVal = l1.val + l2.val + aux;
                aux = 0;
            } else{
                if(l1 != null){
                    sumVal = l1.val + aux;
                    aux = 0;
                }else{
                    sumVal = l2.val + aux;
                    aux = 0;
                }
            }

            if(sumVal > 9){
                sum.val = sumVal % 10;
                aux = sumVal / 10;
            }else{
                sum.val = sumVal;
            }

            itSum.next = sum;
            itSum = sum;

            if(l1 != null) {
                l1 = l1.next;
            }

            if(l2 != null){
                l2 = l2.next;
            }

        }

        if(aux != 0){
            itSum.next = new ListNode(aux);
        }

        return result.next;
    }

}
