package greedy;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class B1202 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int jewelry_size = sc.nextInt();
        int bag_size = sc.nextInt();
        Jewelry[] jewelries = new Jewelry[jewelry_size];
        for (int i = 0; i < jewelry_size; i++) {
            int weight = sc.nextInt();
            int value = sc.nextInt();
            jewelries[i] = new Jewelry(weight, value, false);
        }

        TreeMap<Integer, Integer> bags = new TreeMap<>();
        for (int i = 0; i < bag_size; i++) {
            int max_weight = sc.nextInt();
            Integer count = bags.get(max_weight);
            if(count == null) {
                count = 0;
            }
            count += 1;
            bags.put(max_weight, count);
        }
        Arrays.sort(jewelries);
        long ans = 0;
        for (int i = 0; i < jewelry_size; i++) {
            /*
             * Tree Map
             * - BST (Binary Search Tree)
             * - 키를 오름차순으로 정렬
             * - 키와 크가나 같은 근사값을 가질 수 있다
             */
            Map.Entry<Integer, Integer> bag = bags.ceilingEntry(jewelries[i].weight);
            if(bag != null) {
                ans += jewelries[i].value;

                if(bag.getValue() - 1 == 0) {
                    bags.remove(bag.getKey());
                } else {
                    bags.put(bag.getKey(), bag.getValue() - 1);
                }
            }

        }

        System.out.println(ans);
    }

    static class Jewelry implements Comparable<Jewelry> {
        int weight;
        int value;
        boolean check;

        public Jewelry(int weight, int value, boolean check) {
            this.weight = weight;
            this.value = value;
            this.check = check;
        }

        @Override
        public int compareTo(Jewelry that) {
            // 상대방이 나보다 더 커져야하므로 양수가 되서 오름차순
            if(this.value < that.value) {
                return 1;
            } else if(this.value > that.value) {
                return -1;
            } else {
                return 0;
            }
        }

        @Override
        public String toString() {
            return "Jewelry{" +
                    "weight=" + weight +
                    ", value=" + value +
                    ", check=" + check +
                    '}';
        }
    }
}


