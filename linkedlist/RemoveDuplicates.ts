

class SinglyLinkedListNode {
    data: number;
    next: SinglyLinkedListNode | null;

    constructor(nodeData: number) {
        this.data = nodeData;
        this.next = null;
    }
};

function removeDuplicates(llist: SinglyLinkedListNode): SinglyLinkedListNode {
    // Write your code here
    let next = llist.next;
    let copy = llist;
    while (llist != null && next != null) {
        if (next.data === llist.data) {
            next = next.next;
            llist.next = next;
            continue;
        } else {
            llist = llist.next;
            next = next.next;
        }
    }
    return copy;
}