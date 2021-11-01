package data_structure.linked_list.singly_linked_list;

public class SinglyLinkedList<T> {

    private SinglyLinkedList<T> next;
    private T data;

    public SinglyLinkedList(T data) {
        this.next = null;
        this.data = data;
    }

    public T getValue() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNext(SinglyLinkedList<T> next) {
        this.next = next;
    }

    public SinglyLinkedList<T> getNext() {
        return this.next;
    }

    /**
     * Time Complexity : O(n)
     *
     * @param head
     * @param data
     * @return node
     */
    public SinglyLinkedList<T> find(SinglyLinkedList<T> head, T data) {
        while (head != null) {
            if (head.data == data) {
                return head;
            }
            head = head.next;
        }
        return null;
    }
}
