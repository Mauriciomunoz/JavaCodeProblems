package LinkedList;

/**
 *
 * CCI: 2.7
 *
 * Given two (singly) linked list, determine if two lists intersect. Return the intersectiong node. Note that the intersection
 * is defined based on reference not value. That is, the kth node on the first linked list is the exact same node (by reference)
 * as the jth node on the second linked list, then they are intersecting.
 *
 * Example:
 *
 * 1 -> 2 -> 3 -> 4
 *                  \
 *                   5 -> 6 -> 7 -> NULL
 *                  /
 *          4 -> 8
 *
 * Node intersection: 5
 *
 * Hints: #20, #45, #55, #65, #76, #93, #111, #120, #129
 */

public class Intersection {

    public static void main(String[] args) {
        ListNode head1;
        ListNode head2;
        ListNode head3;

        int[] list1 = {1,9,1};
        int[] list2 = {1,2,1,3};
        int[] intersection = {3,4};

        head1 = ListNode.createListFromArray(list1);
        head2 = ListNode.createListFromArray(list2);
        head3 = ListNode.createListFromArray(intersection);

        ListNode tail1 = ListNode.getTail(head1);
        tail1.next = head3;

        ListNode tail2 = ListNode.getTail(head2);
        tail2.next = head3;

        ListNode result = searchIntersection(head1, head2);
        System.out.println("DONE");
    }


    //TC: O(N)
    //SC: O(1)
    public static ListNode searchIntersection(ListNode head1, ListNode head2){

        if(head1 == null || head2 == null)
            return null;

        int size1 = 0;
        ListNode itHead1 = head1;

        while(itHead1 != null){
            size1++;
            itHead1 = itHead1.next;
        }

        int size2 = 0;
        ListNode itHead2 = head2;

        while(itHead2 != null){
            size2++;
            itHead2 = itHead2.next;
        }

        int diffSizes = 0;
        if(size1 < size2)
            diffSizes = size2 - size1;
        else
            diffSizes = size1 - size2;

        int counter = 0;
        while(head1 != null && head2 != null){
            if(counter == diffSizes){
                if(head1 == head2){
                    return head1;
                }else{
                    head1 = head1.next;
                    head2 = head2.next;
                }
            }else{
                if(size1 < size2)
                    head2 = head2.next;
                else
                    head1 = head1.next;
                counter++;
            }
        }

        return null;

    }

}
