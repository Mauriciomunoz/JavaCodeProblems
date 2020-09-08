package LinkedList;

import java.util.List;

/**
 *
 * LeetCode: https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/771/
 *
 * Merge two sorted linked lists and return it as a new sorted list. The new list should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 *
 *
 */

public class MergeTwoSortedLists {

    static ListNode head;

    public static void main(String[] args) {
        head = new ListNode(-9);
        ListNode list1node1 = new ListNode(3);
        ListNode list1node2 = new ListNode(4);

        ListNode head2 = new ListNode(5);
        ListNode list2node1 = new ListNode(7);
        ListNode list2node2 = new ListNode(4);

        head.next = list1node1;
       //list1node1.next = list1node2;

       head2.next = list2node1;
       //list2node1.next = list2node2;


        ReverseLinkedList.ListNode h;
        mergeTwoLists(head, head2);
    }

    //TC: O(N)
    //SC: O(1)
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        //Input: 2->2->4, 1->3->4
        //Output: 1->2->2->3->4->4

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


    //INTERNET SOLUTION
    public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1), cur = dummy;

        while(l1 != null && l2 != null) {
            if(l1.val > l2.val) {
                cur.next = l2;
                l2 = l2.next;
            }
            else {
                cur.next = l1;
                l1 = l1.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;

        return dummy.next;
    }

    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {

        //Input: 2->2->4, 1->3->4
        //Output: 1->2->2->3->4->4

        if(l1 == null && l2 == null)
            return null;

        if(l1 == null)
            return l2;

        if(l2 == null)
            return l1;

        ListNode iterator = l1;
        ListNode iterator2 = l2;
        ListNode aux = new ListNode(iterator2.next.val, iterator2.next.next);



        while(iterator2 != null){

            if(iterator2.next != null)
                aux = new ListNode(iterator2.next.val, iterator2.next.next);
            else
                aux = null;

            if (aux != null) {
               if (aux.val >= iterator.val) {
                   if(iterator2.val > iterator.val){
                       iterator.next = iterator2;
                   }else {
                       iterator2.next = iterator;
                       if (iterator.next != null)
                           iterator = iterator.next;
                   }
                }
            }else{
                if (iterator2.val >= iterator.val) {
                    iterator.next = iterator2;
                }else{
                    iterator2.next = iterator;
                }
            }
            iterator2 = aux;
        }

        if(l1.val > l2.val) {
            return l2;
        }
        else{
            return l1;
        }
    }

}
