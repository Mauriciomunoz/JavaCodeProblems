package LinkedList;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode createListFromArray(int[] array){

        if(array == null || array.length == 0)
            return null;

        ListNode head = new ListNode(array[0]);
        ListNode tail = head;
        for(int i = 1; i < array.length; i++){
            ListNode node = new ListNode(array[i]);
            tail.next = node;
            tail = node;
        }

        return head;
    }

    public static ListNode getTail(ListNode head){
        if(head == null)
            return null;

        while(head.next != null){
            head = head.next;
        }

        return head;
    }



}
