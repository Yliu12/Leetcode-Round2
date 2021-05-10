
import {DoublyLinkedListNode} from './InsertIntoDoubleLinkedList'
function reverse(head: DoublyLinkedListNode): DoublyLinkedListNode {
    // Write your code here
    let result = null;
    while(head!= null){
        const prev = head.prev;
        head.prev = head.next;
        head.next = prev;
        head = head.prev;
        result = prev;
    }
    return result;
}