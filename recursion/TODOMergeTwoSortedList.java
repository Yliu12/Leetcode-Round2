// TODO recursion

public class TODOMergeTwoSortedList {
    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode h1, SinglyLinkedListNode h2) {

        if (h1 == null)
            return h2;
        if (h2 == null)
            return h1;

        SinglyLinkedListNode resulth = null;
        if (h1.data < h2.data) {
            resulth = h1;
            h1 = h1.next;
        } else {
            resulth = h2;
            h2 = h2.next;
        }
        SinglyLinkedListNode resultHead2 = resulth;

        while (h1 != null && h2 != null) {
            if (h1.data < h2.data) {
                resulth.next = h1;
                h1 = h1.next;
            } else {
                resulth.next = h2;
                h2 = h2.next;
            }
            resulth = resulth.next;
        }
        resulth.next = h1 == null ? h2 : h1;
        return resultHead2;
    }

    // static SinglyLinkedListNode popSmaller(SinglyLinkedListNode h1,
    // SinglyLinkedListNode h2) {
    // SinglyLinkedListNode resulth = null;

    // if (h1.data < h2.data) {
    // resulth = h1;
    // h1 = h1.next;
    // } else {
    // resulth = h2;
    // h2 = h2.next;
    // }

    // return resulth;
    // }
    public static void main(String[] args) {
        SinglyLinkedListNode h1 = new SinglyLinkedListNode(1);
        h1.next = new SinglyLinkedListNode(3);
        SinglyLinkedListNode h2 = new SinglyLinkedListNode(2);
        h2.next = new SinglyLinkedListNode(4);
        h2.next.next = new SinglyLinkedListNode(5);
        MergeTwoSortedList.mergeLists(h1, h2);
    }
}
