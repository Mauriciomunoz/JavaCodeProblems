package LinkedList;

import java.util.List;

/**
 *
 * CCI: 2.5
 *
 * You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored
 * in reverse order, such that the 1's digit is at the head of the list. Write a function to adds the two numbers and
 * returns the sum as a linked list.
 *
 * EXAMPLE:
 *
 * input: (7 -> 1 -> 6) + (5 -> 9 -> 2). That is, 617 + 295
 * output: (2 -> 1 -> 9). That is, 912
 *
 * FOLLOW UP:
 * Suppose the digits are store in forward order. Repeat the above problem.
 *
 * input: (6 -> 1 -> 7) + (2 -> 9 -> 5). That is, 617 + 295
 * output: (9 -> 1 -> 2). That is, 912
 *
 * Hints: #7, #30, #71, #95, #109
 */

public class SumLists {



    public static void main(String[] args) {
        ListNode head;
        ListNode head2;

        int[] list1 = {9,9,0};
        int[] list2 = {1,0};

        head = ListNode.createListFromArray(list1);
        head2 = ListNode.createListFromArray(list2);

        //ListNode result = sumTwoList(head, head2);
        ListNode result = sumTwoListForwardOrder2(head,head2);
        System.out.println("DONE");
    }

    //TC: O(N)
    //SC: O(N)
    //Can remove aux and use the heads as iterators for each list.
    public static ListNode sumTwoList(ListNode head1, ListNode head2){

        if(head1 == null && head2 != null)
            return head2;

        if(head1 != null && head2 == null)
            return head1;

        ListNode aux1 = head1;
        ListNode aux2 = head2;

        int sumValue = 0;
        int extra = 0;

        ListNode resultHead = new ListNode();
        ListNode resultTail = resultHead;

        while(aux1 != null || aux2 != null){
            ListNode result = new ListNode();
            if(aux1 != null && aux2 != null){
                sumValue = (aux1.val + aux2.val + extra) % 10;
                //sumValue = sumValue + extra;
                extra = (aux1.val + aux2.val + extra) / 10;
            }else{
                if(aux1 != null){
                    sumValue = aux1.val + extra;

                }else{
                    sumValue = aux2.val + extra;
                }

                if(sumValue > 9){
                    extra = sumValue / 10;
                    sumValue = sumValue % 10;
                }
            }

            result.val = sumValue;

            resultTail.next = result;
            resultTail = result;

            if(aux1 != null)
                aux1 = aux1.next;

            if(aux2 != null)
                aux2 = aux2.next;
        }
        if(extra > 0) {
            ListNode newResult = new ListNode(extra);
            resultTail.next = newResult;
            resultTail = newResult;
        }

        return resultHead.next;
    }

    /* FOLLOW UP:
    * Suppose the digits are store in forward order. Repeat the above problem.
    *
    * input: (6 -> 1 -> 7) + (2 -> 9 -> 5). That is, 617 + 295
    * output: (9 -> 1 -> 2). That is, 912
    */
    //A solution could check the size of the lists and add 0's to match the size.
    //Then we can do it recursively
    //This will create a solution 0(N)
    private static ListNode sumTwoListForwardOrder2(ListNode head1, ListNode head2) {

        //First I will reverse the list. Instead 617 I will use 7 1 6
        //I can use the first algorithm after
        ListNode headReversed1 = ReverseLinkedList.reverseList2(head1);
        ListNode headReversed2 =  ReverseLinkedList.reverseList2(head2);
        ListNode resultSum = sumTwoList(headReversed1, headReversed2);
        ListNode result = ReverseLinkedList.reverseList2(resultSum);
        return result;

    }



}
