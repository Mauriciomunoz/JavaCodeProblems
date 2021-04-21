package CCI_Problems;

import Utils.ListNode;

/**
 * CCI: 3.6 AnimalShelter
 *
 * An animal shelter, which holds only dogs and cats, operates on a strictly "first in, first out" basis. People must
 * adopt either the "oldest" (based on arrival time) of all animals at the shelter, or they can select whether
 * they would prefer a dog or a cat (and will receive the oldest animal of that type). They cannot select which specific
 * animal they would like. Create the data structures to maintain this system and implement operations such as enqueue,
 * dequeueAny, dequeueDog and dequeueCat. You may use the built-in EasyProblems.LinkedList data structure.
 *
 * Hints: #22, #56, #63
 *
 * This problem can be solved using two separated queues (One for cats and one for dogs)
 * This will help to improve when we dequeue cats or dogs but we need to have a timestamp to be able to get any of both.
 *
 */

public class AnimalShelter_3_6 {

    public static void main(String[] args) {

        AnimalQueue myQueue = new AnimalQueue();

        // 1 - cat
        // 2 - dog

        myQueue.enqueue(1); // 1
        myQueue.enqueue(2); // 1 2
        myQueue.enqueue(2); // 1 2 2
        myQueue.enqueue(1); // 1 2 2 1
        myQueue.enqueue(2); // 1 2 2 1 2
        myQueue.enqueue(1); // 1 2 2 1 2 1
        myQueue.enqueue(2); // 1 2 2 1 2 1 2
        myQueue.enqueue(1); // 1 2 2 1 2 1 2 1
        myQueue.enqueue(2); // 1 2 2 1 2 1 2 1 2
        myQueue.enqueue(1); // 1 2 2 1 2 1 2 1 2 1

        myQueue.dequeueAny(); // r1 2 2 1 2 1 2 1 2 1
        myQueue.dequeueAny(); // r1 r2 2 1 2 1 2 1 2 1
        myQueue.dequeueAny(); // r1 r2 r2 1 2 1 2 1 2 1
        //1 2 1 2 1 2 1

        myQueue.dequeueDog(); //1 r2 1 2 1 2 1
        myQueue.dequeueDog(); //1 r2 1 r2 1 2 1
        myQueue.dequeueDog(); //1 r2 1 r2 1 r2 1
        myQueue.dequeueCat(); //r1 r2 1 r2 1 r2 1
        myQueue.dequeueDog(); //No more dogs. No remove. r1 r2 1 r2 1 r2 1
        //1 1 1

        System.out.println("DONE");

    }

    //1 - cat
    //2 - dog
    public static class AnimalQueue{

        ListNode list;

        public AnimalQueue(){

        }

        public void enqueue(int animalId){
            if(list == null) {
                list = new ListNode(animalId);
                return;
            }

            ListNode node = new ListNode(animalId);
            ListNode iterator = list;

            while(iterator.next != null){
                iterator = iterator.next;
            }

            iterator.next = node;
        }

        public int dequeueAny(){
            if(list == null)
                return -1;

            int val = list.val;
            list = list.next;
            return val;

        }

        public int dequeueDog(){
            if(list == null)
                return -1;

            if(list.val == 2) {
                int dog = list.val;
                list = list.next;
                return dog;
            }

            ListNode iteratorAhead = list.next;
            ListNode iteratorBack = list;

            while( iteratorAhead != null && iteratorAhead.val != 2){
                iteratorBack = iteratorAhead;
                iteratorAhead = iteratorAhead.next;
            }

            if(iteratorAhead != null) {
                iteratorBack.next = iteratorAhead.next;
                return iteratorAhead.val;
            }else{
                return -1;
            }
        }

        public int dequeueCat(){
            if(list == null)
                return -1;

            if(list.val == 1) {
                int cat = list.val;
                list = list.next;
                return cat;
            }

            ListNode iteratorAhead = list.next;
            ListNode iteratorBack = list;

            while( iteratorAhead != null && iteratorAhead.val != 1){
                iteratorBack = iteratorAhead;
                iteratorAhead = iteratorAhead.next;
            }

            if(iteratorAhead != null) {
                iteratorBack.next = iteratorAhead.next;
                return iteratorAhead.val;
            }else{
                return -1;
            }
        }

    }

}
