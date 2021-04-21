package CCI_Problems.LinkedLists;

import Utils.ListNode;

import java.util.HashMap;

/**
 *
 * CCI: 2.1
 *
 * Write code to remove the duplicates from an unsorted linked list.
 *
 * Follow up:
 * How would you solve this problem if a temporary buffer is not allowed?
 *
 * Hints: #9, #40
 *
 */

public class RemoveDups_2_1 {

    private static ListNode head;

    public static void main(String[] args) {
        head = new ListNode(1);
        ListNode list1node1 = new ListNode(2);
        ListNode list1node2 = new ListNode(4);
        ListNode list1node3 = new ListNode(2);
        ListNode list1node4 = new ListNode(1);
        ListNode list1node5 = new ListNode(6);

        head.next = list1node1;
        list1node1.next = list1node2;
        list1node2.next = list1node3;
        list1node3.next = list1node4;
        list1node4.next = list1node5;
        removeDups2(head);

    }

    //TC: O(N)
    //SC: O(N)
    public static ListNode removeDups(ListNode head){

        if(head == null)
            return null;

        if(head.next == null)
            return head;

        HashMap<Integer, Integer> hm = new HashMap<>();

        ListNode previous = null;
        ListNode next = head;


        while(next != null){
            if(hm.containsKey(next.val)){
                previous.next = next.next;
                next.next = null;
                next = previous.next;
            }else{
                hm.put(next.val, 1);
                previous = next;
                next = next.next;
            }
        }

        return head;
    }

    //TC: O(N^2)
    //SC: O(1)
    public static ListNode removeDups2(ListNode head){

        if(head == null)
            return null;

        if(head.next == null)
            return head;



        ListNode previous = head;// new Utils.ListNode(head.val, head.next);
        ListNode next = previous.next;
        ListNode nextAux = null;

        while(previous != null){
            while(next != null){
                if(previous.val != next.val){
                    nextAux = next;
                    if(nextAux != null)
                        next = next.next;
                }else{
                    nextAux.next = next.next;
                    next.next = null;
                    if(nextAux != null)
                        next = nextAux.next;
                }
            }
            previous = previous.next;
            if(previous != null)
                next = previous.next;
        }

        return head;
    }

}
