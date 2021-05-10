// https://www.hackerrank.com/challenges/compare-two-linked-lists/problem

public class TwoLinkedList {

    public boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        while (head1 != null && head2 != null) {
            if (head1.data != head2.data)
                return false;
            head1 = head1.next;
            head2 = head2.next;
        }
        return head1 == null && head2 == null ? true : false;
    }

}