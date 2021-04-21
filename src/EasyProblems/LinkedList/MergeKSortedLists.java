package EasyProblems.LinkedList;

import Utils.ListNode;

import java.util.PriorityQueue;

/**
 *
 * LeetCode: https://leetcode.com/problems/merge-k-sorted-lists/
 *
 *
 * Given an array of linked-lists lists, each linked list is sorted in ascending order.
 * Merge all the linked-lists into one sort linked-list and return it.
 *
 *
 * Example 1:
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 *
 *
 * Example 2:
 * Input: lists = []
 * Output: []
 *
 *
 * Example 3:
 * Input: lists = [[]]
 * Output: []
 *
 *
 * Constraints:
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] is sorted in ascending order.
 * The sum of lists[i].length won't exceed 10^4.
 *
 */

public class MergeKSortedLists {

    static ListNode head;

    public static void main(String[] args) {
        head = new ListNode(1);
        ListNode list1node1 = new ListNode(4);
        ListNode list1node2 = new ListNode(5);

        ListNode head2 = new ListNode(1);
        ListNode list2node1 = new ListNode(3);
        ListNode list2node2 = new ListNode(4);

        ListNode head3 = new ListNode(-2);
        ListNode list3node1 = new ListNode(6);

        head.next = list1node1;
        list1node1.next = list1node2;

        head2.next = list2node1;
        list2node1.next = list2node2;

        head3.next = list3node1;

        ListNode head4 = new ListNode(2);
        ListNode head5 = new ListNode(-1);


        ListNode[] nodes = new ListNode[3];

        nodes[0] = head;
        nodes[1] = head2;
        nodes[2] = head3;

/*
        nodes[0] = head4;
        nodes[2] = head5;
*/
        ListNode result = mergeKLists(nodes);
    }

    public static ListNode mergeKLists2(ListNode[] lists) {
        ListNode result = null;

        if(lists == null || lists.length == 0)
            return result;

        if(lists.length == 1)
            return lists[0];


        int i = 0;
        for(; i < lists.length; i++) {
            if(lists[i] != null){
                result = lists[i];
                break;
            }
        }

        if(result == null)
            return null;

        for(int j = i + 1; j < lists.length; j++){
            if(lists[j] != null) {
                result = mergeTwoLists(result, lists[j]);
            }
        }

        return result;
    }

    //INTERNET SOLUTION
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists==null || lists.length==0) return null;

        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.length, (a, b)-> a.val-b.val);

        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;

        for (ListNode node:lists)
            if (node!=null)
                queue.add(node);

        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;

            if (tail.next!=null)
                queue.add(tail.next);
        }
        return dummy.next;
    }

    //TC: O(N)
    //SC: O(1)
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1 == null && l2 == null)
            return null;

        if(l1 == null)
            return l2;

        if(l2 == null)
            return l1;

        ListNode iterator = new ListNode();
        ListNode iterator2 = new ListNode();
        boolean firstmove = true;

        iterator = l1;
        iterator2 = l2;


        while(iterator != null && iterator2 != null) {

            if(iterator.val >= iterator2.val) {
                if(iterator2.next != null && iterator.val > iterator2.next.val) {
                }else{
                    ListNode temp = new ListNode(iterator.val, iterator.next);
                    temp.next = iterator2.next;
                    iterator2.next = temp;
                    iterator = iterator.next;
                }
                iterator2 = iterator2.next;
            }else {
                ListNode temp = new ListNode(iterator.val, iterator.next);
                temp.next = iterator2;
                iterator2 = temp;
                iterator = iterator.next;

                if(firstmove == true){
                    l2 = iterator2;
                }
                firstmove = false;
            }
        }

        return l2;
    }
}
