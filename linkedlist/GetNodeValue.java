public class GetNodeValue {
    public static int getNode(SinglyLinkedListNode head, int positionFromTail) {
        SinglyLinkedListNode copyHead = head;
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }

        int index = length - positionFromTail - 1;
        while (index != 0) {
            index--;
            copyHead = copyHead.next;
        }
        return copyHead.data;
    }

}
