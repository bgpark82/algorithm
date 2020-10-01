package greedy;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B1202 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int jewelry_size = sc.nextInt();
        int bag_size = sc.nextInt();

        Jewelry[] jewelries = new Jewelry[jewelry_size + bag_size];

        for (int i = 0; i < jewelry_size; i++) {
            int weight = sc.nextInt();
            int value = sc.nextInt();
            jewelries[i] = new Jewelry(weight,value,0);
        }
        for (int i = 0; i < bag_size; i++) {
            int max_weight = sc.nextInt();
            jewelries[jewelry_size + i] = new Jewelry(max_weight, 0, 1);
        }
        Arrays.sort(jewelries);
        PriorityQueue<Integer> q = new PriorityQueue<>();
        long answer = 0;
        for (Jewelry jewelry: jewelries) {
            if(jewelry.diff == 0) {
                // 보석만 빼서 큐에 넣는다
                q.offer(-jewelry.value);
            } else {
                // 가방일 경우는 오름차순으로 정렬되어 있으므로 가장 작은 무게 중에 가장 비싼 보석 먼저 꺼내게 된다
                if(!q.isEmpty()) {
                    answer += -q.poll();
                }
            }
        }
        System.out.println(answer);
    }

    static class Jewelry implements Comparable<Jewelry>{
        int weight;
        int value;
        int diff;

        public Jewelry(int weight, int value, int diff) {
            this.weight = weight;
            this.value = value;
            this.diff = diff;
        }

        @Override
        public int compareTo(Jewelry that) {
            // 오름차순
            if(this.weight < that.weight) {
                return -1;
            } else if(this.weight == that.weight) {
                // 오른차순
                if(this.diff < that.diff) return -1;
                else if(this.diff == that.diff) return 0;
                else return 1;
            } else {
                return 1;
            }
        }
    }
}
