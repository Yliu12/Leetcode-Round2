package linkedlist;

// https://www.hackerrank.com/challenges/detect-whether-a-linked-list-contains-a-cycle
/*
fast and slow pointer would eventulaly meet. 
*/
public class CycleDetection {

    static boolean hasCycle(SinglyLinkedListNode head) {
        SinglyLinkedListNode madeUpNewNode = new SinglyLinkedListNode(Integer.MAX_VALUE);
        SinglyLinkedListNode prev = null;
        while (head != null) {
            if(head == madeUpNewNode){
                return true;
            }
            prev = head;
            head = head.next;
            prev.next = madeUpNewNode;
        }
        return false;
    }
}