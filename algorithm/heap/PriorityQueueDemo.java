import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueDemo {
    
    public static void main(String[] args) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(10);
        maxHeap.add(30);
        maxHeap.add(40);
        maxHeap.add(20);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(10);
        minHeap.add(30);
        minHeap.add(40);
        minHeap.add(20);

        System.out.println(maxHeap.peek());
        System.out.println(minHeap.peek());
    }
}
