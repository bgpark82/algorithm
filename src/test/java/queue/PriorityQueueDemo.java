package queue;

import java.util.*;

public class PriorityQueueDemo<T> {

    private static final int DEFAULT_INITIAL_CAPACITY = 11;
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;


    private Object[] queue;
    private Comparator<? super T> comparator;
    private int size;

    public PriorityQueueDemo(final int initialCapacity, final Comparator<? super T> comparator) {
        if (initialCapacity < 1) {
            throw new IllegalArgumentException();
        }
        this.queue = new Object[initialCapacity];
        this.comparator = comparator;
    }

    public PriorityQueueDemo(final int initialCapacity) {
        this(initialCapacity, null);
    }

    public PriorityQueueDemo() {
        this(DEFAULT_INITIAL_CAPACITY, null);
    }

    public PriorityQueueDemo(final Collection<T> collection) {
        this.comparator = null;
        initFromCollection(collection);
    }

    private void initFromCollection(final Collection<T> collection) {
        initElementsFromCollection(collection);
        heapify();
    }

    private void heapify() {
        // 2로 나눈 것에서 한칸씩 줄이기
        for (int i = (size >>> 1) - 1; i >= 0; i--) {
            siftDown(i, (T) queue[i]);
        }
    }

    private void siftDown(final int position, final T item) {
        if (comparator != null) {

        } else {
            siftDownComparable(position, item);
        }
    }

    // heap                 position    child   heap[child]      right  heap[right]
    // 1 6 [2] 8 3 {5} {8},   2           5       5                6      8
    // 1 [6] 2 {8} {3} 5 8,   1 -> 4      3 -> 4  8 -> 3           4      3
    // [1] {3} {2} 8 6 5 8,   0           1 -> 2  3                2      2
    private void siftDownComparable(int position, T item) {
        Comparable<? super T> key = (Comparable<? super T>) item;
        int halfSize = size >>> 1;
        while (position < halfSize) {
            int child = (position << 1) + 1; // 오른쪽 끝??
            Object c = queue[child];
            int right = child + 1;
            if (right < size && ((Comparable<? super T>) c).compareTo((T) queue[right]) > 0) {
                c = queue[child = right];
            }
            if (key.compareTo((T) c) <= 0) {
                break;
            }
            queue[position] = c;
            position = child;
        }
        queue[position] = key;
    }

    private void initElementsFromCollection(final Collection<T> collection) {
        Object[] a = collection.toArray();
        if (a.getClass() != Object[].class) {
            a = Arrays.copyOf(a, a.length, Object[].class);
        }
        this.queue = a;
        this.size = a.length;
    }

    public boolean add(final T e) {
        if (Objects.isNull(e)) {
            throw new NullPointerException();
        }
        int i = size;
        if (i >= queue.length) {
            grow(i + 1);
        }
        size = i + 1;
        // 첫 입력값
        if (i == 0) {
            queue[0] = e;
        } else {
            siftUp(i, e);
        }
        return true;
    }

    public void siftUp(int index, T value) {
        siftUpComparable(index, value);
    }

    private void siftUpComparable(int index, T value) {
        Comparable<? super T> key = (Comparable<? super T>) value;
        while (index > 0) {
            int parent = (index - 1) >>> 1;
            Object e = queue[parent];
            if (key.compareTo((T) e) >= 0) {
                break;
            }
            queue[index] = e;
            index = parent;
        }
        queue[index] = key;
    }

    public void grow(int minCapacity) {
        int oldCapacity = queue.length;
        int newCapacity = oldCapacity + ((oldCapacity < 64) ? oldCapacity + 2 : oldCapacity >> 1);

        //Integer.MAX_VALUE 보다 큰 값
        if (newCapacity - MAX_ARRAY_SIZE > 0) {
            newCapacity = hugeCapacity(minCapacity);
        }
        queue = Arrays.copyOf(queue, newCapacity);
    }

    public int hugeCapacity(final int minCapacity) {
        return minCapacity > MAX_ARRAY_SIZE ?
                Integer.MAX_VALUE :
                MAX_ARRAY_SIZE;
    }
}
