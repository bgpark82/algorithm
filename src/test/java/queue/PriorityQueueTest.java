package queue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class PriorityQueueTest {

    @Test
    void constructor() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new PriorityQueueDemo<>(0, null));
    }

    @Test
    void constructor2() {
        new PriorityQueueDemo<Integer>(1, null);
        new PriorityQueueDemo<Integer>(1);
        new PriorityQueueDemo<Integer>();
    }

    @Test
    void collection() {
        List<Integer> list = Arrays.asList(1, 6, 2, 8, 3, 5, 8);

        Object[] objects = list.toArray();

        assertThat(objects.getClass() == Integer[].class).isTrue();
        assertThat(objects.getClass() == Object[].class).isFalse();

        Arrays.copyOf(objects, objects.length, Object[].class);
    }

    @Test
    void heapify() {
        List<Integer> list = Arrays.asList(1, 6, 2, 8, 3, 5, 8);

        // 10 >>> 1 : 2로 나눈 것
        assertThat(10 >>> 1).isEqualTo(10 / 2);
        assertThat(20 >>> 1).isEqualTo(20 / 2);
        assertThat(10 << 1).isEqualTo(10 * 2);
        new PriorityQueueDemo<>(list);
        PriorityQueue<Integer> pq = new PriorityQueue<>(list);
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }

    /**
     * add
     * 1. null 체크
     * 2. size 보다 크면 크기 증가
     * 3. heapify
     */
    @Test
    void add() {
        PriorityQueueDemo<Integer> pq = new PriorityQueueDemo<>();
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> pq.add(null))
        ;
    }

    @Test
    void grow() {
        PriorityQueueDemo<Integer> pq = new PriorityQueueDemo<>();
        pq.grow(1);
    }

    @DisplayName("hugeCapacity, Integer.MAX_VALUE 보다 큰 경우 Integer.MAX_VALUE 반환한다")
    @Test
    void hugeCapacity1() {
        int result = Integer.MAX_VALUE;

        PriorityQueueDemo<Integer> pq = new PriorityQueueDemo<>();
        int capacity = pq.hugeCapacity(Integer.MAX_VALUE);
        assertThat(capacity).isEqualTo(result);
    }

    @DisplayName("hugeCapacity, Integer.MAX_VALUE 보다 작은 경우 MAX_ARRAY_SIZE 반환한다")
    @Test
    void hugeCapacity2() {
        int result = Integer.MAX_VALUE - 8;

        PriorityQueueDemo<Integer> pq = new PriorityQueueDemo<>();
        int capacity = pq.hugeCapacity(1);
        assertThat(capacity).isEqualTo(result);
    }
}
