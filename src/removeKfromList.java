public class removeKfromList {

    /**
     *
     * Note: Try to solve this task in O(n) time using O(1) additional space, where n is the number of elements
     * in the list, since this is what you'll be asked to do during an interview.
     *
     * Given a singly linked list of integers l and an integer k, remove all elements from list l that have a value equal to k.
     *
     */

    public static void main(String[] args) {
        ListNode<Integer> l = new ListNode(3);
        ListNode<Integer> l2 = new ListNode(1);
        ListNode<Integer> l3 = new ListNode(2);
        ListNode<Integer> l4 = new ListNode(3);
        ListNode<Integer> l5 = new ListNode(4);
        ListNode<Integer> l6 = new ListNode(5);
        l.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        ListNode<Integer> ll = new ListNode(1000);
        ListNode<Integer> ll2 = new ListNode(1000);
        ll.next = ll2;

        removeKFromList(ll, 1000);
        System.out.println("DONE");

    }


    static ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {
        ListNode<Integer> aux1 = l;


        /*
            3 - 1 - 2 - 3 - 4 - 5

            header - 3 - 1 - 2 - 3 - 4 - 5

         */

        while(l.value == k && l != null){
            l = l.next;
            if (l == null)
                break;
        }

        while(aux1 != null && aux1.next != null){

            if(aux1.value == k){
                aux1.value = aux1.next.value;
                aux1.next = aux1.next.next;
            }else{
                aux1 = aux1.next;
            }
        }

        ListNode<Integer> auxHeader = new ListNode<>(0);
        auxHeader.next = l;
        aux1 = l;

        while(aux1 != null){
            if(aux1.value == k){

            }
        }

        if(aux1 == null)
            l = aux1;
        else
            if(aux1.value == k)
                aux1 = null;

        return l;
    }

// Singly-linked lists are already defined with this interface:
    static class ListNode<T> {
        ListNode(T x) {
            value = x;
        }
        T value;
        ListNode<T> next;
    }

}
