https://www.hackerrank.com/challenges/insert-a-node-into-a-sorted-doubly-linked-list/problem

class DoublyLinkedListNode {
    data: number;
    next: DoublyLinkedListNode | null;
    prev: DoublyLinkedListNode | null;

    constructor(nodeData: number) {
        this.data = nodeData;
        this.next = null;
        this.prev = null;
    }
};

function sortedInsert(llist: DoublyLinkedListNode, data: number): DoublyLinkedListNode {
    // Write your code here
    if (llist.data > data) {
        const inserted = new DoublyLinkedListNode(data);
        inserted.next = llist;
        llist.prev = inserted;
        return inserted;
    }
    const copy = llist;
    while (llist.next != null && llist.next.data < data) {
        llist = llist.next;
    }

    const next = llist.next;
    const prev = llist;

    const inserted = new DoublyLinkedListNode(data);
    inserted.next = next;
    inserted.prev = prev;
    if (prev) prev.next = inserted
    if (next) next.prev = inserted;
    return copy;
}

export { DoublyLinkedListNode }