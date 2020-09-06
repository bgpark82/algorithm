package data_structure;

import org.junit.Test;

import java.util.PriorityQueue;

public class PriorityQueueTest {

    @Test
    public void basic() {

        PriorityQueue<Prisoner> priorityQueue = getPriorityQueue();

        System.out.println("=============== Normal Order");

        while (!priorityQueue.isEmpty()) {
            Prisoner prisoner = priorityQueue.poll();
            System.out.println(prisoner.name);
        }
    }

    @Test
    public void value() {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.offer(5);
        q.offer(3);
        q.offer(1);
        q.offer(2);
        q.offer(4);
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
    }

    private static PriorityQueue<Prisoner> getPriorityQueue() {

        Prisoner prisoner1 = new Prisoner("james", 5);
        Prisoner prisoner2 = new Prisoner("schofield", 99);
        Prisoner prisoner3 = new Prisoner("alex", 14);
        Prisoner prisoner4 = new Prisoner("silvia", 10);
        Prisoner prisoner5 = new Prisoner("thomson", 1);

        PriorityQueue<Prisoner> priorityQueue = new PriorityQueue<Prisoner>();

        priorityQueue.offer(prisoner1);
        priorityQueue.offer(prisoner2);
        priorityQueue.offer(prisoner3);
        priorityQueue.offer(prisoner4);
        priorityQueue.offer(prisoner5);

        return priorityQueue;
    }

    static class Prisoner implements Comparable<Prisoner> {

        String name;
        int weight; // 형량

        public Prisoner(String name, int weight) {
            super();
            this.name = name;
            this.weight = weight;
        }

        @Override
        public int compareTo(Prisoner target) {
            if (this.weight > target.weight) {
                return 1;
            } else if (this.weight < target.weight) {
                return -1;
            }
            return 0;
        }
    }

}
