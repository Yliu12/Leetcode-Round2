package linkedlist;

// https://www.hackerrank.com/challenges/find-the-merge-point-of-two-joined-linked-lists/problem
// 平平无奇的小天才。我就是不用fast slow pointer.
public class FindMergePoint {

    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode madeUpNewNode = new SinglyLinkedListNode(Integer.MAX_VALUE);
        SinglyLinkedListNode prev1 = null;
        while (head1 != null) {
            prev1 = head1;
            head1 = head1.next;
            prev1.next = madeUpNewNode;
        }

        SinglyLinkedListNode prev2 = null;
        while (head2 != null) {
            if(head2 == madeUpNewNode){
                return prev2.data;
            }
            prev2 = head2;
            head2 = head2.next;
        }

        return 0;
    }
}