package data_structure.linked_list.singly_linked_list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SinglyLinkedListTest {

    SinglyLinkedList<Integer> first;
    SinglyLinkedList<Integer> second;
    SinglyLinkedList<Integer> third;
    SinglyLinkedList<Integer> fourth;

    @BeforeEach
    void setUp() {
        first = new SinglyLinkedList<>(1);
        second = new SinglyLinkedList<>(2);
        third = new SinglyLinkedList<>(3);
        fourth = new SinglyLinkedList<>(4);
    }

    @Test
    void create() {
        assertThat(first.getValue()).isEqualTo(1);
    }

    @Test
    void setData() {
        first.setData(2);
        assertThat(first.getValue()).isEqualTo(2);
    }

    @Test
    void setNext() {
        SinglyLinkedList<Integer> next = new SinglyLinkedList<>(2);
        first.setNext(next);
        assertThat(first.getNext()).isEqualTo(next);
    }

    @Test
    void iterate() {
        second.setNext(first);
        third.setNext(second);
        fourth.setNext(third);

        print(first);
    }

    @Test
    void find() {
        first.setNext(second);
        second.setNext(third);
        assertThat(second.find(first, 3)).isEqualTo(third);
        assertThat(second.find(first, 4)).isEqualTo(null);
    }

    private void print(SinglyLinkedList<Integer> head) {
        while (head != null) {
            System.out.println(head.getValue());
            head = head.getNext();
        }
    }


}